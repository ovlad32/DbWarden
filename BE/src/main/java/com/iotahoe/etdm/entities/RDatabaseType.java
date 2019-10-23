package com.iotahoe.etdm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "r_database_type")
@Data
public class RDatabaseType {
    @Id
    private String type;
    private String name;
    private String realm;
    private String driver;
    private Integer iOrder;
}
