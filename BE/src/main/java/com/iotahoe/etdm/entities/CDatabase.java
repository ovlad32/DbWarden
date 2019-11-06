package com.iotahoe.etdm.entities;

import lombok.Data;

import java.time.ZonedDateTime;

import javax.persistence.*;
import javax.persistence.Table;

import com.iotahoe.etdm.services.IDatabaseReq;

import org.hibernate.annotations.Type;

@Entity
@Table(schema = "dbw", name = "c_database")
@Data
@SequenceGenerator(name = "appId", schema = "dbw", sequenceName = "app_id")
public class CDatabase implements IDatabaseReq {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appId")
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

    @Override
    public String getType() {
        if (this.databaseType != null) {
            return this.databaseType.getType();
        }
        return null;
    }
}
