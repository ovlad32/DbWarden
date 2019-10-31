package com.iotahoe.etdm.entities;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.*;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(schema = "dbw", name = "c_database")
@Data
public class CDatabase {
    @Id
    @SequenceGenerator(schema = "dbw", sequenceName = "app_id", name = "appSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appSeq")
    private Long Id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type")
    RDatabaseType databaseType;
    private String alias;
    private String url;
    private String login;
    private String password;
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
    private ZonedDateTime whenAvailable;
}
