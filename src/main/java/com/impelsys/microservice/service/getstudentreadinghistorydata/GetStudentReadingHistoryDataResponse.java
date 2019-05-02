package com.impelsys.microservice.service.getstudentreadinghistorydata;

import com.impelsys.microservice.service.CommonServiceResponse;
import org.springframework.data.domain.Page;
import com.impelsys.microservice.dto.StudentReadingHistoryDataDTO;

public class GetStudentReadingHistoryDataResponse extends CommonServiceResponse {

    private Page<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTO;

    public GetStudentReadingHistoryDataResponse(Page<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTO) {
        this.studentReadingHistoryDataDTO = studentReadingHistoryDataDTO;
    }

    public GetStudentReadingHistoryDataResponse() {
    }

    public Page<StudentReadingHistoryDataDTO> getStudentReadingHistoryDataDTO() {
        return studentReadingHistoryDataDTO;
    }

    public void setStudentReadingHistoryDataDTO(Page<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTO) {
        this.studentReadingHistoryDataDTO = studentReadingHistoryDataDTO;
    }
}
