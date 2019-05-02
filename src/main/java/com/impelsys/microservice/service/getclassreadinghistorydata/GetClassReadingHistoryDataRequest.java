package com.impelsys.microservice.service.getclassreadinghistorydata;

import com.impelsys.microservice.service.CommonServiceRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GetClassReadingHistoryDataRequest implements CommonServiceRequest {
    private Integer classId;
    private String startDate;
    private String endDate;

    public GetClassReadingHistoryDataRequest(Integer classId, String startDate, String endDate) {
        this.classId = classId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public GetClassReadingHistoryDataRequest() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

