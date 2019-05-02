package com.impelsys.microservice.service.getstudentreadinghistorydata;

import org.springframework.data.domain.Pageable;

public interface GetStudentReadingHistoryDataService {
    GetStudentReadingHistoryDataResponse execute(GetStudentReadingHistoryDataRequest request, Pageable pageable) throws Exception;
}
