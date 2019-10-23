package com.iotahoe.etdm.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(XTable.class)
public abstract class XTable_ {

	public static volatile SingularAttribute<XTable, Long> bytes;
	public static volatile SingularAttribute<XTable, Long> id;
	public static volatile SingularAttribute<XTable, Long> rowCount;
	public static volatile SingularAttribute<XTable, String> schemaName;
	public static volatile SingularAttribute<XTable, XSnapshot> snapshot;
	public static volatile SingularAttribute<XTable, CDatabase> db;
	public static volatile SingularAttribute<XTable, String> tableName;

	public static final String BYTES = "bytes";
	public static final String ID = "id";
	public static final String ROW_COUNT = "rowCount";
	public static final String SCHEMA_NAME = "schemaName";
	public static final String SNAPSHOT = "snapshot";
	public static final String DB = "db";
	public static final String TABLE_NAME = "tableName";

}

