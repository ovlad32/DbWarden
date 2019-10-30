package com.iotahoe.etdm.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CDatabase.class)
public abstract class CDatabase_ {

	public static volatile SingularAttribute<CDatabase, RDatabaseType> databaseType;
	public static volatile SingularAttribute<CDatabase, String> password;
	public static volatile SingularAttribute<CDatabase, String> alias;
	public static volatile SingularAttribute<CDatabase, Long> Id;
	public static volatile SingularAttribute<CDatabase, String> login;
	public static volatile SingularAttribute<CDatabase, String> url;

	public static final String DATABASE_TYPE = "databaseType";
	public static final String PASSWORD = "password";
	public static final String ALIAS = "alias";
	public static final String ID = "Id";
	public static final String LOGIN = "login";
	public static final String URL = "url";

}
