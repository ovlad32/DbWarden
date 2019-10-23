package com.iotahoe.etdm.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RDatabaseType.class)
public abstract class RDatabaseType_ {

	public static volatile SingularAttribute<RDatabaseType, String> driver;
	public static volatile SingularAttribute<RDatabaseType, String> name;
	public static volatile SingularAttribute<RDatabaseType, String> realm;
	public static volatile SingularAttribute<RDatabaseType, String> type;
	public static volatile SingularAttribute<RDatabaseType, Integer> iOrder;

	public static final String DRIVER = "driver";
	public static final String NAME = "name";
	public static final String REALM = "realm";
	public static final String TYPE = "type";
	public static final String I_ORDER = "iOrder";

}

