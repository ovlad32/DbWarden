package com.iotahoe.etdm.services.impl;

import java.util.Map;

import javax.annotation.Resource;

import com.iotahoe.etdm.entities.CDatabase;
import com.iotahoe.etdm.repositories.CDatabaseRepository;
import com.iotahoe.etdm.services.CDatabaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CDatabaseServiceImpl implements CDatabaseService {
    @Resource
    CDatabaseRepository databaseRepository;

    @Override
    public Page<CDatabase> all(Pageable pageable, Map<String, String> filters) {
        return databaseRepository.findAll(new CDatabaseSpecification(filters), pageable);
    }

}
