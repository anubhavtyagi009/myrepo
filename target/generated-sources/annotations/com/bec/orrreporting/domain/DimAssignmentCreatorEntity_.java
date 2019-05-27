package com.bec.orrreporting.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimAssignmentCreatorEntity.class)
public abstract class DimAssignmentCreatorEntity_ {

	public static volatile SingularAttribute<DimAssignmentCreatorEntity, Long> dimAssignmentCreatorId;
	public static volatile SingularAttribute<DimAssignmentCreatorEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimAssignmentCreatorEntity, String> sourceSystem;
	public static volatile SingularAttribute<DimAssignmentCreatorEntity, Long> sourceAssignmentCreatorId;
	public static volatile SingularAttribute<DimAssignmentCreatorEntity, Timestamp> recordModifiedDatetime;

}

