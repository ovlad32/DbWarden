package com.iotahoe.etdm.services.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.iotahoe.etdm.entities.RDatabaseType;
import com.iotahoe.etdm.repositories.CDatabaseRepository;
import com.iotahoe.etdm.repositories.RDatabaseTypeRepository;
import com.iotahoe.etdm.services.CDatabaseService;
import com.iotahoe.etdm.services.mapper.CDatabaseMapper;
import com.iotahoe.etdm.services.reqresp.CDatabaseReq;
import com.iotahoe.etdm.services.reqresp.CDatabaseResp;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CDatabaseServiceImpl implements CDatabaseService {
    @Resource
    CDatabaseRepository databaseRepository;
    @Resource
    RDatabaseTypeRepository databaseTypeRepository;

    @Override
    public Page<CDatabaseResp> all(Pageable pageable, Map<String, String> filters) {
        return databaseRepository.findAll(new CDatabaseSpecification(filters), pageable)
                .map(t -> CDatabaseMapper.INSTANCE.toResp(t));
    }

    private DataSource buildDataSource(CDatabaseReq req) {
        RDatabaseType rtype = databaseTypeRepository.findByType(req.getType());
        if (rtype == null) {
            throw new IllegalArgumentException("DBMS type is not recognized");
        }

        try {
            DataSourceBuilder dsb = DataSourceBuilder.create();
            dsb.driverClassName(rtype.getDriver());
            dsb.username(req.getLogin());
            dsb.password(req.getPassword());
            dsb.url(req.getUrl());
            return dsb.build();
        } catch (Throwable e) {
            throw new RuntimeException("Could not load database driver class " + rtype.getDriver(), e);
        }
    }

    private Map<String, String> validateRequest(CDatabaseReq req) {
        Map<String, String> messages = new HashMap<>();

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
    }

    @Override
    public CDatabaseResp checkConnection(CDatabaseReq req) {
        CDatabaseResp resp = CDatabaseResp.builder().errorMessages(Collections.emptyMap()).build();
        Map<String, String> messages = validateRequest(req);
        if (!messages.isEmpty()) {
            resp.getErrorMessages().putAll(messages);
            return resp;
        }
        DataSource ds = null;
        try {
            ds = buildDataSource(req);
        } catch (RuntimeException e) {
            resp.getErrorMessages().put("*", e.getMessage());
            return resp;
        }
        try (Connection conn = ds.getConnection()) {
            conn.getMetaData()
        } catch (SQLException e) {
            resp.getErrorMessages().put("*", e.getMessage());
            return resp;
        }

        return resp;
    }

}
