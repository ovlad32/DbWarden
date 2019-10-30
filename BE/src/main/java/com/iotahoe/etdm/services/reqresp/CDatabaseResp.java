package com.iotahoe.etdm.services.reqresp;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CDatabaseResp {
    Integer id;
    String type;
    String alias;
    String login;
    String url;
    Map<String, String> errorMessages;
}
