package com.iotahoe.etdm.repositories;

import com.iotahoe.etdm.entities.RDatabaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface RDatabaseTypeRepository extends JpaRepository<RDatabaseType,Long> {

}
