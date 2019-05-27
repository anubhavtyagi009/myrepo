package com.bec.orrreporting.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimStudentEntity.class)
public abstract class DimStudentEntity_ {

	public static volatile SingularAttribute<DimStudentEntity, Integer> readingLetterLevelId;
	public static volatile SingularAttribute<DimStudentEntity, Long> dimDistrictId;
	public static volatile SingularAttribute<DimStudentEntity, String> readingNumberLevel;
	public static volatile SingularAttribute<DimStudentEntity, Timestamp> recordModifiedDatetime;
	public static volatile SingularAttribute<DimStudentEntity, String> readingLetterLevel;
	public static volatile SingularAttribute<DimStudentEntity, Integer> deleteIndicator;
	public static volatile SingularAttribute<DimStudentEntity, Integer> readingNumberLevelId;
	public static volatile SingularAttribute<DimStudentEntity, String> proficiency;
	public static volatile SingularAttribute<DimStudentEntity, Integer> studentId;
	public static volatile SingularAttribute<DimStudentEntity, Long> dimClassId;
	public static volatile SingularAttribute<DimStudentEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimStudentEntity, String> grade;
	public static volatile SingularAttribute<DimStudentEntity, String> recordFlag;
	public static volatile SingularAttribute<DimStudentEntity, Long> dimSchoolId;
	public static volatile SingularAttribute<DimStudentEntity, Long> dimStudentId;

}

