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
package com.bec.orrreporting.service.getclassreadinghistorydata;

import com.bec.orrreporting.domain.DimAssessmentTestEntity;
import com.bec.orrreporting.domain.DimClassEntity;
import com.bec.orrreporting.domain.FactOrrAssignmentNoAggEntity;
import com.bec.orrreporting.dto.ClassReadingHistoryDataDTO;
import com.bec.orrreporting.repository.DimClassEntityRepository;
import com.bec.orrreporting.repository.FactOrrAssignmentNoAggEntityRepository;
import com.bec.orrreporting.service.utility.ServiceConstants;
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
public class GetClassReadingHistoryDataServiceImpl implements GetClassReadingHistoryDataService {
    private final Logger log = LoggerFactory.getLogger(GetClassReadingHistoryDataServiceImpl.class);

    @Autowired
    FactOrrAssignmentNoAggEntityRepository factOrrAssignmentNoAggEntityRepository;

    @Autowired
    DimClassEntityRepository dimClassEntityRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public GetClassReadingHistoryDataResponse execute(GetClassReadingHistoryDataRequest request) throws Exception {
        log.debug("Started to get class level reading history data service-----" + request);
        GetClassReadingHistoryDataResponse response;
        List<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOList = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("mm/dd/yy");
        try {
            //validate request
            validateRequest(request);
            //dynamic query to fetch data
            List<FactOrrAssignmentNoAggEntity> classReadingHistoryEntityList = createDynamicQueryForClassLevelReadingHistory(request);
            //function to set values for class level reading history data
            classReadingHistoryDataDTOList = setValuesForClassLevelReadingHistoryData(classReadingHistoryEntityList);
            //create response
            response = new GetClassReadingHistoryDataResponse(classReadingHistoryDataDTOList);
            response.SUCCESSFULL = true;
            response.setMessage("Successfull in reading class level history chart data");
            return response;
        } catch (Exception e) {
            log.error("Failed to get class level reading history data :" + e.getMessage());
            response = new GetClassReadingHistoryDataResponse();
            response.SUCCESSFULL = false;
            response.setErrorCode(500);
            response.setErrorMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    private List<FactOrrAssignmentNoAggEntity> createDynamicQueryForClassLevelReadingHistory(GetClassReadingHistoryDataRequest request) throws Exception {
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
            factOrrAssignmentNoAggEntityRoot.join(ServiceConstants.JOIN_DimAssignmentCreatorEntity, JoinType.LEFT);
            Join<FactOrrAssignmentNoAggEntity, DimAssessmentTestEntity> joinAssessmentTestEntity =
                    factOrrAssignmentNoAggEntityRoot.join(ServiceConstants.JOIN_DimAssessmentTestEntity, JoinType.LEFT);
            Join<FactOrrAssignmentNoAggEntity, DimClassEntity> joinClassEntity =
                    factOrrAssignmentNoAggEntityRoot.join(ServiceConstants.JOIN_DimClassEntity, JoinType.LEFT);

            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.equal(joinClassEntity.get(ServiceConstants.DimStudentEntity_classId), request.getFilters().getExternalFilter().getClassId()),
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
            criteriaQuery.orderBy(criteriaBuilder.desc(factOrrAssignmentNoAggEntityRoot
                    .get(ServiceConstants.FactOrrAssignmentNoAggEntity_AssignmentCompletionDate)));

            typedQuery = entityManager.createQuery(criteriaQuery);
            resultListOfFactOrrAssignmentNoAggEntity = typedQuery.getResultList();
        } catch (ParseException e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return resultListOfFactOrrAssignmentNoAggEntity;
    }

    private void validateRequest(GetClassReadingHistoryDataRequest request) throws Exception {
        validateMandatoryFields(request);
        validateDimensionValuesExists(request);
    }

    private void validateDimensionValuesExists(GetClassReadingHistoryDataRequest request) throws Exception {
        Long classId = dimClassEntityRepository.findByClassId(request.getFilters().getExternalFilter().getClassId());
        if (classId == null) {
            throw new Exception("Class Id does not exist :");
        }
    }

    private void validateMandatoryFields(GetClassReadingHistoryDataRequest request) throws Exception {
        if ((request.getFilters().getExternalFilter().getStartDate() == null || request.getFilters().getExternalFilter().getStartDate().isEmpty())
                || (request.getFilters().getExternalFilter().getEndDate() == null || request.getFilters().getExternalFilter().getEndDate().isEmpty())
                || (request.getFilters().getExternalFilter().getClassId() == null)) {
            throw new Exception("Mandatory fields should not be null or empty");
        }
    }

    private List<ClassReadingHistoryDataDTO> setValuesForClassLevelReadingHistoryData(List<FactOrrAssignmentNoAggEntity> classReadingHistoryEntityList) throws Exception {
        log.debug("Function call started to set values for class level reading history data---");
        List<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOS = new ArrayList<>();
        try {
            for (FactOrrAssignmentNoAggEntity fact : classReadingHistoryEntityList) {
                ClassReadingHistoryDataDTO classReadingHistoryDataDTO = new ClassReadingHistoryDataDTO();
                classReadingHistoryDataDTO.setStudentId(fact.getDimStudentByDimStudentId().getStudentId());
                classReadingHistoryDataDTO.setLetterLevel(fact.getDimReadingLevelsByDimReadingLevelId().getLeterLevel() + "/" + fact.getDimReadingLevelsByDimReadingLevelId().getNumberLevel());
                classReadingHistoryDataDTO.setLastPassage(fact.getDimAssessmentTestByDimAssessmentTestId().getComponentTitle());
                classReadingHistoryDataDTO.setCategory(fact.getDimAssessmentTestByDimAssessmentTestId().getCategory());
                classReadingHistoryDataDTO.setAccuracy(fact.getAccuracy());
                classReadingHistoryDataDTO.setProficiency(fact.getProficiency());
                classReadingHistoryDataDTO.setFluency(fact.getFluency());
                classReadingHistoryDataDTO.setAssignmentDate(fact.getAssignmentCompletionDate());
                classReadingHistoryDataDTO.setNotes(fact.getNotes());
                classReadingHistoryDataDTOS.add(classReadingHistoryDataDTO);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return classReadingHistoryDataDTOS;
    }
}
