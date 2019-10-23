package com.iotahoe.etdm.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "dw", name = "x_table")
@Data
public class XTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appSeq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ss_id")
    private XSnapshot snapshot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "db_id")
    private CDatabase db;

    private String schemaName;
    private String tableName;
    private Long rowCount;
    private Long bytes;
}
