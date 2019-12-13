package com.iotahoe.etdm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * CDatabaseTableType
 */
@Entity
@Data
@Table(schema = "dbw", name = "c_database_table_type")
public class CDatabaseTableType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appId")
    Long id;

    @JoinColumn(name = "db_id")
    @ManyToOne(fetch = FetchType.LAZY)
    CDatabase database;

    String jdbcTableType;

}