package com.iotahoe.etdm.reqresp;

/**
 * DatabaseRequest
 */
public interface DatabaseRequest extends IdAware {

    String getAlias();

    String getUrl();

    String getLogin();

    String getPassword();

    String getType();

}