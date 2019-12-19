package com.iotahoe.etdm.services;

import java.util.Map;

import com.iotahoe.etdm.services.reqresp.CDatabaseResp;
import com.iotahoe.etdm.services.reqresp.IdReq;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CDatabaseService {
    Page<CDatabaseResp> all(Pageable pageable, Map<String, String> filters);

    Map<String, String> validateDataSourceRequisites(IDatabaseReq req);

    Map<String, String> validateDatabaseAttributes(IDatabaseReq req);

    CDatabaseResp checkAvailability(IdReq req);

    CDatabaseResp testConnection(IDatabaseReq req);

    CDatabaseResp save(IDatabaseReq req);

}
