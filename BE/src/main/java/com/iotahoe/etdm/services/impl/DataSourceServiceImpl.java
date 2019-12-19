package com.iotahoe.etdm.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

import com.iotahoe.etdm.services.DataSourceService;
import com.iotahoe.etdm.services.IDataSourceRequest;

/**
 * DataSourceImpl
 */
public class DataSourceServiceImpl implements DataSourceService {

    @Override
    public Map<String, String> validate(IDataSourceRequest ireq) {
        final Map<String, String> messages = new HashMap<>();

        if (Objects.isNull(ireq.getType())) {
            messages.put("type", "DBMS type is null");
        } else if (ireq.getType().trim().isEmpty()) {
            messages.put("type", "DBMS type is not specified");
        }

        if (Objects.isNull(ireq.getAlias())) {
            messages.put("alias", "Alias is null");
        } else if (ireq.getAlias().trim().isEmpty()) {
            messages.put("alias", "Alias is not specified");
        }

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
    public Map<String, String> testConnection(IDataSourceRequest ireq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object withConnection(IDataSourceRequest iReq, BiFunction f) {
        // TODO Auto-generated method stub
        return null;
    }

}