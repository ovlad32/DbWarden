package com.iotahoe.etdm.services;

import java.util.Map;

import com.iotahoe.etdm.reqresp.CDatabaseResponse;
import com.iotahoe.etdm.reqresp.DatabaseRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CDatabaseService {
    Page<CDatabaseResponse> all(Pageable pageable, Map<String, String> filters);

    // Map<String, String> validateDataSourceRequisites(DatabaseRequest req);

    // Map<String, String> validateDatabaseAttributes(IDatabaseReq req);

    // CDatabaseResp checkAvailability(IdReq req);

    // CDatabaseResp testConnection(IDatabaseReq req);

    CDatabaseResponse save(DatabaseRequest req);

}
