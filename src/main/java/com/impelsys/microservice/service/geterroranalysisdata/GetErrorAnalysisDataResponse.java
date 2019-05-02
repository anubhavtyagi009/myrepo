package com.impelsys.microservice.service.geterroranalysisdata;

import com.impelsys.microservice.dto.*;
import com.impelsys.microservice.service.CommonServiceResponse;

import java.util.List;

public class GetErrorAnalysisDataResponse extends CommonServiceResponse {
    private ErrorAnalysisResponseDataDTO responseData;

    public GetErrorAnalysisDataResponse(ErrorAnalysisResponseDataDTO responseData) {
        this.responseData = responseData;
    }

    public ErrorAnalysisResponseDataDTO getResponseData() {
        return responseData;
    }

    public void setResponseData(ErrorAnalysisResponseDataDTO responseData) {
        this.responseData = responseData;
    }
}
