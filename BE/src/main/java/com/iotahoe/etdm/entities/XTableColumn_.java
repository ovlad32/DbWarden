package com.iotahoe.etdm.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(XTableColumn.class)
public abstract class XTableColumn_ {

	public static volatile SingularAttribute<XTableColumn, Long> emptyCount;
	public static volatile SingularAttribute<XTableColumn, String> name;
	public static volatile SingularAttribute<XTableColumn, Long> Id;
	public static volatile SingularAttribute<XTableColumn, Integer> position;
	public static volatile SingularAttribute<XTableColumn, XSnapshot> snapshot;
	public static volatile SingularAttribute<XTableColumn, CDatabase> db;
	public static volatile SingularAttribute<XTableColumn, XTable> table;
	public static volatile SingularAttribute<XTableColumn, Long> uniqueCount;

	public static final String EMPTY_COUNT = "emptyCount";
	public static final String NAME = "name";
	public static final String ID = "Id";
	public static final String POSITION = "position";
	public static final String SNAPSHOT = "snapshot";
	public static final String DB = "db";
	public static final String TABLE = "table";
	public static final String UNIQUE_COUNT = "uniqueCount";

}
