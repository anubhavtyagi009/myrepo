package com.impelsys.microservice.dto;

import java.util.Date;

public class ToldDTO {

    private Date assignmentDate;
    private Integer value;

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
