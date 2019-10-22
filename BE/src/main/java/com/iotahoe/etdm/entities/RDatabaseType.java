package com.iotahoe.etdm.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_database_type")
@Data
public class RDatabaseType {
    @Id
    private String type;
    private String name;
    private String realm;
    private Integer iOrder;
    private String driver;
}
