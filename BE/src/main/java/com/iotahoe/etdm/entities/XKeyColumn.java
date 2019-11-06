package com.iotahoe.etdm.entities;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class XKeyColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "snapshot_id")
    private XSnapshot snapshot;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "db_id")
    private CDatabase db;

    @Column(name = "table_id")
    private XTable table;

    @Column(name = "column_id")
    private XTableColumn column;

    private String refColumnName;

    private Integer position;

}
