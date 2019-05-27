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

import com.bec.orrreporting.service.getfactdimupdatestatus.GetFactDimUpdateStatusResponse;
import com.bec.orrreporting.service.getfactdimupdatestatus.GetFactDimUpdateStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FactDimUpdateStatusController {
    private final static Logger log = LoggerFactory.getLogger(FactDimUpdateStatusController.class);

    @Autowired
    GetFactDimUpdateStatusService getFactDimUpdateStatusService;

    // get fact update status
    @GetMapping(value = "/getFactDimUpdateStatus/{assignmentId}")
    public ResponseEntity getFactDimUpdateStatus(@PathVariable Long assignmentId) {
        log.debug("Get Fact update status by AssignmentId-----");
        GetFactDimUpdateStatusResponse response = null;
        try {
            response = getFactDimUpdateStatusService.execute(assignmentId);
        } catch (Exception e) {
            log.error("Error in fetching Fact update status by AssignmentId :" + e.getMessage());
        }
        if (response.SUCCESSFULL)
            return ResponseEntity.ok().header(response.getMessage()).body(response);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(response.getErrorMessage()).body(response);
    }
}
