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

public class ErrorAnalysisAverageDTO {

    private Long substitutionAverage;
    private Long ommissionAverage;
    private Long insertionAverage;
    private Long toldAverage;
    private Long repetationAverage;
    private Long selfCorrectionAverage;
    private Long meaningCuesAverage;
    private Long structuralCuesAverage;
    private Long visualCuesAverage;
    private Long ommissionToldsAverage;

    public ErrorAnalysisAverageDTO(Long substitutionAverage, Long ommissionAverage, Long insertionAverage, Long toldAverage, Long repetationAverage, Long selfCorrectionAverage, Long meaningCuesAverage, Long structuralCuesAverage, Long visualCuesAverage, Long ommissionToldsAverage) {
        this.substitutionAverage = substitutionAverage;
        this.ommissionAverage = ommissionAverage;
        this.insertionAverage = insertionAverage;
        this.toldAverage = toldAverage;
        this.repetationAverage = repetationAverage;
        this.selfCorrectionAverage = selfCorrectionAverage;
        this.meaningCuesAverage = meaningCuesAverage;
        this.structuralCuesAverage = structuralCuesAverage;
        this.visualCuesAverage = visualCuesAverage;
        this.ommissionToldsAverage = ommissionToldsAverage;
    }

    public ErrorAnalysisAverageDTO() {
    }

    public Long getSubstitutionAverage() {
        return substitutionAverage;
    }

    public void setSubstitutionAverage(Long substitutionAverage) {
        this.substitutionAverage = substitutionAverage;
    }

    public Long getOmmissionAverage() {
        return ommissionAverage;
    }

    public void setOmmissionAverage(Long ommissionAverage) {
        this.ommissionAverage = ommissionAverage;
    }

    public Long getInsertionAverage() {
        return insertionAverage;
    }

    public void setInsertionAverage(Long insertionAverage) {
        this.insertionAverage = insertionAverage;
    }

    public Long getToldAverage() {
        return toldAverage;
    }

    public void setToldAverage(Long toldAverage) {
        this.toldAverage = toldAverage;
    }

    public Long getRepetationAverage() {
        return repetationAverage;
    }

    public void setRepetationAverage(Long repetationAverage) {
        this.repetationAverage = repetationAverage;
    }

    public Long getSelfCorrectionAverage() {
        return selfCorrectionAverage;
    }

    public void setSelfCorrectionAverage(Long selfCorrectionAverage) {
        this.selfCorrectionAverage = selfCorrectionAverage;
    }

    public Long getMeaningCuesAverage() {
        return meaningCuesAverage;
    }

    public void setMeaningCuesAverage(Long meaningCuesAverage) {
        this.meaningCuesAverage = meaningCuesAverage;
    }

    public Long getStructuralCuesAverage() {
        return structuralCuesAverage;
    }

    public void setStructuralCuesAverage(Long structuralCuesAverage) {
        this.structuralCuesAverage = structuralCuesAverage;
    }

    public Long getVisualCuesAverage() {
        return visualCuesAverage;
    }

    public void setVisualCuesAverage(Long visualCuesAverage) {
        this.visualCuesAverage = visualCuesAverage;
    }

    public Long getOmmissionToldsAverage() {
        return ommissionToldsAverage;
    }

    public void setOmmissionToldsAverage(Long ommissionToldsAverage) {
        this.ommissionToldsAverage = ommissionToldsAverage;
    }
}


