package com.iotahoe.etdm.services.impl;

import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import com.iotahoe.etdm.entities.RDatabaseType;
import com.iotahoe.etdm.repositories.RDatabaseTypeRepository;
import com.iotahoe.etdm.services.RDatabaseTypeService;

import org.springframework.stereotype.Component;

@Component
public class RDatabaseTypeServiceImpl implements RDatabaseTypeService {
    @Resource
    RDatabaseTypeRepository repository;

    @Override
    public List<RDatabaseType> getAll() {
        List<RDatabaseType> result = repository.findAll();
        result.sort(Comparator.comparing(RDatabaseType::getIOrder));
        return result;
    }

}
