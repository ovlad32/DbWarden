package com.iotahoe.etdm.services.impl;

import java.sql.Driver;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import com.iotahoe.etdm.entities.RDatabaseType;
import com.iotahoe.etdm.repositories.CDatabaseRepository;
import com.iotahoe.etdm.repositories.RDatabaseTypeRepository;
import com.iotahoe.etdm.services.CDatabaseService;
import com.iotahoe.etdm.services.mapper.CDatabaseMapper;
import com.iotahoe.etdm.services.reqresp.CDatabaseReq;
import com.iotahoe.etdm.services.reqresp.CDatabaseResp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
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

    @Override
    public CDatabaseResp checkConnection(CDatabaseReq req) {
        CDatabaseResp resp = CDatabaseResp.builder().errorMessage(Collections.emptyList()).build();
        if (Objects.isNull(req.getType())) {
            resp.getErrorMessage().add("DBMS type is null");
        } else if (req.getType().trim().isEmpty()) {
            resp.getErrorMessage().add("DBMS type is not specified");
        }

        if (Objects.isNull(req.getAlias())) {
            resp.getErrorMessage().add("Alias is null");
        } else if (req.getAlias().trim().isEmpty()) {
            resp.getErrorMessage().add("Alias is not specified");
        }

        if (Objects.isNull(req.getUrl())) {
            resp.getErrorMessage().add("URL is null");
        } else if (req.getUrl().trim().isEmpty()) {
            resp.getErrorMessage().add("URL is not specified");
        }

        if (Objects.isNull(req.getLogin())) {
            resp.getErrorMessage().add("Login is null");
        } else if (req.getLogin().trim().isEmpty()) {
            resp.getErrorMessage().add("Login is not specified");
        }

        if (Objects.isNull(req.getPassword())) {
            resp.getErrorMessage().add("Password is null");
        } else if (req.getPassword().trim().isEmpty()) {
            resp.getErrorMessage().add("Password is not specified");
        }

        if (!resp.getErrorMessage().isEmpty()) {
            return resp;
        }

        RDatabaseType rtype = databaseTypeRepository.findByType(req.getType());
        if (rtype == null) {
            resp.getErrorMessage().add("DBMS type is not recognized");
            return resp;
        }
        Driver driver = null;
        try {
            driver = (Driver) Class.forName(rtype.getDriver()).newInstance();
        } catch (Throwable e) {
            resp.getErrorMessage().add("Could not load database driver class "+ rtype.getDriver()+":"+e.getMessage())
            return resp;
        }
        Properties connP
        driver.connect(req.getUrl(), )
        return resp;
    }

}
