package com.impelsys.microservice.dto;

public class FiltersDTO {
    private InternalFilterDTO internalFilter;
    private ExternalFilterDTO externalFilter;

    public InternalFilterDTO getInternalFilter() {
        return internalFilter;
    }

    public void setInternalFilter(InternalFilterDTO internalFilter) {
        this.internalFilter = internalFilter;
    }

    public ExternalFilterDTO getExternalFilter() {
        return externalFilter;
    }

    public void setExternalFilter(ExternalFilterDTO externalFilter) {
        this.externalFilter = externalFilter;
    }
}
