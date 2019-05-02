package com.impelsys.microservice.web.rest;

import com.impelsys.microservice.service.getstudentreadinghistorydata.GetStudentReadingHistoryDataRequest;
import com.impelsys.microservice.service.getstudentreadinghistorydata.GetStudentReadingHistoryDataResponse;
import com.impelsys.microservice.service.getstudentreadinghistorydata.GetStudentReadingHistoryDataService;
import com.impelsys.microservice.service.getclassreadinghistorydata.GetClassReadingHistoryDataRequest;
import com.impelsys.microservice.service.getclassreadinghistorydata.GetClassReadingHistoryDataResponse;
import com.impelsys.microservice.service.getclassreadinghistorydata.GetClassReadingHistoryDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReadingHistoryController {
    private final static Logger log = LoggerFactory.getLogger(ReadingHistoryController.class);

    @Autowired
    private GetClassReadingHistoryDataService getClassReadingHistoryDataService;

    @Autowired
    private GetStudentReadingHistoryDataService getStudentReadingHistoryDataService;

    // get class reading history data
    @PostMapping(value = "/classReadingHistoryData")
    public ResponseEntity getClassReadingHistoryData(@RequestBody GetClassReadingHistoryDataRequest request, Pageable pageable){
        log.debug("Fetching reading history chart data for class-----");
        GetClassReadingHistoryDataResponse response = null;
        try {
            response = getClassReadingHistoryDataService.execute(request, pageable);
        } catch (Exception e) {
            log.error("Error in fetching Class Reading History Chart Data :" + e.getMessage());
            response.SUCCESSFULL = false;
            response.setMessage("Error in fetching Class Reading History Chart Data :");
        }
        if (response.SUCCESSFULL)
            return ResponseEntity.ok().header(response.getMessage()).body(response);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(response.getMessage()).body(response);
    }

    // get student reading history data
    @PostMapping(value = "/studentReadingHistoryData")
    public ResponseEntity getStudentReadingHistoryData(@RequestBody GetStudentReadingHistoryDataRequest request, Pageable pageable) {
        log.debug("Fetching Student Reading History Chart Data for Student-----");
        GetStudentReadingHistoryDataResponse response = null;
        try {
            response = getStudentReadingHistoryDataService.execute(request, pageable);
        } catch (Exception e) {
            log.error("Error in fetching Student Reading History Chart Data :" + e.getMessage());
            response.SUCCESSFULL = false;
            response.setMessage("Error in fetching Student Reading History Chart Data :");
        }
        if (response.SUCCESSFULL)
            return ResponseEntity.ok().header(response.getMessage()).body(response);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(response.getMessage()).body(response);
    }
}
