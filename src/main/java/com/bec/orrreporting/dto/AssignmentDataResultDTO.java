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

public class AssignmentDataResultDTO {

    @JsonFormat(pattern = "MM/dd/yy")
    private Date assignmentDate;
    private String letterLevel;
    private String proficiency;
    private String category;
    private String assignmentTitle;
    private String numberLevel;
    private Integer fluency;
    private BigDecimal accuracy;
    private String bubbleColour;
    private Boolean startLevel;
    private Boolean targetLevel;

    public AssignmentDataResultDTO(Date assignmentDate, String letterLevel, String proficiency, String category, String assignmentTitle, String numberLevel, Integer fluency, BigDecimal accuracy, String bubbleColour, Boolean startLevel, Boolean targetLevel) {
        this.assignmentDate = assignmentDate;
        this.letterLevel = letterLevel;
        this.proficiency = proficiency;
        this.category = category;
        this.assignmentTitle = assignmentTitle;
        this.numberLevel = numberLevel;
        this.fluency = fluency;
        this.accuracy = accuracy;
        this.bubbleColour = bubbleColour;
        this.startLevel = startLevel;
        this.targetLevel = targetLevel;
    }

    public AssignmentDataResultDTO() {
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getLetterLevel() {
        return letterLevel;
    }

    public void setLetterLevel(String letterLevel) {
        this.letterLevel = letterLevel;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(String numberLevel) {
        this.numberLevel = numberLevel;
    }

    public Integer getFluency() {
        return fluency;
    }

    public void setFluency(Integer fluency) {
        this.fluency = fluency;
    }

    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public String getBubbleColour() {
        return bubbleColour;
    }

    public void setBubbleColour(String bubbleColour) {
        this.bubbleColour = bubbleColour;
    }

    public Boolean getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(Boolean startLevel) {
        this.startLevel = startLevel;
    }

    public Boolean getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(Boolean targetLevel) {
        this.targetLevel = targetLevel;
    }
}
