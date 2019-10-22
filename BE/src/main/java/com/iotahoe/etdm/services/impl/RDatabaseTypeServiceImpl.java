package com.iotahoe.etdm.services.impl;

import com.iotahoe.etdm.entities.RDatabaseType;
import com.iotahoe.etdm.repositories.RDatabaseTypeRepository;
import com.iotahoe.etdm.services.RDatabaseTypeService;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Driver;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class RDatabaseTypeServiceImpl implements RDatabaseTypeService {
    @Resource
    RDatabaseTypeRepository repository;

    @Override
    public List<RDatabaseType> getAll() {
        List<RDatabaseType> result =  repository.findAll();
        result.sort(
                Comparator.comparing(RDatabaseType::getIOrder)
        );
        return result;
    }

    @Override
    public DataSource dataSource( RDatabaseType type) {
            DataSource source = new DriverManagerDataSource(type.getDriver());
            return source;
    }

}
