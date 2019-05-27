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

import com.bec.orrreporting.service.getsequencenumber.GetSequenceNumberResponse;
import com.bec.orrreporting.service.getsequencenumber.GetSequenceNumberService;
import com.bec.orrreporting.service.servicegateway.ServiceGateway;
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
public class EntityIdListController {
    private final static Logger log = LoggerFactory.getLogger(EntityIdListController.class);

    private final GetSequenceNumberService getSequenceNumberService;
    @Autowired
    ServiceGateway serviceGateway;

    public EntityIdListController(GetSequenceNumberService getSequenceNumberService) {
        this.getSequenceNumberService = getSequenceNumberService;
    }

    // get sequence number by entity name
    @GetMapping(value = "/getSequenceNumber/{entityName}")
    public ResponseEntity getClassReadingHistoryData(@PathVariable String entityName) {
        log.debug("Get sequence number by entity name-----");
        GetSequenceNumberResponse response = new GetSequenceNumberResponse();
        try {
            response = getSequenceNumberService.execute(entityName);
        } catch (Exception e) {
            log.error("Error in fetching Class Reading History Chart Data :" + e.getMessage());
        }
        if (response.SUCCESSFULL)
            return ResponseEntity.ok().header(response.getMessage()).body(response);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(response.getErrorMessage()).body(response);
    }
}
