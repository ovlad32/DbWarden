package com.iotahoe.etdm.services.reqresp;

import lombok.Data;

@Data
public class CDatabaseReq {
    Integer id;
    String type;
    String alias;
    String login;
    String password;
    String url;
    String action;
}
