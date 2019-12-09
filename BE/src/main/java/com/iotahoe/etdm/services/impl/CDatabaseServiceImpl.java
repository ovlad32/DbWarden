package com.iotahoe.etdm.services.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import com.iotahoe.etdm.entities.CDatabase;
import com.iotahoe.etdm.entities.CDatabaseTableType;
import com.iotahoe.etdm.entities.RDatabaseType;
import com.iotahoe.etdm.repositories.CDatabaseRepository;
import com.iotahoe.etdm.repositories.RDatabaseTypeRepository;
import com.iotahoe.etdm.services.CDatabaseService;
import com.iotahoe.etdm.services.IDatabaseReq;
import com.iotahoe.etdm.services.mapper.CDatabaseMapper;
import com.iotahoe.etdm.services.reqresp.CDatabaseResp;
import com.iotahoe.etdm.services.reqresp.IdReq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class CDatabaseServiceImpl implements CDatabaseService {
    private static final Logger logger = LoggerFactory.getLogger(CDatabaseServiceImpl.class);
    @Resource
    CDatabaseRepository databaseRepository;
    @Resource
    RDatabaseTypeRepository databaseTypeRepository;

    @Override
    public Page<CDatabaseResp> all(final Pageable pageable, final Map<String, String> filters) {
        return databaseRepository.findAll(new CDatabaseSpecification(filters), pageable)
                .map(t -> CDatabaseMapper.INSTANCE.toResp(t));
    }

    private DataSource toDataSource(final IDatabaseReq req) {
        if (req == null) {
            throw new IllegalArgumentException("Argument is not initialized");
        }

        final RDatabaseType rtype = databaseTypeRepository.findByType(req.getType());
        if (rtype == null) {
            throw new IllegalArgumentException("DBMS type is not recognized");
        }

        try {
            final DataSourceBuilder dsb = DataSourceBuilder.create();
            dsb.driverClassName(rtype.getDriver());
            dsb.username(req.getLogin());
            dsb.password(req.getPassword());
            dsb.url(req.getUrl());
            return dsb.build();
        } catch (final Throwable e) {
            throw new RuntimeException("Could not load database driver class " + rtype.getDriver(), e);
        }
    }

    private CDatabase toCDatabase(final IdReq req, Consumer<DataSource> c) {
        if (req == null || req.getId() == null) {
            throw new IllegalArgumentException();
        }
        final CDatabase database = databaseRepository.getOne(req.getId());
        c.accept(toDataSource(database));
        return database;
    }

    @Override
    public Map<String, String> validateRequest(final IDatabaseReq req) {
        final Map<String, String> messages = new HashMap<>();

        if (Objects.isNull(req.getType())) {
            messages.put("type", "DBMS type is null");
        } else if (req.getType().trim().isEmpty()) {
            messages.put("type", "DBMS type is not specified");
        }

        if (Objects.isNull(req.getAlias())) {
            messages.put("alias", "Alias is null");
        } else if (req.getAlias().trim().isEmpty()) {
            messages.put("alias", "Alias is not specified");
        }

        if (Objects.isNull(req.getUrl())) {
            messages.put("url", "URL is null");
        } else if (req.getUrl().trim().isEmpty()) {
            messages.put("url", "URL is not specified");
        }

        if (Objects.isNull(req.getLogin())) {
            messages.put("login", "Login is null");
        } else if (req.getLogin().trim().isEmpty()) {
            messages.put("login", "Login is not specified");
        }

        if (Objects.isNull(req.getPassword())) {
            messages.put("password", "Password is null");
        } else if (req.getPassword().trim().isEmpty()) {
            messages.put("password", "Password is not specified");
        }
        return messages;
    }

    @Override
    public CDatabaseResp checkAvailability(final IdReq req) {
        AtomicReference<CDatabase.Status> status = new AtomicReference(CDatabase.Status.UNKNOWN);
        final CDatabase db = toCDatabase(req, (ds) -> {
            try (Connection conn = ds.getConnection()) {
                if (!conn.isClosed()) {
                    status.set(CDatabase.Status.AVAILABLE);
                }
            } catch (final SQLException e) {
                status.set(CDatabase.Status.DEAD);
            }
        });
        databaseRepository.updateAvailability(req.getId(), status.get());
        final CDatabaseResp resp = CDatabaseMapper.INSTANCE.toResp(db);
        resp.setWhenAvailable(ZonedDateTime.now());
        return resp;
    }

    @Transactional
    @Override
    public CDatabaseResp save(final IDatabaseReq req) {
        CDatabase database = CDatabaseMapper.INSTANCE.toEntity(req);
        database = databaseRepository.save(database);

        return CDatabaseMapper.INSTANCE.toResp(database);
    }

    @Override
    public CDatabaseResp testConnection(IDatabaseReq req) {
        final Map<String, String> messages = new HashMap<>();
        final CDatabaseResp resp = CDatabaseResp.builder().errorMessages(messages).build();
        if (req.getId() != null) {
            final CDatabase database = databaseRepository.getOne(req.getId());
            if (req.getLogin() != null)
                database.setLogin(req.getLogin());
            if (req.getPassword() != null)
                database.setLogin(req.getPassword());
            if (req.getUrl() != null)
                database.setLogin(req.getUrl());
            req = database;
        } else {
            messages.putAll(validateRequest(req));
        }

        if (!messages.isEmpty()) {
            resp.getErrorMessages().putAll(messages);
            return resp;
        }

        DataSource ds = null;
        try {
            ds = toDataSource(req);
        } catch (final Throwable e) {
            resp.getErrorMessages().put("*", e.getMessage());
            return resp;
        }

        try (Connection conn = ds.getConnection()) {
            try {
                conn.rollback();
            } catch (final Throwable e) {
            }

        } catch (final Throwable e) {
            resp.getErrorMessages().put("*", e.getMessage());
            return resp;
        }

        return resp;
    }

    public void tableTypes(final DatabaseMetaData md, Consumer<CDatabaseTableType> c) throws SQLException {
        ResultSet rs = md.getTableTypes();
        while (rs.next()) {
            CDatabaseTableType ent = new CDatabaseTableType();
            c.accept(ent);
        }
    }

    public void databaseMetaData(final DatabaseMetaData md, Consumer<Map.Entry<String, String>> c) throws SQLException {
        StopWatch tracker = new StopWatch();
        tracker.start();
        String currentName = "metadataInfo";
        for (Field f : md.getClass().getFields()) {
            if (Modifier.isPublic(f.getModifiers())) {
                try {
                    c.accept(new AbstractMap.SimpleEntry<>(f.getName(), String.valueOf(f.get(md))));
                } catch (Exception e) {

                }
            }
        }
        Object[] emptyArgs = new Object[0];
        for (Method m : md.getClass().getDeclaredMethods()) {
            if ((m.getReturnType().isPrimitive() || m.getReturnType().equals(String.class))
                    && Modifier.isPublic(m.getModifiers()) && m.getParameterTypes().length == 0) {
                try {
                    c.accept(new AbstractMap.SimpleEntry<>(m.getName(), String.valueOf(m.invoke(md, emptyArgs))));
                } catch (Exception e) {
                }
            }
        }
        tracker.stop();
        // logger.info("Method {} took {}", currentName, tracker.getTime());
    }

    // private Function<List<CDatabaseTableType>,
    /*
     * public void takeSnapshot(final IdReq req) { if (req == null || req.getId() ==
     * null) { throw new IllegalArgumentException("Parameter ID is empty!"); } final
     * CDatabase database = databaseRepository.getOne(req.getId()); final DataSource
     * ds = buildDataSource(database); try (Connection conn = ds.getConnection()) {
     * final DatabaseMetaData dbm = conn.getMetaData(); dbm.getTables(null, null,
     * null, types);
     * 
     * } catch (final SQLException e) {
     * 
     * } }
     */
}
