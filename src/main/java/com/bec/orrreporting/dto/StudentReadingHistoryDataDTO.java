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

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class StudentReadingHistoryDataDTO {

    private Integer studentId;
    private String letterLevel;
    private String lastPassage;
    private String category;
    private BigDecimal accuracy;
    private String proficiency;
    private Integer fluency;
    @JsonFormat(pattern = "MM/dd/yy")
    private Date assignmentDate;
    private String notes;

    public StudentReadingHistoryDataDTO(Integer studentId, String letterLevel, String lastPassage, String category, BigDecimal accuracy, String proficiency, Integer fluency, Date assignmentDate, String notes) {
        this.studentId = studentId;
        this.letterLevel = letterLevel;
        this.lastPassage = lastPassage;
        this.category = category;
        this.accuracy = accuracy;
        this.proficiency = proficiency;
        this.fluency = fluency;
        this.assignmentDate = assignmentDate;
        this.notes = notes;
    }

    public StudentReadingHistoryDataDTO() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getLetterLevel() {
        return letterLevel;
    }

    public void setLetterLevel(String letterLevel) {
        this.letterLevel = letterLevel;
    }

    public String getLastPassage() {
        return lastPassage;
    }

    public void setLastPassage(String lastPassage) {
        this.lastPassage = lastPassage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public Integer getFluency() {
        return fluency;
    }

    public void setFluency(Integer fluency) {
        this.fluency = fluency;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

