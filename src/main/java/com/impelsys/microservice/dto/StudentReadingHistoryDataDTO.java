package com.impelsys.microservice.dto;

import java.math.BigDecimal;
import java.util.Date;

public class StudentReadingHistoryDataDTO {

    private Long studentId;
    private String letterLevel;
    private String lastPassage;
    private String category;
    private BigDecimal accuracy;
    private String proficiency;
    private Integer fluency;
    private Date assignmentDate;
    private String notes;

    public StudentReadingHistoryDataDTO(Long studentId, String letterLevel, String lastPassage, String category, BigDecimal accuracy, String proficiency, Integer fluency, Date assignmentDate, String notes) {
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
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

