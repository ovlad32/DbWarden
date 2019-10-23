package com.iotahoe.etdm.services;

import java.util.Map;

import com.iotahoe.etdm.entities.CDatabase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CDatabaseService {
    Page<CDatabase> all(Pageable pageable, Map<String, String> filters);
}
