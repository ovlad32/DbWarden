package com.iotahoe.etdm.services.reqresp;

import lombok.Data;
import com.iotahoe.etdm.services.*;

@Data
public class CDatabaseReq implements IDatabaseReq {
    Integer id;
    String type;
    String alias;
    String login;
    String password;
    String url;
    String action;
}
