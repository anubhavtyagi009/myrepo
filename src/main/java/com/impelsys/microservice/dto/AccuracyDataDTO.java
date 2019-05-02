package com.impelsys.microservice.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AccuracyDataDTO {

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
