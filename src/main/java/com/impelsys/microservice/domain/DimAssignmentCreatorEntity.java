package com.impelsys.microservice.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dim_assignment_creator", schema = "public", catalog = "r_dev_orr_redshift")
public class DimAssignmentCreatorEntity {
    private Long dimAssignmentCreatorId;
    private Long sourceAssignmentCreatorId;
    private String sourceSystem;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_assignment_creator_id", nullable = false)
    public long getDimAssignmentCreatorId() {
        return dimAssignmentCreatorId;
    }

    public void setDimAssignmentCreatorId(long dimAssignmentCreatorId) {
        this.dimAssignmentCreatorId = dimAssignmentCreatorId;
    }

    @Basic
    @Column(name = "source_assignment_creator_id", nullable = true)
    public Long getSourceAssignmentCreatorId() {
        return sourceAssignmentCreatorId;
    }

    public void setSourceAssignmentCreatorId(Long sourceAssignmentCreatorId) {
        this.sourceAssignmentCreatorId = sourceAssignmentCreatorId;
    }

    @Basic
    @Column(name = "source_system", nullable = true, length = 100)
    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    @Basic
    @Column(name = "record_created_datetime", nullable = true)
    public Timestamp getRecordCreatedDatetime() {
        return recordCreatedDatetime;
    }

    public void setRecordCreatedDatetime(Timestamp recordCreatedDatetime) {
        this.recordCreatedDatetime = recordCreatedDatetime;
    }

    @Basic
    @Column(name = "record_modified_datetime", nullable = true)
    public Timestamp getRecordModifiedDatetime() {
        return recordModifiedDatetime;
    }

    public void setRecordModifiedDatetime(Timestamp recordModifiedDatetime) {
        this.recordModifiedDatetime = recordModifiedDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimAssignmentCreatorEntity that = (DimAssignmentCreatorEntity) o;
        return dimAssignmentCreatorId == that.dimAssignmentCreatorId &&
                Objects.equals(sourceAssignmentCreatorId, that.sourceAssignmentCreatorId) &&
                Objects.equals(sourceSystem, that.sourceSystem) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimAssignmentCreatorId, sourceAssignmentCreatorId, sourceSystem, recordCreatedDatetime, recordModifiedDatetime);
    }
}
