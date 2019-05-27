package com.bec.orrreporting.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimReadingLevelsEntity.class)
public abstract class DimReadingLevelsEntity_ {

	public static volatile SingularAttribute<DimReadingLevelsEntity, String> gradeLevel;
	public static volatile SingularAttribute<DimReadingLevelsEntity, String> numberLevel;
	public static volatile SingularAttribute<DimReadingLevelsEntity, Long> dimReadingLevelId;
	public static volatile SingularAttribute<DimReadingLevelsEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimReadingLevelsEntity, String> developmentalCategory;
	public static volatile SingularAttribute<DimReadingLevelsEntity, String> lexileRange;
	public static volatile SingularAttribute<DimReadingLevelsEntity, Timestamp> recordModifiedDatetime;
	public static volatile SingularAttribute<DimReadingLevelsEntity, String> leterLevel;

}

