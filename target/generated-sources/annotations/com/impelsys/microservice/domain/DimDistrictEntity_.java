package com.impelsys.microservice.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimDistrictEntity.class)
public abstract class DimDistrictEntity_ {

	public static volatile SingularAttribute<DimDistrictEntity, Long> districtId;
	public static volatile SingularAttribute<DimDistrictEntity, String> districtName;
	public static volatile SingularAttribute<DimDistrictEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimDistrictEntity, Long> dimDistrictId;
	public static volatile SingularAttribute<DimDistrictEntity, Timestamp> recordModifiedDatetime;

}

