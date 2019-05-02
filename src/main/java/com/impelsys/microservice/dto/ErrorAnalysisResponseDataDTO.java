package com.impelsys.microservice.dto;

import java.util.List;

public class ErrorAnalysisResponseDataDTO {

    private ExternalFilterDTO externalFilter;
    private InternalFilterDTO internalFilter;
    private List<DateRangeAxisDTO> dateRangeAxis;
    private List<ErrorAnalysisDataResultDTO> errorAnalysisDataResultDTOList;

    public ErrorAnalysisResponseDataDTO(ExternalFilterDTO externalFilter, InternalFilterDTO internalFilter, List<DateRangeAxisDTO> dateRangeAxis, List<ErrorAnalysisDataResultDTO> errorAnalysisDataResultDTOList) {
        this.externalFilter = externalFilter;
        this.internalFilter = internalFilter;
        this.dateRangeAxis = dateRangeAxis;
        this.errorAnalysisDataResultDTOList = errorAnalysisDataResultDTOList;
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

    public List<ErrorAnalysisDataResultDTO> getErrorAnalysisDataResultDTOList() {
        return errorAnalysisDataResultDTOList;
    }

    public void setErrorAnalysisDataResultDTOList(List<ErrorAnalysisDataResultDTO> errorAnalysisDataResultDTOList) {
        this.errorAnalysisDataResultDTOList = errorAnalysisDataResultDTOList;
    }
}
