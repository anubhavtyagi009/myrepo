package com.impelsys.microservice.web.rest;

import com.impelsys.microservice.service.getreadinglevelprogressdata.GetReadingLevelProgressDataRequest;
import com.impelsys.microservice.service.getreadinglevelprogressdata.GetReadingLevelProgressDataResponse;
import com.impelsys.microservice.service.getreadinglevelprogressdata.GetReadingLevelProgressDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReadingLevelProgressController {
    private final static Logger log = LoggerFactory.getLogger(ReadingLevelProgressController.class);

    @Autowired
    private GetReadingLevelProgressDataService getReadingLevelProgressDataService;

    // get reading level progress data
    @PostMapping(value = "/readingLevelProgressData")
    public ResponseEntity getReadingLevelProgressData(@RequestBody GetReadingLevelProgressDataRequest request){
        log.debug("Fetching ReadingLevelProgress Chart Data");
        GetReadingLevelProgressDataResponse response = null;
        try {
            response = getReadingLevelProgressDataService.execute(request);
        }catch (Exception e){
            log.error("Error in fetching ReadingLevelProgress Chart Data :" + e.getMessage());
            response.SUCCESSFULL = false;
            response.setMessage("Error in fetching ReadingLevelProgress Chart Data :");
        }
       if (response.SUCCESSFULL)
           return ResponseEntity.ok().header(response.getMessage()).body(response);
       else
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(response.getMessage()).body(response);
    }

}
