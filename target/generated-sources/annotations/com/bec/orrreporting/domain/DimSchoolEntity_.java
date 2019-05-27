package com.bec.orrreporting.domain;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DimSchoolEntity.class)
public abstract class DimSchoolEntity_ {

	public static volatile SingularAttribute<DimSchoolEntity, Timestamp> recordCreatedDatetime;
	public static volatile SingularAttribute<DimSchoolEntity, Integer> dimDistrictId;
	public static volatile SingularAttribute<DimSchoolEntity, Integer> schoolId;
	public static volatile SingularAttribute<DimSchoolEntity, Timestamp> recordModifiedDatetime;
	public static volatile SingularAttribute<DimSchoolEntity, Long> dimSchoolId;
	public static volatile SingularAttribute<DimSchoolEntity, String> schoolName;

}

