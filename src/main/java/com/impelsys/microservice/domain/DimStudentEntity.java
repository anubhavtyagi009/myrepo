package com.impelsys.microservice.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dim_student", schema = "public", catalog = "r_dev_orr_redshift")
public class DimStudentEntity {
    private Long dimStudentId;
    private Long studentId;
    private String grade;
    private String readingLetterLevel;
    private Integer readingLetterLevelId;
    private String readingNumberLevel;
    private Integer readingNumberLevelId;
    private String proficiency;
    private String recordFlag;
    private Integer deleteIndicator;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;

    @Id
    @Column(name = "dim_student_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDimStudentId() {
        return dimStudentId;
    }

    public void setDimStudentId(Long dimStudentId) {
        this.dimStudentId = dimStudentId;
    }

    @Basic
    @Column(name = "student_id", nullable = true)
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "grade", nullable = true, length = 10)
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "reading_letter_level", nullable = true, length = 10)
    public String getReadingLetterLevel() {
        return readingLetterLevel;
    }

    public void setReadingLetterLevel(String readingLetterLevel) {
        this.readingLetterLevel = readingLetterLevel;
    }

    @Basic
    @Column(name = "reading_letter_level_id", nullable = true)
    public Integer getReadingLetterLevelId() {
        return readingLetterLevelId;
    }

    public void setReadingLetterLevelId(Integer readingLetterLevelId) {
        this.readingLetterLevelId = readingLetterLevelId;
    }

    @Basic
    @Column(name = "reading_number_level", nullable = true, length = 10)
    public String getReadingNumberLevel() {
        return readingNumberLevel;
    }

    public void setReadingNumberLevel(String readingNumberLevel) {
        this.readingNumberLevel = readingNumberLevel;
    }

    @Basic
    @Column(name = "reading_number_level_id", nullable = true)
    public Integer getReadingNumberLevelId() {
        return readingNumberLevelId;
    }

    public void setReadingNumberLevelId(Integer readingNumberLevelId) {
        this.readingNumberLevelId = readingNumberLevelId;
    }

    @Basic
    @Column(name = "proficiency", nullable = true, length = 50)
    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    @Basic
    @Column(name = "record_flag", nullable = true, length = 1)
    public String getRecordFlag() {
        return recordFlag;
    }

    public void setRecordFlag(String recordFlag) {
        this.recordFlag = recordFlag;
    }

    @Basic
    @Column(name = "delete_indicator", nullable = true)
    public Integer getDeleteIndicator() {
        return deleteIndicator;
    }

    public void setDeleteIndicator(Integer deleteIndicator) {
        this.deleteIndicator = deleteIndicator;
    }

    @Basic
    @Column(name = "record_created_datetime", nullable = true)
    public Timestamp getRecordCreatedDatetime() {
        return recordCreatedDatetime;
    }

    public void setRecordCreatedDatetime(Timestamp recordCreatedDatetime) {
        this.recordCreatedDatetime = recordCreatedDatetime;
    }

    @Basic
    @Column(name = "record_modified_datetime", nullable = true)
    public Timestamp getRecordModifiedDatetime() {
        return recordModifiedDatetime;
    }

    public void setRecordModifiedDatetime(Timestamp recordModifiedDatetime) {
        this.recordModifiedDatetime = recordModifiedDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimStudentEntity that = (DimStudentEntity) o;
        return dimStudentId == that.dimStudentId &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(readingLetterLevel, that.readingLetterLevel) &&
                Objects.equals(readingLetterLevelId, that.readingLetterLevelId) &&
                Objects.equals(readingNumberLevel, that.readingNumberLevel) &&
                Objects.equals(readingNumberLevelId, that.readingNumberLevelId) &&
                Objects.equals(proficiency, that.proficiency) &&
                Objects.equals(recordFlag, that.recordFlag) &&
                Objects.equals(deleteIndicator, that.deleteIndicator) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimStudentId, studentId, grade, readingLetterLevel, readingLetterLevelId, readingNumberLevel, readingNumberLevelId, proficiency, recordFlag, deleteIndicator, recordCreatedDatetime, recordModifiedDatetime);
    }
}
