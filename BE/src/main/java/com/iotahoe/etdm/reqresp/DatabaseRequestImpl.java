package com.iotahoe.etdm.reqresp;

import lombok.Data;

import java.util.Properties;

@Data
public class DatabaseRequestImpl implements DataSourceRequest, IdAliasAware {
    Long id;
    String type;
    String alias;
    String login;
    String password;
    String url;
    String action;
    Properties driverParams;

    @Override
    public String getDriverClassName() {
        // TODO Auto-generated method stub
        return null;
    }
}
