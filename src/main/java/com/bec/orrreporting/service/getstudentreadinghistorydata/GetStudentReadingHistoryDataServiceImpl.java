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
package com.bec.orrreporting.service.getstudentreadinghistorydata;

import com.bec.orrreporting.domain.DimAssessmentTestEntity;
import com.bec.orrreporting.domain.DimAssignmentCreatorEntity;
import com.bec.orrreporting.domain.DimStudentEntity;
import com.bec.orrreporting.domain.FactOrrAssignmentNoAggEntity;
import com.bec.orrreporting.dto.StudentReadingHistoryDataDTO;
import com.bec.orrreporting.dto.StudentReadingLevelDTO;
import com.bec.orrreporting.repository.DimAssignmentCreatorEntityRepository;
import com.bec.orrreporting.repository.DimStudentEntityRepository;
import com.bec.orrreporting.repository.FactOrrAssignmentNoAggEntityRepository;
import com.bec.orrreporting.service.servicegateway.ServiceGateway;
import com.bec.orrreporting.service.utility.ServiceConstants;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class GetStudentReadingHistoryDataServiceImpl implements GetStudentReadingHistoryDataService {
    private final Logger log = LoggerFactory.getLogger(GetStudentReadingHistoryDataServiceImpl.class);

    @Autowired
    FactOrrAssignmentNoAggEntityRepository factOrrAssignmentNoAggEntityRepository;

    @Autowired
    DimAssignmentCreatorEntityRepository dimAssignmentCreatorEntityRepository;

    @Autowired
    DimStudentEntityRepository dimStudentEntityRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ServiceGateway serviceGateway;

    @Override
    public GetStudentReadingHistoryDataResponse execute(GetStudentReadingHistoryDataRequest request) throws Exception {
        log.debug("Started to get student level reading history data service-----");
        GetStudentReadingHistoryDataResponse response = null;
        List<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTOPage = null;
        StudentReadingLevelDTO studentReadingLevel = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("mm/dd/yy");
        try {
            //validate request
            validateRequest(request);
            //dynamic query to fetch data
            List<FactOrrAssignmentNoAggEntity> studentReadingHistoryEntityList = createDynamicQueryForStudentLevelReadingHistory(request);
            //function to set values for student level reading history data
            studentReadingHistoryDataDTOPage = setValuesForStudentLevelReadingHistoryData(studentReadingHistoryEntityList);
            //function to set starting level and reading target of an student
            studentReadingLevel = setStartingLevelandReadingTargetForStudent(request.getFilters().getExternalFilter().getStudentId());
            //create response
            response = new GetStudentReadingHistoryDataResponse(studentReadingHistoryDataDTOPage, studentReadingLevel);
            response.SUCCESSFULL = true;
            response.setMessage("Successfull in reading student level history chart data");
            return response;
        } catch (Exception e) {
            log.error("Failed to get student level reading history data " + e.getMessage());
            response = new GetStudentReadingHistoryDataResponse();
            response.SUCCESSFULL = false;
            response.setErrorCode(500);
            response.setErrorMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    private StudentReadingLevelDTO setStartingLevelandReadingTargetForStudent(Integer studentId) throws Exception {
        log.debug("Function call started to set values for student starting level and reading target ---");
        StudentReadingLevelDTO studentReadingLevelDTO = new StudentReadingLevelDTO();
        try {
            JSONObject startingLevel = serviceGateway.getStudentStartingLevelById(studentId);
            JSONObject readingTarget = serviceGateway.getStudentTargetReadingLevel(studentId);
            studentReadingLevelDTO.setStartingLevel(startingLevel.getString("letterLevel"));
            studentReadingLevelDTO.setReadingTarget(readingTarget.getString("letterLevel"));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return studentReadingLevelDTO;
    }

    private List<FactOrrAssignmentNoAggEntity> createDynamicQueryForStudentLevelReadingHistory(GetStudentReadingHistoryDataRequest request) throws Exception {
        List<FactOrrAssignmentNoAggEntity> resultListOfFactOrrAssignmentNoAggEntity = null;
        TypedQuery<FactOrrAssignmentNoAggEntity> typedQuery = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("mm/dd/yy");
        List<String> profiencyListOfString = new ArrayList<>();
        List<String> readTypeListOfString = new ArrayList<>();
        List<String> languageListOfString = new ArrayList<>();
        List<String> categoryListOfString = new ArrayList<>();
        if (request.getFilters().getInternalFilter().getProficiency().isIndependent()) {
            profiencyListOfString.add(ServiceConstants.PROFICIENCY_INDEPENDENT);
        }
        if (request.getFilters().getInternalFilter().getProficiency().isInstructional()) {
            profiencyListOfString.add(ServiceConstants.PROFICIENCY_INSTRUCTIONAL);
        }
        if (request.getFilters().getInternalFilter().getProficiency().isFrustrational()) {
            profiencyListOfString.add(ServiceConstants.PROFICIENCY_FRUSTRATIONAL);
        }
        if (request.getFilters().getInternalFilter().getType().isSeen()) {
            readTypeListOfString.add(ServiceConstants.READTYPE_SEEN);
        }
        if (request.getFilters().getInternalFilter().getType().isUnseen()) {
            readTypeListOfString.add(ServiceConstants.READTYPE_UNSEEN);
        }
        if (request.getFilters().getInternalFilter().getLanguage().isSpanish()) {
            languageListOfString.add(ServiceConstants.LANGUAGE_SPANISH);
        }
        if (request.getFilters().getInternalFilter().getLanguage().isEnglish()) {
            languageListOfString.add(ServiceConstants.LANGUAGE_ENGLISH);
        }
        if (request.getFilters().getInternalFilter().getCategory().isFiction()) {
            categoryListOfString.add(ServiceConstants.CATEGORY_FICTION);
        }
        if (request.getFilters().getInternalFilter().getCategory().isNonfiction()) {
            categoryListOfString.add(ServiceConstants.CATEGORY_NONFICTION);
        }
        if (profiencyListOfString.isEmpty()) {
            profiencyListOfString = null;
        } else if (readTypeListOfString.isEmpty()) {
            readTypeListOfString = null;
        } else if (languageListOfString.isEmpty()) {
            languageListOfString = null;
        } else if (categoryListOfString.isEmpty()) {
            categoryListOfString = null;
        }
        //dynamic query creation
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<FactOrrAssignmentNoAggEntity> criteriaQuery = criteriaBuilder.createQuery(FactOrrAssignmentNoAggEntity.class);
            Root<FactOrrAssignmentNoAggEntity> factOrrAssignmentNoAggEntityRoot = criteriaQuery.from(FactOrrAssignmentNoAggEntity.class);
            Join<FactOrrAssignmentNoAggEntity, DimStudentEntity> joinStudentEntity =
                    factOrrAssignmentNoAggEntityRoot.join(ServiceConstants.JOIN_DimStudentEntity, JoinType.LEFT);
            Join<FactOrrAssignmentNoAggEntity, DimAssignmentCreatorEntity> joinAssignmentCreatorEntity =
                    factOrrAssignmentNoAggEntityRoot.join(ServiceConstants.JOIN_DimAssignmentCreatorEntity, JoinType.LEFT);
            Join<FactOrrAssignmentNoAggEntity, DimAssessmentTestEntity> joinAssessmentTestEntity =
                    factOrrAssignmentNoAggEntityRoot.join(ServiceConstants.JOIN_DimAssessmentTestEntity, JoinType.LEFT);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.equal(joinStudentEntity.get(ServiceConstants.DimStudentEntity_STUDENTID), request.getFilters().getExternalFilter().getStudentId()),
                    criteriaBuilder.equal(joinStudentEntity.get(ServiceConstants.DimStudentEntity_GRADE), request.getFilters().getExternalFilter().getStudentGrade()),
                    criteriaBuilder.equal(joinAssignmentCreatorEntity.get(ServiceConstants.DimAssignmentCreatorEntity_TeacherId), request.getFilters().getExternalFilter().getTeacherId()),
                    criteriaBuilder.greaterThanOrEqualTo(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_AssignmentCompletionDate), dateFormatter.parse(request.getFilters().getExternalFilter().getStartDate())),
                    criteriaBuilder.lessThanOrEqualTo(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_AssignmentCompletionDate), dateFormatter.parse(request.getFilters().getExternalFilter().getEndDate())),
                    criteriaBuilder.upper(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_Proficiency)).in(profiencyListOfString),
                    criteriaBuilder.upper(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_ReadType)).in(readTypeListOfString),
                    criteriaBuilder.upper(joinAssessmentTestEntity.get(ServiceConstants.DimAssessmentTestEntity_Language)).in(languageListOfString),
                    criteriaBuilder.upper(joinAssessmentTestEntity.get(ServiceConstants.DimAssessmentTestEntity_Category)).in(categoryListOfString)),
                    criteriaBuilder.isNotNull(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_AssignmentCompletionDate)),
                    criteriaBuilder.isNotNull(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_ReadingLevel)),
                    criteriaBuilder.isNotNull(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_Proficiency)),
                    criteriaBuilder.equal(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_IsLatest), 1),
                    criteriaBuilder.equal(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_DeleteIndicator), 0));
            criteriaQuery.orderBy(criteriaBuilder.desc(factOrrAssignmentNoAggEntityRoot.get(ServiceConstants.FactOrrAssignmentNoAggEntity_AssignmentCompletionDate)));

            typedQuery = entityManager.createQuery(criteriaQuery);
            resultListOfFactOrrAssignmentNoAggEntity = typedQuery.getResultList();
        } catch (ParseException e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return resultListOfFactOrrAssignmentNoAggEntity;
    }

    //validate mandatory user inputs
    private void validateRequest(GetStudentReadingHistoryDataRequest request) throws Exception {
        try {
            validateMandatoryFields(request);
            validateDimensionValuesExists(request);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void validateDimensionValuesExists(GetStudentReadingHistoryDataRequest request) throws Exception {
        Long studentId = dimStudentEntityRepository.findByStudentId(request.getFilters().getExternalFilter().getStudentId());
        if (studentId == null) {
            throw new Exception("Student Id does not exist :");
        }
        Long teacherId = dimAssignmentCreatorEntityRepository.findByTeacherId(request.getFilters().getExternalFilter().getTeacherId());
        if (teacherId == null) {
            throw new Exception("Teacher Id does not exist :");
        }
    }

    private void validateMandatoryFields(GetStudentReadingHistoryDataRequest request) throws Exception {
        //check user input fields contains value
        if ((request.getFilters().getExternalFilter().getStartDate() == null || request.getFilters().getExternalFilter().getStartDate().isEmpty())
                || (request.getFilters().getExternalFilter().getEndDate() == null || request.getFilters().getExternalFilter().getEndDate().isEmpty())
                || (request.getFilters().getExternalFilter().getStudentId() == null)
                || (request.getFilters().getExternalFilter().getTeacherId() == null)
                || (request.getFilters().getExternalFilter().getStudentGrade() == null || request.getFilters().getExternalFilter().getStudentGrade().isEmpty())) {
            throw new Exception("Mandatory fields should not be null or empty");
        }
    }

    private List<StudentReadingHistoryDataDTO> setValuesForStudentLevelReadingHistoryData(List<FactOrrAssignmentNoAggEntity> studentReadingHistoryEntityList) throws Exception {
        log.debug("Function call started to set values for student level reading history data---");
        List<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTOS = new ArrayList<>();
        try {
            for (FactOrrAssignmentNoAggEntity fact : studentReadingHistoryEntityList) {
                StudentReadingHistoryDataDTO studentReadingHistoryDataDTO = new StudentReadingHistoryDataDTO();
                studentReadingHistoryDataDTO.setStudentId(fact.getDimStudentByDimStudentId().getStudentId());
                studentReadingHistoryDataDTO.setLetterLevel(fact.getDimReadingLevelsByDimReadingLevelId().getLeterLevel() + "/" + fact.getDimReadingLevelsByDimReadingLevelId().getNumberLevel());
                studentReadingHistoryDataDTO.setLastPassage(fact.getDimAssessmentTestByDimAssessmentTestId().getComponentTitle());
                studentReadingHistoryDataDTO.setCategory(fact.getDimAssessmentTestByDimAssessmentTestId().getCategory());
                studentReadingHistoryDataDTO.setAccuracy(fact.getAccuracy());
                studentReadingHistoryDataDTO.setProficiency(fact.getProficiency());
                studentReadingHistoryDataDTO.setFluency(fact.getFluency());
                studentReadingHistoryDataDTO.setAssignmentDate(fact.getAssignmentCompletionDate());
                studentReadingHistoryDataDTO.setNotes(fact.getNotes());
                studentReadingHistoryDataDTOS.add(studentReadingHistoryDataDTO);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return studentReadingHistoryDataDTOS;
    }
}
