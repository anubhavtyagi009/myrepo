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

public class ErrorAnalysisDonutDTO {
    private Long substitution;
    private Long ommission;
    private Long insertion;
    private Long told;
    private Long repetation;
    private Long selfCorrection;

    public ErrorAnalysisDonutDTO(Long substitution, Long ommission, Long insertion, Long told, Long repetation, Long selfCorrection) {
        this.substitution = substitution;
        this.ommission = ommission;
        this.insertion = insertion;
        this.told = told;
        this.repetation = repetation;
        this.selfCorrection = selfCorrection;
    }

    public ErrorAnalysisDonutDTO() {
    }

    public Long getSubstitution() {
        return substitution;
    }

    public void setSubstitution(Long substitution) {
        this.substitution = substitution;
    }

    public Long getOmmission() {
        return ommission;
    }

    public void setOmmission(Long ommission) {
        this.ommission = ommission;
    }

    public Long getInsertion() {
        return insertion;
    }

    public void setInsertion(Long insertion) {
        this.insertion = insertion;
    }

    public Long getTold() {
        return told;
    }

    public void setTold(Long told) {
        this.told = told;
    }

    public Long getRepetation() {
        return repetation;
    }

    public void setRepetation(Long repetation) {
        this.repetation = repetation;
    }

    public Long getSelfCorrection() {
        return selfCorrection;
    }

    public void setSelfCorrection(Long selfCorrection) {
        this.selfCorrection = selfCorrection;
    }
}
