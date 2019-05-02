package com.impelsys.microservice.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "fact_orr_assignment_no_agg", schema = "public", catalog = "r_dev_orr_redshift")
public class FactOrrAssignmentNoAggEntity {
    private Long orrAssignmentId;
    private Long buAssignmentId;
    private Long sourceAssignmentId;
    private String assignmentMethod;
    private Date assignedDate;
    private Date dueDate;
    private Date assignmentCompletionDate;
    private Timestamp assignmentCreatedDatetime;
    private Timestamp assignmentModifiedDatetime;
    private String readType;
    private String notes;
    private Integer wordCount;
    private String proficiency;
    private BigDecimal accuracy;
    private String errorRate;
    private String selfCorrectionRate;
    private Integer fluency;
    private Integer markingSubstitutions;
    private Integer markingOmmissions;
    private Integer markingInsertions;
    private Integer markingTolds;
    private Integer markingRepetitions;
    private Integer markingSelfCorrections;
    private BigDecimal cuesMeaning;
    private BigDecimal cuesStructural;
    private BigDecimal cuesVisual;
    private BigDecimal cuesOmmissions;
    private String recordFlag;
    private Integer deleteIndicator;
    private Timestamp recordCreatedDatetime;
    private Timestamp recordModifiedDatetime;
    private DimAssessmentTestEntity dimAssessmentTestByDimAssessmentTestId;
    private DimStudentEntity dimStudentByDimStudentId;
    private DimAssignmentCreatorEntity dimAssignmentCreatorByDimAssignmentCreatorId;
    private DimTestInstanceEntity dimTestInstanceByDimTestInstanceId;
    private DimDistrictEntity dimDistrictByDimDistrictId;
    private DimSchoolEntity dimSchoolByDimSchoolId;
    private DimClassEntity dimClassByDimClassId;
    private DimReadingLevelsEntity dimReadingLevelsByDimReadingLevelId;

    @Id
    @Column(name = "orr_assignment_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getOrrAssignmentId() {
        return orrAssignmentId;
    }

    public void setOrrAssignmentId(long orrAssignmentId) {
        this.orrAssignmentId = orrAssignmentId;
    }

    @Basic
    @Column(name = "bu_assignment_id", nullable = true)
    public Long getBuAssignmentId() {
        return buAssignmentId;
    }

    public void setBuAssignmentId(Long buAssignmentId) {
        this.buAssignmentId = buAssignmentId;
    }

    @Basic
    @Column(name = "source_assignment_id", nullable = true)
    public Long getSourceAssignmentId() {
        return sourceAssignmentId;
    }

    public void setSourceAssignmentId(Long sourceAssignmentId) {
        this.sourceAssignmentId = sourceAssignmentId;
    }

    @Basic
    @Column(name = "assignment_method", nullable = true, length = 50)
    public String getAssignmentMethod() {
        return assignmentMethod;
    }

    public void setAssignmentMethod(String assignmentMethod) {
        this.assignmentMethod = assignmentMethod;
    }

