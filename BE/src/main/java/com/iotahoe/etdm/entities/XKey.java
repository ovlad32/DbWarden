package com.iotahoe.etdm.entities;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class XKey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appSeq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ss_id")
    private XSnapshot snapshot;

    @Column(name ="db_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CDatabase db;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="table_id")
    private XTable table;

    private String keyName;
    private String keyType;

    private String refTable;
    private String refSchema;
    private String refKeyName;

}
