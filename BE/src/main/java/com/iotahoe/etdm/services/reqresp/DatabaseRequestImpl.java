package com.iotahoe.etdm.services.reqresp;

import lombok.Data;

import java.util.Properties;

import com.iotahoe.etdm.services.*;

@Data
public class DatabaseRequestImpl implements DataSourceRequest, IdReqest {
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
