package com.impelsys.microservice.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dim_class", schema = "public", catalog = "r_dev_orr_redshift")
public class DimClassEntity {
    private Long dimClassId;
    private Long classId;
    private String className;
    private Long dimSchoolId;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;

    @Id
    @Column(name = "dim_class_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDimClassId() {
        return dimClassId;
    }

    public void setDimClassId(Long dimClassId) {
        this.dimClassId = dimClassId;
    }

    @Basic
    @Column(name = "class_id", nullable = true)
    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "class_name", nullable = true, length = 100)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "dim_school_id", nullable = true)
    public Long getDimSchoolId() {
        return dimSchoolId;
    }

    public void setDimSchoolId(Long dimSchoolId) {
        this.dimSchoolId = dimSchoolId;
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
        DimClassEntity that = (DimClassEntity) o;
        return dimClassId == that.dimClassId &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(className, that.className) &&
                Objects.equals(dimSchoolId, that.dimSchoolId) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimClassId, classId, className, dimSchoolId, recordCreatedDatetime, recordModifiedDatetime);
    }
}
