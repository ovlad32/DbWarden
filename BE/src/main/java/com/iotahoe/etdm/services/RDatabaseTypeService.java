package com.iotahoe.etdm.services;


import com.iotahoe.etdm.entities.RDatabaseType;

import javax.sql.DataSource;
import java.util.Collection;

public interface RDatabaseTypeService {
    Collection<RDatabaseType> getAll();
    DataSource dataSource(RDatabaseType type);
}
