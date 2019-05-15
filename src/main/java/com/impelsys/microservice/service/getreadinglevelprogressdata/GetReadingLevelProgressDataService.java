package com.impelsys.microservice.service.getreadinglevelprogressdata;

import com.impelsys.microservice.exception.OrrServiceException;

public interface GetReadingLevelProgressDataService {

    GetReadingLevelProgressDataResponse execute(GetReadingLevelProgressDataRequest request)throws OrrServiceException;
}
