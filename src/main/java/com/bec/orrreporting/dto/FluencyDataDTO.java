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

import java.util.Date;

public class FluencyDataDTO {

    @JsonFormat(pattern = "MM/dd/yy")
    private Date assignmentDate;
    private String letterLevel;
    private Integer fluency;
    private String colour;
    private boolean startLevel;
    private boolean targetLevel;

    public FluencyDataDTO(Date assignmentDate, String letterLevel, Integer fluency, String colour, boolean startLevel, boolean targetLevel) {
        this.assignmentDate = assignmentDate;
        this.letterLevel = letterLevel;
        this.fluency = fluency;
        this.colour = colour;
        this.startLevel = startLevel;
        this.targetLevel = targetLevel;
    }

    public FluencyDataDTO() {
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

    public Integer getFluency() {
        return fluency;
    }

    public void setFluency(Integer fluency) {
        this.fluency = fluency;
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
