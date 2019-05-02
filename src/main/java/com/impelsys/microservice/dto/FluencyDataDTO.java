package com.impelsys.microservice.dto;

import java.util.Date;

public class FluencyDataDTO {

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
