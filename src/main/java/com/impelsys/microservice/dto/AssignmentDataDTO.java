package com.impelsys.microservice.dto;

import java.math.BigDecimal;

public class AssignmentDataDTO {

    private String message;
    private String assignmentDate;
    private String letterLevel;
    private Integer fluency;
    private BigDecimal accuracy;
    private String proficiency;
    private String numberLevel;
    private String bubbleColor;
    private Boolean startLevel;
    private Boolean targetLevel;

    public AssignmentDataDTO(String message, String assignmentDate, String letterLevel, Integer fluency, BigDecimal accuracy, String proficiency, String numberLevel, String bubbleColor, Boolean startLevel, Boolean targetLevel) {
        this.message = message;
        this.assignmentDate = assignmentDate;
        this.letterLevel = letterLevel;
        this.fluency = fluency;
        this.accuracy = accuracy;
        this.proficiency = proficiency;
        this.numberLevel = numberLevel;
        this.bubbleColor = bubbleColor;
        this.startLevel = startLevel;
        this.targetLevel = targetLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
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

    public String getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(String numberLevel) {
        this.numberLevel = numberLevel;
    }

    public String getBubbleColor() {
        return bubbleColor;
    }

    public void setBubbleColor(String bubbleColor) {
        this.bubbleColor = bubbleColor;
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
