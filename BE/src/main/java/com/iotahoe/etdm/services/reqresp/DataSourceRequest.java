package com.iotahoe.etdm.services;

import java.util.Properties;

/**
 * IDataSourceRequest
 */
public interface DataSourceRequest {

    public String getType();

    public String getDriverClassName();

    public String getUrl();

    public String getLogin();

    public String getPassword();

    public Properties getDriverParams();

}