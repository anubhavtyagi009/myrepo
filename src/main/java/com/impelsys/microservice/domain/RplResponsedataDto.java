package com.impelsys.microservice.domain;

import java.util.List;

public class RplResponsedataDto {

    private Internalfilter internalfilter;
    private Externalfilter externalfilter;
    private List<ReadingLevelaxis> readingLevelaxis;
    private List<DateRangeaxis> dateRangeaxis;
    private List<Fluencyaxis> fluencyaxis;
    private List<Accuracyaxis> accuracyaxis;
    private List<AssignmentData> assignmentdata;
    private List<FluencyData> fluencydata;
    private List<AccuracyData> accuracydata;

    public RplResponsedataDto(Internalfilter internalfilter, Externalfilter externalfilter, List<ReadingLevelaxis> readingLevelaxis, List<DateRangeaxis> dateRangeaxis, List<Fluencyaxis> fluencyaxis, List<Accuracyaxis> accuracyaxis, List<AssignmentData> assignmentdata, List<FluencyData> fluencydata, List<AccuracyData> accuracydata) {
        this.internalfilter = internalfilter;
        this.externalfilter = externalfilter;
        this.readingLevelaxis = readingLevelaxis;
        this.dateRangeaxis = dateRangeaxis;
        this.fluencyaxis = fluencyaxis;
        this.accuracyaxis = accuracyaxis;
        this.assignmentdata = assignmentdata;
        this.fluencydata = fluencydata;
        this.accuracydata = accuracydata;
    }

    public List<FluencyData> getFluencydata() {
        return fluencydata;
    }

    public void setFluencydata(List<FluencyData> fluencydata) {
        this.fluencydata = fluencydata;
    }

    public List<AccuracyData> getAccuracydata() {
        return accuracydata;
    }

    public void setAccuracydata(List<AccuracyData> accuracydata) {
        this.accuracydata = accuracydata;
    }

    public List<AssignmentData> getAssignmentdata() {
        return assignmentdata;
    }

    public void setAssignmentdata(List<AssignmentData> assignmentdata) {
        this.assignmentdata = assignmentdata;
    }

    public List<Accuracyaxis> getAccuracyaxis() {
        return accuracyaxis;
    }

    public void setAccuracyaxis(List<Accuracyaxis> accuracyaxis) {
        this.accuracyaxis = accuracyaxis;
    }

    public List<DateRangeaxis> getDateRangeaxis() {
        return dateRangeaxis;
    }

    public void setDateRangeaxis(List<DateRangeaxis> dateRangeaxis) {
        this.dateRangeaxis = dateRangeaxis;
    }

    public void setReadingLevelaxis(List<ReadingLevelaxis> readingLevelaxis) {
        this.readingLevelaxis = readingLevelaxis;
    }

    public Internalfilter getInternalfilter() {
        return internalfilter;
    }

    public void setInternalfilter(Internalfilter internalfilter) {
        this.internalfilter = internalfilter;
    }

    public Externalfilter getExternalfilter() {
        return externalfilter;
    }

    public void setExternalfilter(Externalfilter externalfilter) {
        this.externalfilter = externalfilter;
    }

    public List<ReadingLevelaxis> getReadingLevelaxis() {
        return readingLevelaxis;
    }

    public List<Fluencyaxis> getFluencyaxis() {
        return fluencyaxis;
    }

    public void setFluencyaxis(List<Fluencyaxis> fluencyaxis) {
        this.fluencyaxis = fluencyaxis;
    }
}
