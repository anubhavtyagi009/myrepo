package com.impelsys.microservice.dto;

import java.math.BigDecimal;
import java.util.Date;

public class MeaningCuesDTO {

    private Date assignmentDate;
    private BigDecimal value;

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
