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
package com.bec.orrreporting.service.getdimensioninsertionkey;

import com.bec.orrreporting.domain.*;
import com.bec.orrreporting.repository.*;
import com.bec.orrreporting.service.getsequencenumber.GetSequenceNumberResponse;
import com.bec.orrreporting.service.getsequencenumber.GetSequenceNumberService;
import com.bec.orrreporting.service.utility.CommonFunctions;
import com.bec.orrreporting.service.utility.ServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class GetDimensionInsertionKeyServiceImpl implements GetDimensionInsertionKeyService {
    private final static Logger log = LoggerFactory.getLogger(GetDimensionInsertionKeyServiceImpl.class);

    @Autowired
    GetSequenceNumberService getSequenceNumberService;

    @Autowired
    DimStudentEntityRepository dimStudentEntityRepository;

    @Autowired
    DimClassEntityRepository dimClassEntityRepository;

    @Autowired
    DimSchoolEntityRepository dimSchoolEntityRepository;

    @Autowired
    DimAssignmentCreatorEntityRepository dimAssignmentCreatorEntityRepository;

    @Autowired
    DimDistrictEntityRepository dimDistrictEntityRepository;

    @Override
    public GetDimensionInsertionKeyResponse execute(GetDimensionInsertionKeyRequest request) throws Exception {
        log.debug("Started service to get student dimension insertion key ");
        //function to validate request
        GetDimensionInsertionKeyResponse response = new GetDimensionInsertionKeyResponse();
        Long keyValue = null;
        try {
            validateRequest(request);
            for (int i = 0; i < ServiceConstants.DIM_TABLES.length; i++) {
                if (ServiceConstants.DIM_TABLES[i].equals("DIM_STUDENT")) {
                    keyValue = setStudentDimensionData(ServiceConstants.DIM_TABLES[i], request.getStudentId());
                    response.setStudentKey(keyValue);
                } else if (ServiceConstants.DIM_TABLES[i].equals("DIM_CLASS")) {
                    keyValue = setClassDimensionData(ServiceConstants.DIM_TABLES[i], request.getClassId());
                    response.setClassKey(keyValue);
                } else if (ServiceConstants.DIM_TABLES[i].equals("DIM_SCHOOL")) {
                    keyValue = setSchoolDimensionData(ServiceConstants.DIM_TABLES[i], request.getSchoolId());
                    response.setSchoolKey(keyValue);
                } else if (ServiceConstants.DIM_TABLES[i].equals("DIM_DISTRICT")) {
                    keyValue = setDistrictDimensionData(ServiceConstants.DIM_TABLES[i], request.getDistrictId());
                    response.setDistrictKey(keyValue);
                } else if (ServiceConstants.DIM_TABLES[i].equals("DIM_ASSIGNMENT_CREATOR")) {
                    keyValue = setTeacherDimensionData(ServiceConstants.DIM_TABLES[i], request.getTeacherId());
                    response.setTeacherKey(keyValue);
                }
            }

        } catch (Exception e) {
            log.error("Failed to Insert dimension data " + e.getMessage());
            response.SUCCESSFULL = false;
            response.setErrorCode(500);
            response.setErrorMessage("Error in Fetching Data : " + e.getMessage());
        }
        return response;
    }

    //validate input request
    private void validateRequest(GetDimensionInsertionKeyRequest request) throws Exception {
        try {
            validateMandatoryFields(request);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void validateMandatoryFields(GetDimensionInsertionKeyRequest request) throws Exception {
        if ((request.getClassId() == null || (request.getClassId() == 0))
                || (request.getDistrictId() == null || (request.getDistrictId() == 0))
                || (request.getSchoolId() == null || (request.getSchoolId() == 0))
                || (request.getTeacherId() == null || (request.getTeacherId() == 0))
                || (request.getStudentId() == null || (request.getStudentId() == 0))) {
            throw new Exception("Mandatory fields should not be null or empty");
        }
    }

    private Long setTeacherDimensionData(String entityName, Long teacherId) throws Exception {
        log.debug("Function call started to insert teacher dimension data---");
        GetSequenceNumberResponse getSequenceNumberResponse = null;
        String currentDate = CommonFunctions.getCurrentDate();
        DimAssignmentCreatorEntity dimAssignmentCreatorEntity = dimAssignmentCreatorEntityRepository.findByAssignmentCreatorId(teacherId);
        try {
            if (dimAssignmentCreatorEntity == null) {
                dimAssignmentCreatorEntity = new DimAssignmentCreatorEntity();
                getSequenceNumberResponse = getSequenceNumberService.execute(entityName);
                dimAssignmentCreatorEntity.setSourceAssignmentCreatorId(teacherId);
                dimAssignmentCreatorEntity.setDimAssignmentCreatorId(getSequenceNumberResponse.getCount());
            }
            dimAssignmentCreatorEntity.setSourceSystem("Teacher123");
            dimAssignmentCreatorEntity.setRecordCreatedDatetime(Timestamp.valueOf(currentDate));
            dimAssignmentCreatorEntity.setRecordModifiedDatetime(Timestamp.valueOf(currentDate));
            dimAssignmentCreatorEntity = dimAssignmentCreatorEntityRepository.save(dimAssignmentCreatorEntity);
            return dimAssignmentCreatorEntity.getDimAssignmentCreatorId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private Long setDistrictDimensionData(String entityName, Integer districtId) throws Exception {
        log.debug("Function call started to insert district dimension data---");
        GetSequenceNumberResponse getSequenceNumberResponse = null;
        String currentDate = CommonFunctions.getCurrentDate();
        DimDistrictEntity dimDistrictEntity = dimDistrictEntityRepository.findBySourceDistrictId(districtId);
        try {
            if (dimDistrictEntity == null) {
                dimDistrictEntity = new DimDistrictEntity();
                getSequenceNumberResponse = getSequenceNumberService.execute(entityName);
                dimDistrictEntity.setDimDistrictId(getSequenceNumberResponse.getCount());
                dimDistrictEntity.setDistrictId(districtId);
            }
            dimDistrictEntity.setDistrictName("District123");
            dimDistrictEntity.setRecordCreatedDatetime(Timestamp.valueOf(currentDate));
            dimDistrictEntity.setRecordModifiedDatetime(Timestamp.valueOf(currentDate));
            dimDistrictEntity = dimDistrictEntityRepository.save(dimDistrictEntity);
            return dimDistrictEntity.getDimDistrictId();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Long setSchoolDimensionData(String entityName, Integer schoolId) throws Exception {
        log.debug("Function call started to insert school dimension data---");
        GetSequenceNumberResponse getSequenceNumberResponse = null;
        String currentDate = CommonFunctions.getCurrentDate();
        DimSchoolEntity dimSchoolEntity = dimSchoolEntityRepository.findBySourceSchoolId(schoolId);
        try {
            if (dimSchoolEntity == null) {
                dimSchoolEntity = new DimSchoolEntity();
                getSequenceNumberResponse = getSequenceNumberService.execute(entityName);
                dimSchoolEntity.setDimSchoolId(getSequenceNumberResponse.getCount());
                dimSchoolEntity.setSchoolId(schoolId);
            }
            dimSchoolEntity.setSchoolName("School123");
            dimSchoolEntity.setDimDistrictId(1);
            dimSchoolEntity.setRecordCreatedDatetime(Timestamp.valueOf(currentDate));
            dimSchoolEntity.setRecordModifiedDatetime(Timestamp.valueOf(currentDate));
            dimSchoolEntity = dimSchoolEntityRepository.save(dimSchoolEntity);
            return dimSchoolEntity.getDimSchoolId();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Long setClassDimensionData(String entityName, Integer classId) throws Exception {
        log.debug("Function call started to insert class dimension data---");
        GetSequenceNumberResponse getSequenceNumberResponse = null;
        String currentDate = CommonFunctions.getCurrentDate();
        DimClassEntity dimClassEntity = dimClassEntityRepository.findDetailsByClassId(classId);
        try {
            if (dimClassEntity == null) {
                dimClassEntity = new DimClassEntity();
                getSequenceNumberResponse = getSequenceNumberService.execute(entityName);
                dimClassEntity.setDimClassId(getSequenceNumberResponse.getCount());
                dimClassEntity.setClassId(classId);
            }
            dimClassEntity.setClassName("English Language Arts 123");
            dimClassEntity.setDimSchoolId(1);
            dimClassEntity.setRecordCreatedDatetime(Timestamp.valueOf(currentDate));
            dimClassEntity.setRecordModifiedDatetime(Timestamp.valueOf(currentDate));
            dimClassEntity = dimClassEntityRepository.save(dimClassEntity);
            return dimClassEntity.getDimClassId();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Long setStudentDimensionData(String entityName, Integer studentId) throws Exception {
        log.debug("Function call started to insert student dimension data---");
        GetSequenceNumberResponse getSequenceNumberResponse = null;
        String currentDate = CommonFunctions.getCurrentDate();
        DimStudentEntity dimStudentEntity = dimStudentEntityRepository.findDetailsByStudentId(studentId);
        try {
            if (dimStudentEntity == null) {
                dimStudentEntity = new DimStudentEntity();
                getSequenceNumberResponse = getSequenceNumberService.execute(entityName);
                dimStudentEntity.setDimStudentId(getSequenceNumberResponse.getCount());
                dimStudentEntity.setStudentId(studentId);
            }
            dimStudentEntity.setDeleteIndicator(0);
            dimStudentEntity.setGrade("6");
            dimStudentEntity.setProficiency("Instructional");
            dimStudentEntity.setReadingLetterLevel("NA");
            dimStudentEntity.setReadingLetterLevelId(0);
            dimStudentEntity.setRecordFlag("1");
            dimStudentEntity.setReadingNumberLevel("NA");
            dimStudentEntity.setReadingLetterLevelId(20);
            dimStudentEntity.setRecordCreatedDatetime(Timestamp.valueOf(currentDate));
            dimStudentEntity.setRecordModifiedDatetime(Timestamp.valueOf(currentDate));
            dimStudentEntity.setDimClassId(5);
            dimStudentEntity.setDimSchoolId(1);
            dimStudentEntity.setDimDistrictId(1);
            dimStudentEntity = dimStudentEntityRepository.save(dimStudentEntity);
            return dimStudentEntity.getDimStudentId();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
