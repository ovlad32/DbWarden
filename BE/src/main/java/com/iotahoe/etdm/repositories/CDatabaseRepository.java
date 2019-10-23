package com.iotahoe.etdm.repositories;

import javax.annotation.Resources;

import com.iotahoe.etdm.entities.CDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CDatabaseRepository extends JpaRepository<CDatabase, Long>, JpaSpecificationExecutor<CDatabase> {

}
