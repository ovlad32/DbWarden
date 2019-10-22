package com.iotahoe.etdm.entities;


import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(schema = "dbw", name = "c_database")
@Data
public class CDatabase {
    @Id
    @SequenceGenerator(schema = "dbw", sequenceName = "app_id", name = "appSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "appSeq")
    private Long Id;
    private String type;
    private String name;
    private String url;
    private String login;
    private String password;
}
