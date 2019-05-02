package com.impelsys.microservice.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dim_reading_levels", schema = "public", catalog = "r_dev_orr_redshift")
public class DimReadingLevelsEntity {
    private Long dimReadingLevelId;
    private String developmentalCategory;
    private String gradeLevel;
    private String leterLevel;
    private String numberLevel;
    private String lexileRange;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;

    @Id
    @Column(name = "dim_reading_level_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getDimReadingLevelId() {
        return dimReadingLevelId;
    }

    public void setDimReadingLevelId(Long dimReadingLevelId) {
        this.dimReadingLevelId = dimReadingLevelId;
    }

    @Basic
    @Column(name = "developmental_category", nullable = true, length = 50)
    public String getDevelopmentalCategory() {
        return developmentalCategory;
    }

    public void setDevelopmentalCategory(String developmentalCategory) {
        this.developmentalCategory = developmentalCategory;
    }

    @Basic
    @Column(name = "grade_level", nullable = true, length = 50)
    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Basic
    @Column(name = "leter_level", nullable = true, length = 50)
    public String getLeterLevel() {
        return leterLevel;
    }

    public void setLeterLevel(String leterLevel) {
        this.leterLevel = leterLevel;
    }

    @Basic
    @Column(name = "number_level", nullable = true, length = 50)
    public String getNumberLevel() {
        return numberLevel;
    }

    public void setNumberLevel(String numberLevel) {
        this.numberLevel = numberLevel;
    }

    @Basic
    @Column(name = "lexile_range", nullable = true, length = 50)
    public String getLexileRange() {
        return lexileRange;
    }

    public void setLexileRange(String lexileRange) {
        this.lexileRange = lexileRange;
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
        DimReadingLevelsEntity that = (DimReadingLevelsEntity) o;
        return dimReadingLevelId == that.dimReadingLevelId &&
                Objects.equals(developmentalCategory, that.developmentalCategory) &&
                Objects.equals(gradeLevel, that.gradeLevel) &&
                Objects.equals(leterLevel, that.leterLevel) &&
                Objects.equals(numberLevel, that.numberLevel) &&
                Objects.equals(lexileRange, that.lexileRange) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimReadingLevelId, developmentalCategory, gradeLevel, leterLevel, numberLevel, lexileRange, recordCreatedDatetime, recordModifiedDatetime);
    }
}
