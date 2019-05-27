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
@Table(name = "dim_assessment_test", schema = "public", catalog = "r_dev_orr_redshift")
public class DimAssessmentTestEntity {
    private long dimAssessmentTestId;
    private Long assessmentTestId;
    private String componentCode;
    private String componentTitle;
    private BigDecimal maxScore;
    private String category;
    private String language;
    private String contentType;
    private String recordFlag;
    private Integer deleteIndicator;
    private Timestamp sourceCreatedDatetime;
    private Timestamp sourceModifiedDatetime;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dim_assessment_test_id", nullable = false)
    public long getDimAssessmentTestId() {
        return dimAssessmentTestId;
    }

    public void setDimAssessmentTestId(long dimAssessmentTestId) {
        this.dimAssessmentTestId = dimAssessmentTestId;
    }

    @Basic
    @Column(name = "assessment_test_id", nullable = true)
    public Long getAssessmentTestId() {
        return assessmentTestId;
    }

    public void setAssessmentTestId(Long assessmentTestId) {
        this.assessmentTestId = assessmentTestId;
    }

    @Basic
    @Column(name = "component_code", nullable = true, length = 50)
    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    @Basic
    @Column(name = "component_title", nullable = true, length = 50)
    public String getComponentTitle() {
        return componentTitle;
    }

    public void setComponentTitle(String componentTitle) {
        this.componentTitle = componentTitle;
    }

    @Basic
    @Column(name = "max_score", nullable = true, precision = 2)
    public BigDecimal getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(BigDecimal maxScore) {
        this.maxScore = maxScore;
    }

    @Basic
    @Column(name = "category", nullable = true, length = 100)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 100)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "content_type", nullable = true, length = 100)
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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
    @Column(name = "source_modified_datetime", nullable = true)
    public Timestamp getSourceModifiedDatetime() {
        return sourceModifiedDatetime;
    }

    public void setSourceModifiedDatetime(Timestamp sourceModifiedDatetime) {
        this.sourceModifiedDatetime = sourceModifiedDatetime;
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
        DimAssessmentTestEntity that = (DimAssessmentTestEntity) o;
        return dimAssessmentTestId == that.dimAssessmentTestId &&
                Objects.equals(assessmentTestId, that.assessmentTestId) &&
                Objects.equals(componentCode, that.componentCode) &&
                Objects.equals(componentTitle, that.componentTitle) &&
                Objects.equals(maxScore, that.maxScore) &&
                Objects.equals(category, that.category) &&
                Objects.equals(language, that.language) &&
                Objects.equals(contentType, that.contentType) &&
                Objects.equals(recordFlag, that.recordFlag) &&
                Objects.equals(deleteIndicator, that.deleteIndicator) &&
                Objects.equals(sourceCreatedDatetime, that.sourceCreatedDatetime) &&
                Objects.equals(sourceModifiedDatetime, that.sourceModifiedDatetime) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimAssessmentTestId, assessmentTestId, componentCode, componentTitle, maxScore, category, language, contentType, recordFlag, deleteIndicator, sourceCreatedDatetime, sourceModifiedDatetime, recordCreatedDatetime, recordModifiedDatetime);
    }
}
