package com.impelsys.microservice.service.getreadinglevelprogressdata;

import com.impelsys.microservice.dto.RplResponseDataDTO;
import com.impelsys.microservice.service.CommonServiceResponse;

public class GetReadingLevelProgressDataResponse extends CommonServiceResponse {

    private RplResponseDataDTO responseData;

    public GetReadingLevelProgressDataResponse(RplResponseDataDTO responseData) {
        this.responseData = responseData;
    }

    public RplResponseDataDTO getResponseData() {
        return responseData;
    }

    public void setResponseData(RplResponseDataDTO responseData) {
        this.responseData = responseData;
    }
}