    @Basic
    @Column(name = "assigned_date", nullable = true)
    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Basic
    @Column(name = "due_date", nullable = true)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "assignment_completion_date", nullable = true)
    public Date getAssignmentCompletionDate() {
        return assignmentCompletionDate;
    }

    public void setAssignmentCompletionDate(Date assignmentCompletionDate) {
        this.assignmentCompletionDate = assignmentCompletionDate;
    }

    @Basic
    @Column(name = "assignment_created_datetime", nullable = true)
    public Timestamp getAssignmentCreatedDatetime() {
        return assignmentCreatedDatetime;
    }

    public void setAssignmentCreatedDatetime(Timestamp assignmentCreatedDatetime) {
        this.assignmentCreatedDatetime = assignmentCreatedDatetime;
    }

    @Basic
    @Column(name = "assignment_modified_datetime", nullable = true)
    public Timestamp getAssignmentModifiedDatetime() {
        return assignmentModifiedDatetime;
    }

    public void setAssignmentModifiedDatetime(Timestamp assignmentModifiedDatetime) {
        this.assignmentModifiedDatetime = assignmentModifiedDatetime;
    }

    @Basic
    @Column(name = "read_type", nullable = true, length = 10)
    public String getReadType() {
        return readType;
    }

    public void setReadType(String readType) {
        this.readType = readType;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 512)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "word_count", nullable = true)
    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
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
    @Column(name = "accuracy", nullable = true, precision = 2)
    public BigDecimal getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(BigDecimal accuracy) {
        this.accuracy = accuracy;
    }

    @Basic
    @Column(name = "error_rate", nullable = true, length = 20)
    public String getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(String errorRate) {
        this.errorRate = errorRate;
    }

    @Basic
    @Column(name = "self_correction_rate", nullable = true, length = 20)
    public String getSelfCorrectionRate() {
        return selfCorrectionRate;
    }

    public void setSelfCorrectionRate(String selfCorrectionRate) {
        this.selfCorrectionRate = selfCorrectionRate;
    }

    @Basic
    @Column(name = "fluency", nullable = true)
    public Integer getFluency() {
        return fluency;
    }

    public void setFluency(Integer fluency) {
        this.fluency = fluency;
    }

    @Basic
    @Column(name = "marking_substitutions", nullable = true)
    public Integer getMarkingSubstitutions() {
        return markingSubstitutions;
    }

    public void setMarkingSubstitutions(Integer markingSubstitutions) {
        this.markingSubstitutions = markingSubstitutions;
    }

    @Basic
    @Column(name = "marking_ommissions", nullable = true)
    public Integer getMarkingOmmissions() {
        return markingOmmissions;
    }

    public void setMarkingOmmissions(Integer markingOmmissions) {
        this.markingOmmissions = markingOmmissions;
    }

    @Basic
    @Column(name = "marking_insertions", nullable = true)
    public Integer getMarkingInsertions() {
        return markingInsertions;
    }

    public void setMarkingInsertions(Integer markingInsertions) {
        this.markingInsertions = markingInsertions;
    }

    @Basic
    @Column(name = "marking_tolds", nullable = true)
    public Integer getMarkingTolds() {
        return markingTolds;
    }

    public void setMarkingTolds(Integer markingTolds) {
        this.markingTolds = markingTolds;
    }

    @Basic
    @Column(name = "marking_repetitions", nullable = true)
    public Integer getMarkingRepetitions() {
        return markingRepetitions;
    }

    public void setMarkingRepetitions(Integer markingRepetitions) {
        this.markingRepetitions = markingRepetitions;
    }

    @Basic
    @Column(name = "marking_self_corrections", nullable = true)
    public Integer getMarkingSelfCorrections() {
        return markingSelfCorrections;
    }

    public void setMarkingSelfCorrections(Integer markingSelfCorrections) {
        this.markingSelfCorrections = markingSelfCorrections;
    }

    @Basic
    @Column(name = "cues_meaning", nullable = true, precision = 2)
    public BigDecimal getCuesMeaning() {
        return cuesMeaning;
    }

    public void setCuesMeaning(BigDecimal cuesMeaning) {
        this.cuesMeaning = cuesMeaning;
    }

    @Basic
    @Column(name = "cues_structural", nullable = true, precision = 2)
    public BigDecimal getCuesStructural() {
        return cuesStructural;
    }

    public void setCuesStructural(BigDecimal cuesStructural) {
        this.cuesStructural = cuesStructural;
    }

    @Basic
    @Column(name = "cues_visual", nullable = true, precision = 2)
    public BigDecimal getCuesVisual() {
        return cuesVisual;
    }

    public void setCuesVisual(BigDecimal cuesVisual) {
        this.cuesVisual = cuesVisual;
    }

    @Basic
    @Column(name = "cues_ommissions", nullable = true, precision = 2)
    public BigDecimal getCuesOmmissions() {
        return cuesOmmissions;
    }

    public void setCuesOmmissions(BigDecimal cuesOmmissions) {
        this.cuesOmmissions = cuesOmmissions;
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
        FactOrrAssignmentNoAggEntity that = (FactOrrAssignmentNoAggEntity) o;
        return orrAssignmentId == that.orrAssignmentId &&
                Objects.equals(buAssignmentId, that.buAssignmentId) &&
                Objects.equals(sourceAssignmentId, that.sourceAssignmentId) &&
                Objects.equals(assignmentMethod, that.assignmentMethod) &&
                Objects.equals(assignedDate, that.assignedDate) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(assignmentCompletionDate, that.assignmentCompletionDate) &&
                Objects.equals(assignmentCreatedDatetime, that.assignmentCreatedDatetime) &&
                Objects.equals(assignmentModifiedDatetime, that.assignmentModifiedDatetime) &&
                Objects.equals(readType, that.readType) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(wordCount, that.wordCount) &&
                Objects.equals(proficiency, that.proficiency) &&
                Objects.equals(accuracy, that.accuracy) &&
                Objects.equals(errorRate, that.errorRate) &&
                Objects.equals(selfCorrectionRate, that.selfCorrectionRate) &&
                Objects.equals(fluency, that.fluency) &&
                Objects.equals(markingSubstitutions, that.markingSubstitutions) &&
                Objects.equals(markingOmmissions, that.markingOmmissions) &&
                Objects.equals(markingInsertions, that.markingInsertions) &&
                Objects.equals(markingTolds, that.markingTolds) &&
                Objects.equals(markingRepetitions, that.markingRepetitions) &&
                Objects.equals(markingSelfCorrections, that.markingSelfCorrections) &&
                Objects.equals(cuesMeaning, that.cuesMeaning) &&
                Objects.equals(cuesStructural, that.cuesStructural) &&
                Objects.equals(cuesVisual, that.cuesVisual) &&
                Objects.equals(cuesOmmissions, that.cuesOmmissions) &&
                Objects.equals(recordFlag, that.recordFlag) &&
                Objects.equals(deleteIndicator, that.deleteIndicator) &&
                Objects.equals(recordCreatedDatetime, that.recordCreatedDatetime) &&
                Objects.equals(recordModifiedDatetime, that.recordModifiedDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orrAssignmentId, buAssignmentId, sourceAssignmentId, assignmentMethod, assignedDate, dueDate, assignmentCompletionDate, assignmentCreatedDatetime, assignmentModifiedDatetime, readType, notes, wordCount, proficiency, accuracy, errorRate, selfCorrectionRate, fluency, markingSubstitutions, markingOmmissions, markingInsertions, markingTolds, markingRepetitions, markingSelfCorrections, cuesMeaning, cuesStructural, cuesVisual, cuesOmmissions, recordFlag, deleteIndicator, recordCreatedDatetime, recordModifiedDatetime);
    }

    @ManyToOne
    @JoinColumn(name = "dim_assessment_test_id", referencedColumnName = "dim_assessment_test_id")
    public DimAssessmentTestEntity getDimAssessmentTestByDimAssessmentTestId() {
        return dimAssessmentTestByDimAssessmentTestId;
    }

    public void setDimAssessmentTestByDimAssessmentTestId(DimAssessmentTestEntity dimAssessmentTestByDimAssessmentTestId) {
        this.dimAssessmentTestByDimAssessmentTestId = dimAssessmentTestByDimAssessmentTestId;
    }

    @ManyToOne
    @JoinColumn(name = "dim_student_id", referencedColumnName = "dim_student_id")
    public DimStudentEntity getDimStudentByDimStudentId() {
        return dimStudentByDimStudentId;
    }

    public void setDimStudentByDimStudentId(DimStudentEntity dimStudentByDimStudentId) {
        this.dimStudentByDimStudentId = dimStudentByDimStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "dim_assignment_creator_id", referencedColumnName = "dim_assignment_creator_id")
    public DimAssignmentCreatorEntity getDimAssignmentCreatorByDimAssignmentCreatorId() {
        return dimAssignmentCreatorByDimAssignmentCreatorId;
    }

    public void setDimAssignmentCreatorByDimAssignmentCreatorId(DimAssignmentCreatorEntity dimAssignmentCreatorByDimAssignmentCreatorId) {
        this.dimAssignmentCreatorByDimAssignmentCreatorId = dimAssignmentCreatorByDimAssignmentCreatorId;
    }

    @ManyToOne
    @JoinColumn(name = "dim_test_instance_id", referencedColumnName = "dim_test_instance_id")
    public DimTestInstanceEntity getDimTestInstanceByDimTestInstanceId() {
        return dimTestInstanceByDimTestInstanceId;
    }

    public void setDimTestInstanceByDimTestInstanceId(DimTestInstanceEntity dimTestInstanceByDimTestInstanceId) {
        this.dimTestInstanceByDimTestInstanceId = dimTestInstanceByDimTestInstanceId;
    }

    @ManyToOne
    @JoinColumn(name = "dim_district_id", referencedColumnName = "dim_district_id")
    public DimDistrictEntity getDimDistrictByDimDistrictId() {
        return dimDistrictByDimDistrictId;
    }

    public void setDimDistrictByDimDistrictId(DimDistrictEntity dimDistrictByDimDistrictId) {
        this.dimDistrictByDimDistrictId = dimDistrictByDimDistrictId;
    }

    @ManyToOne
    @JoinColumn(name = "dim_school_id", referencedColumnName = "dim_school_id")
    public DimSchoolEntity getDimSchoolByDimSchoolId() {
        return dimSchoolByDimSchoolId;
    }

    public void setDimSchoolByDimSchoolId(DimSchoolEntity dimSchoolByDimSchoolId) {
        this.dimSchoolByDimSchoolId = dimSchoolByDimSchoolId;
    }

    @ManyToOne
    @JoinColumn(name = "dim_class_id", referencedColumnName = "dim_class_id")
    public DimClassEntity getDimClassByDimClassId() {
        return dimClassByDimClassId;
    }

    public void setDimClassByDimClassId(DimClassEntity dimClassByDimClassId) {
        this.dimClassByDimClassId = dimClassByDimClassId;
    }

    @ManyToOne
    @JoinColumn(name = "dim_reading_level_id", referencedColumnName = "dim_reading_level_id")
    public DimReadingLevelsEntity getDimReadingLevelsByDimReadingLevelId() {
        return dimReadingLevelsByDimReadingLevelId;
    }

    public void setDimReadingLevelsByDimReadingLevelId(DimReadingLevelsEntity dimReadingLevelsByDimReadingLevelId) {
        this.dimReadingLevelsByDimReadingLevelId = dimReadingLevelsByDimReadingLevelId;
    }
}
