package com.impelsys.microservice.dto;

public class ExternalFilterDTO {
    private Integer assesmentId;
    private Integer studentId;
    private Integer teacherId;
    private String startDate;
    private String endDate;
    private String studentGrade;

    public ExternalFilterDTO(Integer assesmentId, Integer studentId, Integer teacherId, String startDate, String endDate, String studentGrade) {
        this.assesmentId = assesmentId;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentGrade = studentGrade;
    }

    public ExternalFilterDTO() {
    }

    public Integer getAssesmentId() {
        return assesmentId;
    }

    public void setAssesmentId(Integer assesmentId) {
        this.assesmentId = assesmentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
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

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }
}
