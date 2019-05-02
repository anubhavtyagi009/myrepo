package com.impelsys.microservice.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FactOrrAssignmentNoAggEntity.class)
public abstract class FactOrrAssignmentNoAggEntity_ {

	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Date> assignedDate;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Long> buAssignmentId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Date> assignmentCompletionDate;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, String> notes;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Timestamp> assignmentCreatedDatetime;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Timestamp> assignmentModifiedDatetime;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> markingSubstitutions;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Date> dueDate;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, BigDecimal> accuracy;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Timestamp> recordModifiedDatetime;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> deleteIndicator;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, String> proficiency;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, BigDecimal> cuesStructural;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> markingTolds;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimAssessmentTestEntity> dimAssessmentTestByDimAssessmentTestId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimTestInstanceEntity> dimTestInstanceByDimTestInstanceId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> markingRepetitions;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimSchoolEntity> dimSchoolByDimSchoolId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, String> recordFlag;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> markingSelfCorrections;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, String> selfCorrectionRate;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, BigDecimal> cuesOmmissions;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimAssignmentCreatorEntity> dimAssignmentCreatorByDimAssignmentCreatorId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimReadingLevelsEntity> dimReadingLevelsByDimReadingLevelId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> wordCount;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Long> orrAssignmentId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> fluency;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, String> errorRate;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> markingOmmissions;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, BigDecimal> cuesVisual;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimDistrictEntity> dimDistrictByDimDistrictId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Integer> markingInsertions;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, BigDecimal> cuesMeaning;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Long> sourceAssignmentId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, String> assignmentMethod;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimStudentEntity> dimStudentByDimStudentId;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, String> readType;
	public static volatile SingularAttribute<FactOrrAssignmentNoAggEntity, DimClassEntity> dimClassByDimClassId;

}

