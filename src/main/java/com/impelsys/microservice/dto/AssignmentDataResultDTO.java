package com.impelsys.microservice.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AssignmentDataResultDTO {

    private Date assignmentDate;
    private String letterLevel;
    private String proficiency ;
    private String numberLevel ;
    private Integer fluency ;
    private BigDecimal accuracy;
    private String bubbleColour ;
    private Boolean startLevel ;
    private Boolean targetLevel ;

    public AssignmentDataResultDTO(Date assignmentDate, String letterLevel, String proficiency, String numberLevel, Integer fluency, BigDecimal accuracy, String bubbleColour, Boolean startLevel, Boolean targetLevel) {
        this.assignmentDate = assignmentDate;
        this.letterLevel = letterLevel;
        this.proficiency = proficiency;
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
