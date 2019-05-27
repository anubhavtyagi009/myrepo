package com.bec.orrreporting.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimAssessmentTestEntity.class)
public abstract class DimAssessmentTestEntity_ {

	public static volatile SingularAttribute<DimAssessmentTestEntity, Timestamp> sourceModifiedDatetime;
	public static volatile SingularAttribute<DimAssessmentTestEntity, String> componentCode;
	public static volatile SingularAttribute<DimAssessmentTestEntity, Long> assessmentTestId;
	public static volatile SingularAttribute<DimAssessmentTestEntity, Timestamp> sourceCreatedDatetime;
	public static volatile SingularAttribute<DimAssessmentTestEntity, String> language;
	public static volatile SingularAttribute<DimAssessmentTestEntity, Timestamp> recordModifiedDatetime;
	public static volatile SingularAttribute<DimAssessmentTestEntity, Integer> deleteIndicator;
	public static volatile SingularAttribute<DimAssessmentTestEntity, BigDecimal> maxScore;
	public static volatile SingularAttribute<DimAssessmentTestEntity, Long> dimAssessmentTestId;
	public static volatile SingularAttribute<DimAssessmentTestEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimAssessmentTestEntity, String> componentTitle;
	public static volatile SingularAttribute<DimAssessmentTestEntity, String> recordFlag;
	public static volatile SingularAttribute<DimAssessmentTestEntity, String> category;
	public static volatile SingularAttribute<DimAssessmentTestEntity, String> contentType;

}

