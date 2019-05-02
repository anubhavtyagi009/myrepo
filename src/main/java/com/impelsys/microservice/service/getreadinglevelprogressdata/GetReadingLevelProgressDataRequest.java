package com.impelsys.microservice.service.getreadinglevelprogressdata;

import com.impelsys.microservice.dto.FiltersDTO;
import com.impelsys.microservice.service.CommonServiceRequest;

public class GetReadingLevelProgressDataRequest implements CommonServiceRequest {

    private FiltersDTO filters;

    public FiltersDTO getFilters() {
        return filters;
    }

    public void setFilters(FiltersDTO filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "GetReadingLevelProgressDataRequest{" +
                "filters=" + filters +
                '}';
    }
}
