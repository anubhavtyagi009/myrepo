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
package com.bec.orrreporting.dto;

public class ExternalFilterDTO {
    private Long assesmentId;
    private Integer studentId;
    private Long teacherId;
    private String startDate;
    private String endDate;
    private String studentGrade;

    public ExternalFilterDTO(Long assesmentId, Integer studentId, Long teacherId, String startDate, String endDate, String studentGrade) {
        this.assesmentId = assesmentId;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentGrade = studentGrade;
    }

    public ExternalFilterDTO() {
    }

    public Long getAssesmentId() {
        return assesmentId;
    }

    public void setAssesmentId(Long assesmentId) {
        this.assesmentId = assesmentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
}
