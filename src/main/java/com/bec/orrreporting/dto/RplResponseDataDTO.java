/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * MAY 23 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.orrreporting.dto;

import java.util.List;

public class RplResponseDataDTO {

    private ExternalFilterDTO externalFilter;
    private InternalFilterDTO internalFilter;
    private List<DateRangeAxisDTO> dateRangeAxis;
    private List<ReadingLevelAxisDTO> readingLevelAxis;
    private List<AssignmentDataResultDTO> assignmentDataList;
    private List<FluencyAxisDTO> fluencyAxis;
    private List<FluencyDataDTO> fluencyDataList;
    private List<AccuracyAxisDTO> accuracyAxis;
    private List<AccuracyDataDTO> accuracyDataList;
    private StudentStartingLevelDTO studentStartingLevel;
    private StudentReadingTargetDTO studentReadingTarget;

    public RplResponseDataDTO(ExternalFilterDTO externalFilter, InternalFilterDTO internalFilter, List<DateRangeAxisDTO> dateRangeAxis, List<ReadingLevelAxisDTO> readingLevelAxis, List<AssignmentDataResultDTO> assignmentDataList, List<FluencyAxisDTO> fluencyAxis, List<FluencyDataDTO> fluencyDataList, List<AccuracyAxisDTO> accuracyAxis, List<AccuracyDataDTO> accuracyDataList, StudentStartingLevelDTO studentStartingLevel, StudentReadingTargetDTO studentReadingTarget) {
        this.externalFilter = externalFilter;
        this.internalFilter = internalFilter;
        this.dateRangeAxis = dateRangeAxis;
        this.readingLevelAxis = readingLevelAxis;
        this.assignmentDataList = assignmentDataList;
        this.fluencyAxis = fluencyAxis;
        this.fluencyDataList = fluencyDataList;
        this.accuracyAxis = accuracyAxis;
        this.accuracyDataList = accuracyDataList;
        this.studentStartingLevel = studentStartingLevel;
        this.studentReadingTarget = studentReadingTarget;
    }

    public ExternalFilterDTO getExternalFilter() {
        return externalFilter;
    }

    public void setExternalFilter(ExternalFilterDTO externalFilter) {
        this.externalFilter = externalFilter;
    }

    public InternalFilterDTO getInternalFilter() {
        return internalFilter;
    }

    public void setInternalFilter(InternalFilterDTO internalFilter) {
        this.internalFilter = internalFilter;
    }

    public List<DateRangeAxisDTO> getDateRangeAxis() {
        return dateRangeAxis;
    }

    public void setDateRangeAxis(List<DateRangeAxisDTO> dateRangeAxis) {
        this.dateRangeAxis = dateRangeAxis;
    }

    public List<ReadingLevelAxisDTO> getReadingLevelAxis() {
        return readingLevelAxis;
    }

    public void setReadingLevelAxis(List<ReadingLevelAxisDTO> readingLevelAxis) {
        this.readingLevelAxis = readingLevelAxis;
    }

    public List<AssignmentDataResultDTO> getAssignmentDataList() {
        return assignmentDataList;
    }

    public void setAssignmentDataList(List<AssignmentDataResultDTO> assignmentDataList) {
        this.assignmentDataList = assignmentDataList;
    }

    public List<FluencyAxisDTO> getFluencyAxis() {
        return fluencyAxis;
    }

    public void setFluencyAxis(List<FluencyAxisDTO> fluencyAxis) {
        this.fluencyAxis = fluencyAxis;
    }

    public List<FluencyDataDTO> getFluencyDataList() {
        return fluencyDataList;
    }

    public void setFluencyDataList(List<FluencyDataDTO> fluencyDataList) {
        this.fluencyDataList = fluencyDataList;
    }

    public List<AccuracyAxisDTO> getAccuracyAxis() {
        return accuracyAxis;
    }

    public void setAccuracyAxis(List<AccuracyAxisDTO> accuracyAxis) {
        this.accuracyAxis = accuracyAxis;
    }

    public List<AccuracyDataDTO> getAccuracyDataList() {
        return accuracyDataList;
    }

    public void setAccuracyDataList(List<AccuracyDataDTO> accuracyDataList) {
        this.accuracyDataList = accuracyDataList;
    }

    public StudentStartingLevelDTO getStudentStartingLevel() {
        return studentStartingLevel;
    }

    public void setStudentStartingLevel(StudentStartingLevelDTO studentStartingLevel) {
        this.studentStartingLevel = studentStartingLevel;
    }

    public StudentReadingTargetDTO getStudentReadingTarget() {
        return studentReadingTarget;
    }

    public void setStudentReadingTarget(StudentReadingTargetDTO studentReadingTarget) {
        this.studentReadingTarget = studentReadingTarget;
    }
}
