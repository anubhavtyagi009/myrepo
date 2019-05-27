package com.bec.orrreporting.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimClassEntity.class)
public abstract class DimClassEntity_ {

	public static volatile SingularAttribute<DimClassEntity, Long> dimClassId;
	public static volatile SingularAttribute<DimClassEntity, Integer> classId;
	public static volatile SingularAttribute<DimClassEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimClassEntity, String> className;
	public static volatile SingularAttribute<DimClassEntity, Timestamp> recordModifiedDatetime;
	public static volatile SingularAttribute<DimClassEntity, Integer> dimSchoolId;

}

