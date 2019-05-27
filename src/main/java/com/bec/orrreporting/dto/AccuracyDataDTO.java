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

public class AccuracyDataDTO {

    @JsonFormat(pattern = "MM/dd/yy")
    private Date assignmentDate;
    private String letterLevel;
    private BigDecimal accuracy;
    private String colour;
    private boolean startLevel;
    private boolean targetLevel;

    public AccuracyDataDTO(Date assignmentDate, String letterLevel, BigDecimal accuracy, String colour, boolean startLevel, boolean targetLevel) {
        this.assignmentDate = assignmentDate;
        this.letterLevel = letterLevel;
        this.accuracy = accuracy;
        this.colour = colour;
        this.startLevel = startLevel;
        this.targetLevel = targetLevel;
    }

    public AccuracyDataDTO() {
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

    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isStartLevel() {
        return startLevel;
    }

    public void setStartLevel(boolean startLevel) {
        this.startLevel = startLevel;
    }

    public boolean isTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(boolean targetLevel) {
        this.targetLevel = targetLevel;
    }
}
