package com.impelsys.microservice.service.getclassreadinghistorydata;

import com.impelsys.microservice.dto.ClassReadingHistoryDataDTO;
import com.impelsys.microservice.service.CommonServiceResponse;
import org.springframework.data.domain.Page;

public class GetClassReadingHistoryDataResponse extends CommonServiceResponse {

    private Page<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOS;

    public GetClassReadingHistoryDataResponse(Page<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOS) {
        this.classReadingHistoryDataDTOS = classReadingHistoryDataDTOS;
    }

    public GetClassReadingHistoryDataResponse() {
    }

    public Page<ClassReadingHistoryDataDTO> getClassReadingHistoryDataDTOS() {
        return classReadingHistoryDataDTOS;
    }

    public void setClassReadingHistoryDataDTOS(Page<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOS) {
        this.classReadingHistoryDataDTOS = classReadingHistoryDataDTOS;
    }
}
