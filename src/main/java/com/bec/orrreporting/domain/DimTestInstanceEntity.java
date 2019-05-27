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
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dim_test_instance", schema = "public", catalog = "r_dev_orr_redshift")
public class DimTestInstanceEntity {
    private long dimTestInstanceId;
    private Long testInstanceId;
    private Integer userId;
    private String status;
    private String testTakerState;
    private String preferences;
    private BigDecimal score;
    private Integer elapsedTime;
    private String grade;
    private String recordFlag;
    private Integer deleteIndicator;
    private Timestamp sourceCreatedDatetime;
    private Timestamp sourceModifedDatetime;
    private Timestamp sourceReleasedDatetime;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_test_instance_id", nullable = false)
    public long getDimTestInstanceId() {
        return dimTestInstanceId;
    }

    public void setDimTestInstanceId(long dimTestInstanceId) {
        this.dimTestInstanceId = dimTestInstanceId;
    }

    @Basic
    @Column(name = "test_instance_id", nullable = true)
    public Long getTestInstanceId() {
        return testInstanceId;
    }

    public void setTestInstanceId(Long testInstanceId) {
        this.testInstanceId = testInstanceId;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "test_taker_state", nullable = true, length = 256)
    public String getTestTakerState() {
        return testTakerState;
    }

    public void setTestTakerState(String testTakerState) {
        this.testTakerState = testTakerState;
    }

    @Basic
    @Column(name = "preferences", nullable = true, length = 256)
    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    @Basic
    @Column(name = "score", nullable = true, precision = 1)
    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Basic
    @Column(name = "elapsed_time", nullable = true)
    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @Basic
    @Column(name = "grade", nullable = true, precision = 2, length = 10)
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "record_flag", nullable = true, length = 1)
    public String getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(String recordFlag) {
        this.recordFlag = recordFlag;
    }

    @Basic
    @Column(name = "delete_indicator", nullable = true)
    public Integer getDeleteIndicator() {
        return deleteIndicator;
    }

    public void setDeleteIndicator(Integer deleteIndicator) {
        this.deleteIndicator = deleteIndicator;
    }

    @Basic
    @Column(name = "source_created_datetime", nullable = true)
    public Timestamp getSourceCreatedDatetime() {
        return sourceCreatedDatetime;
    }

    public void setSourceCreatedDatetime(Timestamp sourceCreatedDatetime) {
        this.sourceCreatedDatetime = sourceCreatedDatetime;
    }

    @Basic
    @Column(name = "source_modifed_datetime", nullable = true)
    public Timestamp getSourceModifedDatetime() {
        return sourceModifedDatetime;
    }

    public void setSourceModifedDatetime(Timestamp sourceModifedDatetime) {
        this.sourceModifedDatetime = sourceModifedDatetime;
    }

    @Basic
    @Column(name = "source_released_datetime", nullable = true)
    public Timestamp getSourceReleasedDatetime() {
        return sourceReleasedDatetime;
    }

    public void setSourceReleasedDatetime(Timestamp sourceReleasedDatetime) {
        this.sourceReleasedDatetime = sourceReleasedDatetime;
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
        DimTestInstanceEntity that = (DimTestInstanceEntity) o;
        return dimTestInstanceId == that.dimTestInstanceId &&
                Objects.equals(testInstanceId, that.testInstanceId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(testTakerState, that.testTakerState) &&
                Objects.equals(preferences, that.preferences) &&
                Objects.equals(score, that.score) &&
                Objects.equals(elapsedTime, that.elapsedTime) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(recordFlag, that.recordFlag) &&
                Objects.equals(deleteIndicator, that.deleteIndicator) &&
                Objects.equals(sourceCreatedDatetime, that.sourceCreatedDatetime) &&
                Objects.equals(sourceModifedDatetime, that.sourceModifedDatetime) &&
                Objects.equals(sourceReleasedDatetime, that.sourceReleasedDatetime) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimTestInstanceId, testInstanceId, userId, status, testTakerState, preferences, score, elapsedTime, grade, recordFlag, deleteIndicator, sourceCreatedDatetime, sourceModifedDatetime, sourceReleasedDatetime, recordCreatedDatetime, recordModifiedDatetime);
    }
}
