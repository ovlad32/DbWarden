package com.iotahoe.etdm.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(schema = "dw", name = "x_snapshot")
public class XSnapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appSeq")

    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "db_id")
    private CDatabase db;
    private Timestamp taken;
    private String label;
}
