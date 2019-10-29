package com.iotahoe.etdm.services;

import java.util.Map;
import java.util.Properties;

import com.iotahoe.etdm.services.reqresp.CDatabaseReq;
import com.iotahoe.etdm.services.reqresp.CDatabaseResp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CDatabaseService {
    Page<CDatabaseResp> all(Pageable pageable, Map<String, String> filters);

    CDatabaseResp checkConnection(CDatabaseReq req);
}
