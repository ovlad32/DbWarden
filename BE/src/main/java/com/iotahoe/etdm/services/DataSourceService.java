package com.iotahoe.etdm.services;

import java.sql.Connection;
import java.util.Map;
import java.util.function.BiFunction;

import javax.sql.DataSource;

import com.iotahoe.etdm.reqresp.DataSourceRequest;

/**
 * DataSourceService
 */
public interface DataSourceService<T> {
    Map<String, String> validate(DataSourceRequest ireq);

    Map<String, String> testConnection(DataSourceRequest ireq);

    // DataSource create(IDataSourceRequest iReq);

    T withConnection(DataSourceRequest iReq, BiFunction<T, Connection, T> f);

}