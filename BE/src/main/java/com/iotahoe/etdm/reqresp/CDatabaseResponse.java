package com.iotahoe.etdm.reqresp;

import java.time.ZonedDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CDatabaseResponse {
    Long id;
    String type;
    String alias;
    String login;
    String url;
    ZonedDateTime whenAvailable;
    Map<String, String> errorMessages;
}
