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

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AtlantisApolloController {
    private final static Logger log = LoggerFactory.getLogger(AtlantisApolloController.class);

    // get student details by student id
    @GetMapping(value = "/getStudentDetails/{studentId}")
    public ResponseEntity getStudentDetailsbyStudentId(@PathVariable Integer studentId) {
        log.debug("Get student details by studentId-----");
        return null;
    }

    // get student starting reading level
    @GetMapping(value = "/getStudentStartingReadingLevel/{studentId}")
    public String getStudentReadingLevelbyStudentId(@PathVariable Integer studentId) {
        log.debug("Get getStudentStartingReadingLevel by studentId-----");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("startingLevel", "Pre-A");
        } catch (Exception e) {
            log.error("Error in fetching getStudentStartingReadingLevel details :" + e.getMessage());
        }
        return jsonObject.toString();
    }

    // get student target reading level by studentid
    @GetMapping(value = "/getStudentTargetReadingLevel/{studentId}")
    public String getStudentTargetLevelbyStudentId(@PathVariable Integer studentId) {
        log.debug("Get getStudentTargetReadingLevel by studentId-----");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("readingTarget", "E");
        } catch (Exception e) {
            log.error("Error in fetching getStudentTargetReadingLevel details :" + e.getMessage());
        }
        return jsonObject.toString();
    }
}
