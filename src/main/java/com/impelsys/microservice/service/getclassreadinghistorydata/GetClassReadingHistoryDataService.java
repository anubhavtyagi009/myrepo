package com.impelsys.microservice.service.getclassreadinghistorydata;

import org.springframework.data.domain.Pageable;

public interface GetClassReadingHistoryDataService {
    GetClassReadingHistoryDataResponse execute(GetClassReadingHistoryDataRequest request, Pageable pageable) throws Exception;
}
