package com.iotahoe.etdm.entities;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(XSnapshot.class)
public abstract class XSnapshot_ {

	public static volatile SingularAttribute<XSnapshot, Timestamp> taken;
	public static volatile SingularAttribute<XSnapshot, Long> id;
	public static volatile SingularAttribute<XSnapshot, String> label;
	public static volatile SingularAttribute<XSnapshot, CDatabase> db;

	public static final String TAKEN = "taken";
	public static final String ID = "id";
	public static final String LABEL = "label";
	public static final String DB = "db";

}

