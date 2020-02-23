package com.iotahoe.etdm.reqresp;

/**
 * IDataSourceRequest
 */
public interface DataSourceRequest {

    public String getType();

    public String getDriverClassName();

    public String getUrl();

    public String getLogin();

    public String getPassword();
}