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
package com.bec.orrreporting.service.servicegateway;

import com.bec.orrreporting.config.BenchmarkProperties;
import com.bec.orrreporting.config.RestTemplateConfig;
import com.bec.orrreporting.repository.EntityIdsListEntityRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ServiceGatewayImpl implements ServiceGateway {

    private final Logger log = LoggerFactory.getLogger(ServiceGatewayImpl.class);


    @Autowired
    RestTemplateConfig restTemplateConfig;

    @Autowired
    BenchmarkProperties benchmarkProperties;

    @Autowired
    EntityIdsListEntityRepository entityIdsListEntityRepository;

    @Override
    public JSONObject getStudentDetailsById(Long studentId) {
        ResponseEntity<String> responseBody = null;
        JSONObject jsonObject = null;
        try {
            String studentServiceUrl = benchmarkProperties.getMicroservicesReferences().getApolloAtlantisService() +
                    "/api/v1/getStudentDetails?studentId=" + studentId;
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            //calling and getting response
            responseBody = restTemplateConfig.restTemplate().getForEntity(studentServiceUrl, String.class);
            log.debug("getStudentDetailsByStudentId .");
        } catch (Exception e) {
            log.error("ServiceGatewayImpl ==>Error==>getStudentDetailsByStudentId failed: " + e.getMessage());
        }
        try {
            //extracting responseBody
            jsonObject = new JSONObject(responseBody.getBody());
        } catch (JSONException e) {
            log.error("ServiceGatewayImpl ==>Error==>getStudentDetailsByStudentId failed: " + e.getMessage());
        }
        return jsonObject;
    }

    @Override
    public JSONObject getStudentStartingLevelById(Integer studentId) {
        ResponseEntity<String> responseBody = null;
        JSONObject jsonObject = null;
        try {
            String studentServiceUrl = benchmarkProperties.getMicroservicesReferences().getApolloAtlantisService() +
                    "/api/v1/getStudentStartingReadingLevel/" + studentId;
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            //calling and getting response
            responseBody = restTemplateConfig.restTemplate().getForEntity(studentServiceUrl, String.class);
            log.debug("getStudentStartingLevelById .");
        } catch (Exception e) {
            log.error("ServiceGatewayImpl ==>Error==>getStudentStartingLevelById failed: " + e.getMessage());
        }
        try {
            //extracting responseBody
            jsonObject = new JSONObject(responseBody.getBody());
        } catch (JSONException e) {
            log.error("ServiceGatewayImpl ==>Error==>getStudentStartingLevelById failed: " + e.getMessage());
        }
        return jsonObject;
    }

    @Override
    public JSONObject getStudentTargetReadingLevel(Integer studentId) {
        ResponseEntity<String> responseBody = null;
        JSONObject jsonObject = null;
        try {
            String studentServiceUrl = benchmarkProperties.getMicroservicesReferences().getApolloAtlantisService() +
                    "/api/v1/getStudentTargetReadingLevel/" + studentId;
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            //calling and getting response
            responseBody = restTemplateConfig.restTemplate().getForEntity(studentServiceUrl, String.class);
            log.debug("getStudentTargetReadingLevel .");
        } catch (Exception e) {
            log.error("ServiceGatewayImpl ==>Error==>getStudentTargetReadingLevel failed: " + e.getMessage());
        }
        try {
            //extracting responseBody
            jsonObject = new JSONObject(responseBody.getBody());
        } catch (JSONException e) {
            log.error("ServiceGatewayImpl ==>Error==>getStudentTargetReadingLevel failed: " + e.getMessage());
        }
        return jsonObject;
    }

}