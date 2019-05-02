package com.impelsys.microservice.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dim_test_instance", schema = "public", catalog = "r_dev_orr_redshift")
public class DimTestInstanceEntity {
    private Long dimTestInstanceId;

    @Id
    @Column(name = "dim_test_instance_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDimTestInstanceId() {
        return dimTestInstanceId;
    }

    public void setDimTestInstanceId(Long dimTestInstanceId) {
        this.dimTestInstanceId = dimTestInstanceId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimTestInstanceEntity that = (DimTestInstanceEntity) o;
        return dimTestInstanceId == that.dimTestInstanceId;

    }

    @Override
    public int hashCode() {
        return Objects.hash(dimTestInstanceId);
    }
}
