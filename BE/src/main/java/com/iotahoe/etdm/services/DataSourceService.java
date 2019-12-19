package com.iotahoe.etdm.services;

import java.sql.Connection;
import java.util.Map;
import java.util.function.BiFunction;

import javax.sql.DataSource;

/**
 * DataSourceService
 */
public interface DataSourceService<T> {
    Map<String, String> validate(IDataSourceRequest ireq);

    Map<String, String> testConnection(IDataSourceRequest ireq);

    // DataSource create(IDataSourceRequest iReq);

    T withConnection(IDataSourceRequest iReq, BiFunction<T, Connection, T> f);

}