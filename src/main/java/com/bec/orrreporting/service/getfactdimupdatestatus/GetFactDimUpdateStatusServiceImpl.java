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
package com.bec.orrreporting.service.getfactdimupdatestatus;

import com.bec.orrreporting.domain.FactOrrAssignmentNoAggEntity;
import com.bec.orrreporting.repository.FactOrrAssignmentNoAggEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetFactDimUpdateStatusServiceImpl implements GetFactDimUpdateStatusService {
    private final static Logger log = LoggerFactory.getLogger(GetFactDimUpdateStatusServiceImpl.class);

    @Autowired
    FactOrrAssignmentNoAggEntityRepository factOrrAssignmentNoAggEntityRepository;

    @Override
    public GetFactDimUpdateStatusResponse execute(Long assignmentId) throws Exception {
        log.debug("Started service to get fact dimension update status ");
        GetFactDimUpdateStatusResponse response = null;
        List<Long> orrAssignmentList = new ArrayList<>();
        try {

            List<FactOrrAssignmentNoAggEntity> factOrrAssignmentNoAggEntityList = factOrrAssignmentNoAggEntityRepository.getOrrAssignmentRecordsByAssignmentId(assignmentId);
            if ((!factOrrAssignmentNoAggEntityList.isEmpty()) || (factOrrAssignmentNoAggEntityList != null)) {
                for (FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity : factOrrAssignmentNoAggEntityList) {
                    orrAssignmentList.add(factOrrAssignmentNoAggEntity.getOrrAssignmentId());
                }
                if (orrAssignmentList.isEmpty()) {
                    response = new GetFactDimUpdateStatusResponse();
                    response.SUCCESSFULL = true;
                    response.setMessage("No Matching records in fact table");
                    response.setUpdateStatus(true);

                } else {
                    Integer updateStatus = factOrrAssignmentNoAggEntityRepository.updateFactOrrAssignmentNoAggEntity(orrAssignmentList);
                    if (updateStatus != null) {
                        response = new GetFactDimUpdateStatusResponse();
                        response.SUCCESSFULL = true;
                        response.setMessage("Successfully updated the status in fact");
                        response.setUpdateStatus(true);
                    }
                }
            }
        } catch (Exception e) {
            log.error("Failed to update status :" + e.getMessage());
            response = new GetFactDimUpdateStatusResponse();
            response.SUCCESSFULL = false;
            response.setErrorCode(500);
            response.setErrorMessage("Failed to update status: " + e.getMessage());
        }
        return response;
    }
}
