package com.iotahoe.etdm.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(schema = "dbw", name = "x_snapshot")
public class XSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appId")

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "db_id")
    private CDatabase db;
    private Timestamp taken;
    private String label;
}
