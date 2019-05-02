package com.impelsys.microservice.dto;

import java.util.Date;

public class DateRangeAxisDTO {

    private Date assignmentDate;
    private String readingLevel;

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getReadingLevel() {
        return readingLevel;
    }

    public void setReadingLevel(String readingLevel) {
        this.readingLevel = readingLevel;
    }
}
