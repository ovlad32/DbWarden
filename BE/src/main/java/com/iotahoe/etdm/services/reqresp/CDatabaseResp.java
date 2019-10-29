package com.iotahoe.etdm.services.reqresp;

import java.util.List;

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
    List<String> errorMessage;
}
