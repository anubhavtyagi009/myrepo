/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * MAY 23 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.orrreporting.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dim_school", schema = "public", catalog = "r_dev_orr_redshift")
public class DimSchoolEntity {
    private long dimSchoolId;
    private Integer schoolId;
    private String schoolName;
    private Integer dimDistrictId;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_school_id", nullable = false)
    public long getDimSchoolId() {
        return dimSchoolId;
    }

    public void setDimSchoolId(long dimSchoolId) {
        this.dimSchoolId = dimSchoolId;
    }

    @Basic
    @Column(name = "school_id", nullable = true)
    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Basic
    @Column(name = "school_name", nullable = true, length = 100)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Basic
    @Column(name = "dim_district_id", nullable = true)
    public Integer getDimDistrictId() {
        return dimDistrictId;
    }

    public void setDimDistrictId(Integer dimDistrictId) {
        this.dimDistrictId = dimDistrictId;
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
        DimSchoolEntity that = (DimSchoolEntity) o;
        return dimSchoolId == that.dimSchoolId &&
                Objects.equals(schoolId, that.schoolId) &&
                Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(dimDistrictId, that.dimDistrictId) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimSchoolId, schoolId, schoolName, dimDistrictId, recordCreatedDatetime, recordModifiedDatetime);
    }
}
