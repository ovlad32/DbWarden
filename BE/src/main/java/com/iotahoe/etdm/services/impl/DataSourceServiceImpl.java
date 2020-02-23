package com.iotahoe.etdm.services.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

import com.iotahoe.etdm.reqresp.CDatabaseResponse;
import com.iotahoe.etdm.reqresp.DataSourceRequest;
import com.iotahoe.etdm.services.DataSourceService;

/**
 * DataSourceImpl
 */
public class DataSourceServiceImpl implements DataSourceService<CDatabaseResponse> {

    @Override
    public Map<String, String> validate(DataSourceRequest ireq) {
        final Map<String, String> messages = new HashMap<>();

        if (Objects.isNull(ireq.getType())) {
            messages.put("type", "DBMS type is null");
        } else if (ireq.getType().trim().isEmpty()) {
            messages.put("type", "DBMS type is not specified");
        }

        /*
         * if (Objects.isNull(ireq.getAlias())) { messages.put("alias",
         * "Alias is null"); } else if (ireq.getAlias().trim().isEmpty()) {
         * messages.put("alias", "Alias is not specified"); }
         */
        if (Objects.isNull(ireq.getUrl())) {
            messages.put("url", "URL is null");
        } else if (ireq.getUrl().trim().isEmpty()) {
            messages.put("url", "URL is not specified");
        }

        if (Objects.isNull(ireq.getLogin())) {
            messages.put("login", "Login is null");
        } else if (ireq.getLogin().trim().isEmpty()) {
            messages.put("login", "Login is not specified");
        }

        if (Objects.isNull(ireq.getPassword())) {
            messages.put("password", "Password is null");
        } else if (ireq.getPassword().trim().isEmpty()) {
            messages.put("password", "Password is not specified");
        }
        return messages;

    }

    @Override
    public Map<String, String> testConnection(DataSourceRequest ireq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CDatabaseResponse withConnection(DataSourceRequest iReq,
            BiFunction<CDatabaseResponse, Connection, CDatabaseResponse> f) {
        // TODO Auto-generated method stub
        return null;
    }

}