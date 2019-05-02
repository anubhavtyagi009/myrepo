package com.impelsys.microservice.service.getstudentreadinghistorydata;
import com.impelsys.microservice.service.CommonServiceRequest;

public class GetStudentReadingHistoryDataRequest implements CommonServiceRequest {
    private Integer studentId;
    private String studentGrade;
    private Long teacherId;
    private String startDate;
    private String endDate;

    public GetStudentReadingHistoryDataRequest(Integer studentId, String studentGrade, Long teacherId, String startDate, String endDate) {
        this.studentId = studentId;
        this.studentGrade = studentGrade;
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public GetStudentReadingHistoryDataRequest() {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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
