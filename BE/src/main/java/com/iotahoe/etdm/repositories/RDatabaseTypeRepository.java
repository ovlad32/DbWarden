package com.iotahoe.etdm.repositories;

import com.iotahoe.etdm.entities.RDatabaseType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RDatabaseTypeRepository extends JpaRepository<RDatabaseType, Long> {
    RDatabaseType findByType(String type);
}
