package com.impelsys.microservice.service.getreadinglevelprogressdata;

import com.impelsys.microservice.exception.OrrServiceException;
import org.springframework.stereotype.Service;

@Service("getReadingLevelProgressDataService")
public class GetReadingLevelProgressDataServiceImpl implements GetReadingLevelProgressDataService {


    @Override
    public GetReadingLevelProgressDataResponse execute(GetReadingLevelProgressDataRequest request) throws OrrServiceException {

        GetReadingLevelProgressDataResponse response = new GetReadingLevelProgressDataResponse();
        response.SUCCESSFUL= true;
        response.setMessage(" get reading level progress data fetched");
        return response;
    }
}
