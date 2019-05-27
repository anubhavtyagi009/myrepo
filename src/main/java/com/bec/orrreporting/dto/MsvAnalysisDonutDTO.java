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

public class MsvAnalysisDonutDTO {
    private Integer meaningCues;
    private Integer structuralCues;
    private Integer visualCues;
    private Integer ommissionAndTolds;

    public MsvAnalysisDonutDTO(Integer meaningCues, Integer structuralCues, Integer visualCues, Integer ommissionAndTolds) {
        this.meaningCues = meaningCues;
        this.structuralCues = structuralCues;
        this.visualCues = visualCues;
        this.ommissionAndTolds = ommissionAndTolds;
    }

    public MsvAnalysisDonutDTO() {
    }

    public Integer getMeaningCues() {
        return meaningCues;
    }

    public void setMeaningCues(Integer meaningCues) {
        this.meaningCues = meaningCues;
    }

    public Integer getStructuralCues() {
        return structuralCues;
    }

    public void setStructuralCues(Integer structuralCues) {
        this.structuralCues = structuralCues;
    }

    public Integer getVisualCues() {
        return visualCues;
    }

    public void setVisualCues(Integer visualCues) {
        this.visualCues = visualCues;
    }

    public Integer getOmmissionAndTolds() {
        return ommissionAndTolds;
    }

    public void setOmmissionAndTolds(Integer ommissionAndTolds) {
        this.ommissionAndTolds = ommissionAndTolds;
    }
}
