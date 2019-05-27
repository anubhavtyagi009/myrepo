package com.bec.orrreporting.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimTestInstanceEntity.class)
public abstract class DimTestInstanceEntity_ {

	public static volatile SingularAttribute<DimTestInstanceEntity, String> preferences;
	public static volatile SingularAttribute<DimTestInstanceEntity, Timestamp> sourceCreatedDatetime;
	public static volatile SingularAttribute<DimTestInstanceEntity, Timestamp> recordModifiedDatetime;
	public static volatile SingularAttribute<DimTestInstanceEntity, Integer> deleteIndicator;
	public static volatile SingularAttribute<DimTestInstanceEntity, Integer> userId;
	public static volatile SingularAttribute<DimTestInstanceEntity, Timestamp> sourceReleasedDatetime;
	public static volatile SingularAttribute<DimTestInstanceEntity, String> testTakerState;
	public static volatile SingularAttribute<DimTestInstanceEntity, BigDecimal> score;
	public static volatile SingularAttribute<DimTestInstanceEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimTestInstanceEntity, Long> testInstanceId;
	public static volatile SingularAttribute<DimTestInstanceEntity, String> grade;
	public static volatile SingularAttribute<DimTestInstanceEntity, String> recordFlag;
	public static volatile SingularAttribute<DimTestInstanceEntity, Long> dimTestInstanceId;
	public static volatile SingularAttribute<DimTestInstanceEntity, Timestamp> sourceModifedDatetime;
	public static volatile SingularAttribute<DimTestInstanceEntity, String> status;
	public static volatile SingularAttribute<DimTestInstanceEntity, Integer> elapsedTime;

}

