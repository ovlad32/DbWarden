package com.iotahoe.etdm.services.reqresp;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDatabaseResp {
    Integer id;
    String type;
    String alias;
    String login;
    String url;
    Map<String, String> errorMessages;
}
