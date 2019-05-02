package com.impelsys.microservice.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ErrorAnalysisDataResultDTO {

    private List<SubstitutionDTO> substitution;
    private List<OmissionDTO> omission;
    private List<InsertionDTO> insertion;
    private List<ToldDTO> told;
    private List<RepetationDTO> repetation;
    private List<SelfCorrectionDTO> selfCorrection;
    private List<MeaningCuesDTO> meaningCues;
    private List<StructuralCuesDTO> structuralCues;
    private List<VisualCuesDTO> visualCues;
    private List<OmissionToldsDTO> omissionTolds;

    public ErrorAnalysisDataResultDTO(List<SubstitutionDTO> substitution, List<OmissionDTO> omission, List<InsertionDTO> insertion, List<ToldDTO> told, List<RepetationDTO> repetation, List<SelfCorrectionDTO> selfCorrection, List<MeaningCuesDTO> meaningCues, List<StructuralCuesDTO> structuralCues, List<VisualCuesDTO> visualCues, List<OmissionToldsDTO> omissionTolds) {
        this.substitution = substitution;
        this.omission = omission;
        this.insertion = insertion;
        this.told = told;
        this.repetation = repetation;
        this.selfCorrection = selfCorrection;
        this.meaningCues = meaningCues;
        this.structuralCues = structuralCues;
        this.visualCues = visualCues;
        this.omissionTolds = omissionTolds;
    }

    public ErrorAnalysisDataResultDTO() {
    }

    public List<SubstitutionDTO> getSubstitution() {
        return substitution;
    }

    public void setSubstitution(List<SubstitutionDTO> substitution) {
        this.substitution = substitution;
    }

    public List<OmissionDTO> getOmission() {
        return omission;
    }

    public void setOmission(List<OmissionDTO> omission) {
        this.omission = omission;
    }

    public List<InsertionDTO> getInsertion() {
        return insertion;
    }

    public void setInsertion(List<InsertionDTO> insertion) {
        this.insertion = insertion;
    }

    public List<ToldDTO> getTold() {
        return told;
    }

    public void setTold(List<ToldDTO> told) {
        this.told = told;
    }

    public List<RepetationDTO> getRepetation() {
        return repetation;
    }

    public void setRepetation(List<RepetationDTO> repetation) {
        this.repetation = repetation;
    }

    public List<SelfCorrectionDTO> getSelfCorrection() {
        return selfCorrection;
    }

    public void setSelfCorrection(List<SelfCorrectionDTO> selfCorrection) {
        this.selfCorrection = selfCorrection;
    }

    public List<MeaningCuesDTO> getMeaningCues() {
        return meaningCues;
    }

    public void setMeaningCues(List<MeaningCuesDTO> meaningCues) {
        this.meaningCues = meaningCues;
    }

    public List<StructuralCuesDTO> getStructuralCues() {
        return structuralCues;
    }

    public void setStructuralCues(List<StructuralCuesDTO> structuralCues) {
        this.structuralCues = structuralCues;
    }

    public List<VisualCuesDTO> getVisualCues() {
        return visualCues;
    }

    public void setVisualCues(List<VisualCuesDTO> visualCues) {
        this.visualCues = visualCues;
    }

    public List<OmissionToldsDTO> getOmissionTolds() {
        return omissionTolds;
    }

    public void setOmissionTolds(List<OmissionToldsDTO> omissionTolds) {
        this.omissionTolds = omissionTolds;
    }
}
