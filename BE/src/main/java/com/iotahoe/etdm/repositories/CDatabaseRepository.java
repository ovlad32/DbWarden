package com.iotahoe.etdm.repositories;

import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import com.iotahoe.etdm.entities.CDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CDatabaseRepository extends JpaRepository<CDatabase, Long>, JpaSpecificationExecutor<CDatabase> {

    @Transactional
    @Query("update CDatabase set status = :status, whenAvailable = current_timestamp where id =:id ")
    void updateAvailability(@Param("id") Long id, @Param("status") CDatabase.Status status);
}
