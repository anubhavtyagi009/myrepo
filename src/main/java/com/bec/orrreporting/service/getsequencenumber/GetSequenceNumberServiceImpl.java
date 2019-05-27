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
package com.bec.orrreporting.service.getsequencenumber;


import com.bec.orrreporting.domain.EntityIdsListEntity;
import com.bec.orrreporting.repository.EntityIdsListEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSequenceNumberServiceImpl implements GetSequenceNumberService {
    private final static Logger log = LoggerFactory.getLogger(GetSequenceNumberServiceImpl.class);

    @Autowired
    EntityIdsListEntityRepository entityIdsListEntityRepository;

    @Override
    public GetSequenceNumberResponse execute(String entityName) throws Exception {
        log.debug("Started service to get sequence number ");
        GetSequenceNumberResponse response = null;
        try {
            EntityIdsListEntity entityIdsListEntity = entityIdsListEntityRepository.findByEntityName(entityName);
            if (entityIdsListEntity == null) {
                throw new Exception("Entity name does not exist ");
            }
            Long currentId = entityIdsListEntity.getCurrentId();
            currentId = currentId + 1;
            entityIdsListEntity.setCurrentId(currentId);
            entityIdsListEntityRepository.saveAndFlush(entityIdsListEntity);

            //create response
            response = new GetSequenceNumberResponse();
            response.setEntityName(entityName);
            response.setCount(currentId);
            response.SUCCESSFULL = true;
            response.setMessage("Successfully generated the count based on entity name");
        } catch (Exception e) {
            log.error("Failed to get sequence number :" + e.getMessage());
            response = new GetSequenceNumberResponse();
            response.SUCCESSFULL = false;
            response.setErrorCode(500);
            response.setErrorMessage("Failed to generate sequence number: " + e.getMessage());
        }
        return response;
    }
}
