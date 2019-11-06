package com.iotahoe.etdm.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "dbw", name = "x_table_column")
@Data
public class XTableColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appId")
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ss_id")
    private XSnapshot snapshot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "db_id")
    private CDatabase db;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tb_id")
    private XTable table;

    private String name;
    private Integer position;
    private Long uniqueCount;
    private Long emptyCount;

}
