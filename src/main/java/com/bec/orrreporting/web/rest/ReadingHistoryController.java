/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * MAY 23 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.orrreporting.web.rest;

import com.bec.orrreporting.service.getclassreadinghistorydata.GetClassReadingHistoryDataRequest;
import com.bec.orrreporting.service.getclassreadinghistorydata.GetClassReadingHistoryDataResponse;
import com.bec.orrreporting.service.getclassreadinghistorydata.GetClassReadingHistoryDataService;
import com.bec.orrreporting.service.getstudentreadinghistorydata.GetStudentReadingHistoryDataRequest;
import com.bec.orrreporting.service.getstudentreadinghistorydata.GetStudentReadingHistoryDataResponse;
import com.bec.orrreporting.service.getstudentreadinghistorydata.GetStudentReadingHistoryDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReadingHistoryController {
    private final static Logger log = LoggerFactory.getLogger(ReadingHistoryController.class);

    @Autowired
    private GetClassReadingHistoryDataService getClassReadingHistoryDataService;

    @Autowired
    private GetStudentReadingHistoryDataService getStudentReadingHistoryDataService;

    // get class reading history data
    @PostMapping(value = "/classReadingHistoryData")
    public ResponseEntity getClassReadingHistoryData(@RequestBody GetClassReadingHistoryDataRequest request) {
        log.debug("Fetching reading history chart data for class-----");
        GetClassReadingHistoryDataResponse response = null;
        try {
            response = getClassReadingHistoryDataService.execute(request);
        } catch (Exception e) {
            log.error("Error in fetching Class Reading History Chart Data :" + e.getMessage());
        }
        if (response.SUCCESSFULL)
            return ResponseEntity.ok().header(response.getMessage()).body(response);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(response.getErrorMessage()).body(response);
    }

    // get student reading history data
    @PostMapping(value = "/studentReadingHistoryData")
    public ResponseEntity getStudentReadingHistoryData(@RequestBody GetStudentReadingHistoryDataRequest request) {
        log.debug("Fetching Student Reading History Chart Data for Student-----");
        GetStudentReadingHistoryDataResponse response = null;
        try {
            response = getStudentReadingHistoryDataService.execute(request);
        } catch (Exception e) {
            log.error("Error in fetching Student Reading History Chart Data :" + e.getMessage());
        }
        if (response.SUCCESSFULL)
            return ResponseEntity.ok().header(response.getMessage()).body(response);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(response.getErrorMessage()).body(response);
    }
}
