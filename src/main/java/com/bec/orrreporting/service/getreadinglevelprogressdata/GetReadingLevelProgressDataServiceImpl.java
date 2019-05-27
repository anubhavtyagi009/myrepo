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
package com.bec.orrreporting.service.getreadinglevelprogressdata;

import com.bec.orrreporting.domain.DimAssessmentTestEntity;
import com.bec.orrreporting.domain.DimAssignmentCreatorEntity;
import com.bec.orrreporting.domain.DimStudentEntity;
import com.bec.orrreporting.domain.FactOrrAssignmentNoAggEntity;
import com.bec.orrreporting.dto.*;
import com.bec.orrreporting.repository.DimAssessmentTestEntityRepository;
import com.bec.orrreporting.repository.DimAssignmentCreatorEntityRepository;
import com.bec.orrreporting.repository.DimStudentEntityRepository;
import com.bec.orrreporting.repository.FactOrrAssignmentNoAggEntityRepository;
import com.bec.orrreporting.service.servicegateway.ServiceGateway;
import com.bec.orrreporting.service.utility.*;
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
import java.util.Collections;
import java.util.List;


@Service
public class GetReadingLevelProgressDataServiceImpl implements GetReadingLevelProgressDataService {
    private final Logger log = LoggerFactory.getLogger(GetReadingLevelProgressDataServiceImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    FactOrrAssignmentNoAggEntityRepository factOrrAssignmentNoAggEntityRepository;

    @Autowired
    DimAssessmentTestEntityRepository dimAssessmentTestEntityRepository;

    @Autowired
    DimAssignmentCreatorEntityRepository dimAssignmentCreatorEntityRepository;

    @Autowired
    DimStudentEntityRepository dimStudentEntityRepository;

    @Autowired
    ServiceGateway serviceGateway;

    @Override
    public GetReadingLevelProgressDataResponse execute(GetReadingLevelProgressDataRequest request) throws Exception {
        log.debug("calling readingLevelProgressData API execute function------");
        GetReadingLevelProgressDataResponse response = null;
        RplResponseDataDTO rplResponsedataDto = null;
        List<AssignmentDataResultDTO> assignmentDataResultDTOList = new ArrayList<>();
        List<DateRangeAxisDTO> dateRangeAxis = new ArrayList<>();
        List<ReadingLevelAxisDTO> readingLevelAxis = new ArrayList<>();
        List<FluencyDataDTO> fluencyResultList = new ArrayList<>();
        List<AccuracyDataDTO> accuracyResultList = new ArrayList<>();
        List<Integer> fluencyArray = new ArrayList<>();
        List<String> noOfLevels = new ArrayList<>();
        List<FluencyAxisDTO> fluencyAxisDTOList = new ArrayList<>();
        List<AccuracyAxisDTO> accuracyAxisDTOList = new ArrayList<>();
        StudentStartingLevelDTO studentStartingLevel = new StudentStartingLevelDTO();
        StudentReadingTargetDTO studentReadingTarget = new StudentReadingTargetDTO();
        try {
            //function to validate request
            validateRequest(request);
            //fetch data from query based on filters
            List<FactOrrAssignmentNoAggEntity> factOrrAssignmentNoAggEntityResultList = createDynamicQueryForReadingLevelProgress(request);
            if (!factOrrAssignmentNoAggEntityResultList.isEmpty()) {
                for (FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity : factOrrAssignmentNoAggEntityResultList) {
                    //function call to get assigments data
                    assignmentsData(factOrrAssignmentNoAggEntity, assignmentDataResultDTOList);
                    //function call to get date range axis
                    dateRangeAxisData(factOrrAssignmentNoAggEntity, dateRangeAxis);
                    //function call to get reading level axis
                    readingLevelAxisData(factOrrAssignmentNoAggEntity, readingLevelAxis);
                    //function call to get fluency data
                    fluencyData(factOrrAssignmentNoAggEntity, fluencyResultList);
                    //function call to get accuracy data
                    accuracyData(factOrrAssignmentNoAggEntity, accuracyResultList);
                    /*variables for deciding fluency axis values */
                    fluencyArray.add(factOrrAssignmentNoAggEntity.getFluency());
                    noOfLevels.add(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
                }
            }
            //add student starting level
            addStudentStartingLevel(studentStartingLevel, request.getFilters().getExternalFilter().getStudentId());
            // add student reading target
            addStudentReadingTarget(studentReadingTarget, request.getFilters().getExternalFilter().getStudentId());
            //function call to get fluency axis data
            fluencyAxisData(fluencyArray, noOfLevels, fluencyAxisDTOList);
            //function call to get accuracy axis data
            accuracyAxisData(accuracyAxisDTOList);
            //create response
            rplResponsedataDto = new RplResponseDataDTO(request.getFilters().getExternalFilter(), request.getFilters().getInternalFilter(), dateRangeAxis, readingLevelAxis,
                    assignmentDataResultDTOList, fluencyAxisDTOList, fluencyResultList, accuracyAxisDTOList, accuracyResultList, studentStartingLevel, studentReadingTarget);
            response = new GetReadingLevelProgressDataResponse(rplResponsedataDto);
            response.SUCCESSFULL = true;
            response.setMessage("Reading level progress chart data");
            return response;

        } catch (Exception e) {
            log.error(e.getMessage());
            response = new GetReadingLevelProgressDataResponse(null);
            response.SUCCESSFULL = false;
            response.setErrorCode(500);
            response.setErrorMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    private void addStudentReadingTarget(StudentReadingTargetDTO studentReadingTarget, Integer studentId) throws Exception {
        log.debug("Function call started to set values for student starting level---");
        try {
            JSONObject data = serviceGateway.getStudentTargetReadingLevel(studentId);
            studentReadingTarget.setReadingTarget(data.getString("readingTarget"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void addStudentStartingLevel(StudentStartingLevelDTO studentStartingLevel, Integer studentId) throws Exception {
        log.debug("Function call started to set values for student reading target---");
        try {
            JSONObject data = serviceGateway.getStudentStartingLevelById(studentId);
            studentStartingLevel.setStartingLevel(data.getString("startingLevel"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //validate input request
    private void validateRequest(GetReadingLevelProgressDataRequest request) throws Exception {
        try {
            validateMandatoryFields(request);
            validateRequestDataExistOrNot(request);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void validateRequestDataExistOrNot(GetReadingLevelProgressDataRequest request) throws Exception {
        Long assessmentId = dimAssessmentTestEntityRepository.findByAssessmentId(request.getFilters().getExternalFilter().getAssesmentId());
        if (assessmentId == null) {
            throw new Exception("Assessment Id does not exist :");
        }
        Long teacherId = dimAssignmentCreatorEntityRepository.findByTeacherId(request.getFilters().getExternalFilter().getTeacherId());
        if (teacherId == null) {
            throw new Exception("Teacher Id does not exist :");
        }
        Long studentId = dimStudentEntityRepository.findByStudentId(request.getFilters().getExternalFilter().getStudentId());
        if (studentId == null) {
            throw new Exception("Student Id does not exist :");
        }
    }

    private void validateMandatoryFields(GetReadingLevelProgressDataRequest request) throws Exception {
        if ((request.getFilters().getExternalFilter().getStartDate() == null || request.getFilters().getExternalFilter().getStartDate().isEmpty())
                || (request.getFilters().getExternalFilter().getEndDate() == null || request.getFilters().getExternalFilter().getEndDate().isEmpty())
                || (request.getFilters().getExternalFilter().getAssesmentId() == null)
                || (request.getFilters().getExternalFilter().getStudentId() == null)
                || (request.getFilters().getExternalFilter().getTeacherId() == null)
                || (request.getFilters().getExternalFilter().getStudentGrade() == null || request.getFilters().getExternalFilter().getStudentGrade().isEmpty())) {
            throw new Exception("Mandatory fields should not be null or empty");
        }
    }

    //create dynamic query
    private List<FactOrrAssignmentNoAggEntity> createDynamicQueryForReadingLevelProgress(GetReadingLevelProgressDataRequest request) throws Exception {
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
                    criteriaBuilder.equal(joinAssessmentTestEntity.get(ServiceConstants.DimAssessmentTestEntity_AssessmentTestId), request.getFilters().getExternalFilter().getAssesmentId()),
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

    //function to get accuracy axis data
    private void accuracyAxisData(List<AccuracyAxisDTO> accuracyAxisDTOList) throws Exception {
        log.debug("Get Accuracy Axis Data");
        try {
            for (int j = 10; j <= 100; j += 10) {
                AccuracyAxisDTO accuracyAxisDTO = new AccuracyAxisDTO();
                accuracyAxisDTO.setValue(j);
                accuracyAxisDTOList.add(accuracyAxisDTO);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //function to get fluency axis data
    private void fluencyAxisData(List<Integer> fluencyArray, List<String> noOfLevels, List<FluencyAxisDTO> fluencyAxisDTOList) throws Exception {
        log.debug("Get Fluency Axis Data");
        try {
            if (!fluencyArray.isEmpty() && !noOfLevels.isEmpty()) {
                int valuePerLevel = Collections.max(fluencyArray) / noOfLevels.size();
                for (int i = 1; i <= noOfLevels.size(); i++) {
                    FluencyAxisDTO fluencyAxisDTO = new FluencyAxisDTO();
                    int incrementLevel = valuePerLevel * i;
                    fluencyAxisDTO.setValue(incrementLevel);
                    fluencyAxisDTOList.add(fluencyAxisDTO);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //function to get accuracy data
    private void accuracyData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<AccuracyDataDTO> accuracyResultList) throws Exception {
        log.debug("Get Accuracy Axis Data");
        try {
            AccuracyDataDTO accuracyDataDTO = new AccuracyDataDTO();
            accuracyDataDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            accuracyDataDTO.setLetterLevel(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
            accuracyDataDTO.setAccuracy(factOrrAssignmentNoAggEntity.getAccuracy());
            accuracyDataDTO.setColour("#FFFFFF");
            accuracyDataDTO.setStartLevel(false);
            accuracyDataDTO.setTargetLevel(false);
            accuracyResultList.add(accuracyDataDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //function to get fluency data
    private void fluencyData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<FluencyDataDTO> fluencyResultList) throws Exception {
        log.debug("Get Fluency Graph Data");
        try {
            FluencyDataDTO fluencyDataDTO = new FluencyDataDTO();
            fluencyDataDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            fluencyDataDTO.setLetterLevel(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
            fluencyDataDTO.setFluency(factOrrAssignmentNoAggEntity.getFluency());
            fluencyDataDTO.setColour("#FFFFFF");
            fluencyDataDTO.setStartLevel(false);
            fluencyDataDTO.setTargetLevel(false);
            fluencyResultList.add(fluencyDataDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //function to get reading level axis data
    private void readingLevelAxisData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<ReadingLevelAxisDTO> readingLevelAxis) throws Exception {
        log.debug("Get Reading Level Axis Data");
        try {
            ReadingLevelAxisDTO readingLevelAxisResult = new ReadingLevelAxisDTO();
            readingLevelAxisResult.setLevelName(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
            String letterLevel = factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel();
            //get level axis color
            String levelAxisColor = getLevelAxisColor(letterLevel);
            //get level background color
            String levelBackGroundColor = getLevelBackGroundColor(letterLevel);
            //get level hover color
            String levelHoverColor = getLevelHoverColor(letterLevel);
            readingLevelAxisResult.setLevelAxisColor(levelAxisColor);
            readingLevelAxisResult.setLevelBgColor(levelBackGroundColor);
            readingLevelAxisResult.setLevelHoverColor(levelHoverColor);
            readingLevelAxis.add(readingLevelAxisResult);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private String getLevelHoverColor(String letterLevel) throws Exception {
        String levelHoverColor = null;
        try {
            switch (letterLevel) {
                case "PreA":
                    levelHoverColor = LevelHoverColor.PreA.getLevelHoverColor();
                    break;
                case "A":
                    levelHoverColor = LevelHoverColor.A.getLevelHoverColor();
                    break;
                case "B":
                    levelHoverColor = LevelHoverColor.B.getLevelHoverColor();
                    break;
                case "C":
                    levelHoverColor = LevelHoverColor.C.getLevelHoverColor();
                    break;
                case "D":
                    levelHoverColor = LevelHoverColor.D.getLevelHoverColor();
                    break;
                case "E":
                    levelHoverColor = LevelHoverColor.E.getLevelHoverColor();
                    break;
                case "F":
                    levelHoverColor = LevelHoverColor.F.getLevelHoverColor();
                    break;
                case "G":
                    levelHoverColor = LevelHoverColor.G.getLevelHoverColor();
                    break;
                case "H":
                    levelHoverColor = LevelHoverColor.H.getLevelHoverColor();
                    break;
                case "I":
                    levelHoverColor = LevelHoverColor.I.getLevelHoverColor();
                    break;
                case "J":
                    levelHoverColor = LevelHoverColor.J.getLevelHoverColor();
                    break;
                case "K":
                    levelHoverColor = LevelHoverColor.K.getLevelHoverColor();
                    break;
                case "L":
                    levelHoverColor = LevelHoverColor.L.getLevelHoverColor();
                    break;
                case "M":
                    levelHoverColor = LevelHoverColor.M.getLevelHoverColor();
                    break;
                case "N":
                    levelHoverColor = LevelHoverColor.N.getLevelHoverColor();
                    break;
                case "O":
                    levelHoverColor = LevelHoverColor.O.getLevelHoverColor();
                    break;
                case "P":
                    levelHoverColor = LevelHoverColor.P.getLevelHoverColor();
                    break;
                case "Q":
                    levelHoverColor = LevelHoverColor.Q.getLevelHoverColor();
                    break;
                case "R":
                    levelHoverColor = LevelHoverColor.R.getLevelHoverColor();
                    break;
                case "S":
                    levelHoverColor = LevelHoverColor.S.getLevelHoverColor();
                    break;
                case "T":
                    levelHoverColor = LevelHoverColor.T.getLevelHoverColor();
                    break;
                case "U":
                    levelHoverColor = LevelHoverColor.U.getLevelHoverColor();
                    break;
                case "V":
                    levelHoverColor = LevelHoverColor.V.getLevelHoverColor();
                    break;
                case "W":
                    levelHoverColor = LevelHoverColor.W.getLevelHoverColor();
                    break;
                case "X":
                    levelHoverColor = LevelHoverColor.X.getLevelHoverColor();
                    break;
                case "Y":
                    levelHoverColor = LevelHoverColor.Y.getLevelHoverColor();
                    break;
                case "Z":
                    levelHoverColor = LevelHoverColor.Z.getLevelHoverColor();
                    break;
                case "AA":
                    levelHoverColor = LevelHoverColor.AA.getLevelHoverColor();
                    break;
                case "ZZ":
                    levelHoverColor = LevelHoverColor.ZZ.getLevelHoverColor();
                    break;
                default:
                    levelHoverColor = "";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return levelHoverColor;
    }

    //Get level background color for letter level
    private String getLevelBackGroundColor(String letterLevel) throws Exception {
        String levelBackGroundColor = null;
        try {
            switch (letterLevel) {
                case "PreA":
                    levelBackGroundColor = LevelBackGroundColor.PreA.getLevelBackgroundColor();
                    break;
                case "A":
                    levelBackGroundColor = LevelBackGroundColor.A.getLevelBackgroundColor();
                    break;
                case "B":
                    levelBackGroundColor = LevelBackGroundColor.B.getLevelBackgroundColor();
                    break;
                case "C":
                    levelBackGroundColor = LevelBackGroundColor.C.getLevelBackgroundColor();
                    break;
                case "D":
                    levelBackGroundColor = LevelBackGroundColor.D.getLevelBackgroundColor();
                    break;
                case "E":
                    levelBackGroundColor = LevelBackGroundColor.E.getLevelBackgroundColor();
                    break;
                case "F":
                    levelBackGroundColor = LevelBackGroundColor.F.getLevelBackgroundColor();
                    break;
                case "G":
                    levelBackGroundColor = LevelBackGroundColor.G.getLevelBackgroundColor();
                    break;
                case "H":
                    levelBackGroundColor = LevelBackGroundColor.H.getLevelBackgroundColor();
                    break;
                case "I":
                    levelBackGroundColor = LevelBackGroundColor.I.getLevelBackgroundColor();
                    break;
                case "J":
                    levelBackGroundColor = LevelBackGroundColor.J.getLevelBackgroundColor();
                    break;
                case "K":
                    levelBackGroundColor = LevelBackGroundColor.K.getLevelBackgroundColor();
                    break;
                case "L":
                    levelBackGroundColor = LevelBackGroundColor.L.getLevelBackgroundColor();
                    break;
                case "M":
                    levelBackGroundColor = LevelBackGroundColor.M.getLevelBackgroundColor();
                    break;
                case "N":
                    levelBackGroundColor = LevelBackGroundColor.N.getLevelBackgroundColor();
                    break;
                case "O":
                    levelBackGroundColor = LevelBackGroundColor.O.getLevelBackgroundColor();
                    break;
                case "P":
                    levelBackGroundColor = LevelBackGroundColor.P.getLevelBackgroundColor();
                    break;
                case "Q":
                    levelBackGroundColor = LevelBackGroundColor.Q.getLevelBackgroundColor();
                    break;
                case "R":
                    levelBackGroundColor = LevelBackGroundColor.R.getLevelBackgroundColor();
                    break;
                case "S":
                    levelBackGroundColor = LevelBackGroundColor.S.getLevelBackgroundColor();
                    break;
                case "T":
                    levelBackGroundColor = LevelBackGroundColor.T.getLevelBackgroundColor();
                    break;
                case "U":
                    levelBackGroundColor = LevelBackGroundColor.U.getLevelBackgroundColor();
                    break;
                case "V":
                    levelBackGroundColor = LevelBackGroundColor.V.getLevelBackgroundColor();
                    break;
                case "W":
                    levelBackGroundColor = LevelBackGroundColor.W.getLevelBackgroundColor();
                    break;
                case "X":
                    levelBackGroundColor = LevelBackGroundColor.X.getLevelBackgroundColor();
                    break;
                case "Y":
                    levelBackGroundColor = LevelBackGroundColor.Y.getLevelBackgroundColor();
                    break;
                case "Z":
                    levelBackGroundColor = LevelBackGroundColor.Z.getLevelBackgroundColor();
                    break;
                case "AA":
                    levelBackGroundColor = LevelBackGroundColor.AA.getLevelBackgroundColor();
                    break;
                case "ZZ":
                    levelBackGroundColor = LevelBackGroundColor.ZZ.getLevelBackgroundColor();
                    break;
                default:
                    levelBackGroundColor = "";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return levelBackGroundColor;
    }

    //get level axis color for letter level
    private String getLevelAxisColor(String letterLevel) throws Exception {
        String levelAxisColor = null;
        try {
            switch (letterLevel) {
                case "PreA":
                    levelAxisColor = LevelAxisColor.PreA.getLevelAxisColor();
                    break;
                case "A":
                    levelAxisColor = LevelAxisColor.A.getLevelAxisColor();
                    break;
                case "B":
                    levelAxisColor = LevelAxisColor.B.getLevelAxisColor();
                    break;
                case "C":
                    levelAxisColor = LevelAxisColor.C.getLevelAxisColor();
                    break;
                case "D":
                    levelAxisColor = LevelAxisColor.D.getLevelAxisColor();
                    break;
                case "E":
                    levelAxisColor = LevelAxisColor.E.getLevelAxisColor();
                    break;
                case "F":
                    levelAxisColor = LevelAxisColor.F.getLevelAxisColor();
                    break;
                case "G":
                    levelAxisColor = LevelAxisColor.G.getLevelAxisColor();
                    break;
                case "H":
                    levelAxisColor = LevelAxisColor.H.getLevelAxisColor();
                    break;
                case "I":
                    levelAxisColor = LevelAxisColor.I.getLevelAxisColor();
                    break;
                case "J":
                    levelAxisColor = LevelAxisColor.J.getLevelAxisColor();
                    break;
                case "K":
                    levelAxisColor = LevelAxisColor.K.getLevelAxisColor();
                    break;
                case "L":
                    levelAxisColor = LevelAxisColor.L.getLevelAxisColor();
                    break;
                case "M":
                    levelAxisColor = LevelAxisColor.M.getLevelAxisColor();
                    break;
                case "N":
                    levelAxisColor = LevelAxisColor.N.getLevelAxisColor();
                    break;
                case "O":
                    levelAxisColor = LevelAxisColor.O.getLevelAxisColor();
                    break;
                case "P":
                    levelAxisColor = LevelAxisColor.P.getLevelAxisColor();
                    break;
                case "Q":
                    levelAxisColor = LevelAxisColor.Q.getLevelAxisColor();
                    break;
                case "R":
                    levelAxisColor = LevelAxisColor.R.getLevelAxisColor();
                    break;
                case "S":
                    levelAxisColor = LevelAxisColor.S.getLevelAxisColor();
                    break;
                case "T":
                    levelAxisColor = LevelAxisColor.T.getLevelAxisColor();
                    break;
                case "U":
                    levelAxisColor = LevelAxisColor.U.getLevelAxisColor();
                    break;
                case "V":
                    levelAxisColor = LevelAxisColor.V.getLevelAxisColor();
                    break;
                case "W":
                    levelAxisColor = LevelAxisColor.W.getLevelAxisColor();
                    break;
                case "X":
                    levelAxisColor = LevelAxisColor.X.getLevelAxisColor();
                    break;
                case "Y":
                    levelAxisColor = LevelAxisColor.Y.getLevelAxisColor();
                    break;
                case "Z":
                    levelAxisColor = LevelAxisColor.Z.getLevelAxisColor();
                    break;
                case "AA":
                    levelAxisColor = LevelAxisColor.AA.getLevelAxisColor();
                    break;
                case "ZZ":
                    levelAxisColor = LevelAxisColor.ZZ.getLevelAxisColor();
                    break;
                default:
                    levelAxisColor = "";
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return levelAxisColor;
    }

    //function to get assignment data
    private void assignmentsData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<AssignmentDataResultDTO> assignmentDataResultDTOList) throws Exception {
        log.debug("Get Assignment Graph Data");
        try {
            AssignmentDataResultDTO assignmentDataResultDTO = new AssignmentDataResultDTO();
            assignmentDataResultDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            assignmentDataResultDTO.setAccuracy(factOrrAssignmentNoAggEntity.getAccuracy());
            assignmentDataResultDTO.setFluency(factOrrAssignmentNoAggEntity.getFluency());
            assignmentDataResultDTO.setProficiency(factOrrAssignmentNoAggEntity.getProficiency());
            assignmentDataResultDTO.setCategory(factOrrAssignmentNoAggEntity.getDimAssessmentTestByDimAssessmentTestId().getCategory());
            assignmentDataResultDTO.setAssignmentTitle(factOrrAssignmentNoAggEntity.getDimAssessmentTestByDimAssessmentTestId().getComponentTitle());
            //get bubble color by reading level
            String bubbleColor = getBubbleColorByReadingLevel(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
            assignmentDataResultDTO.setBubbleColour(bubbleColor);
            assignmentDataResultDTO.setStartLevel(false);
            assignmentDataResultDTO.setTargetLevel(false);
            assignmentDataResultDTO.setLetterLevel(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
            assignmentDataResultDTO.setNumberLevel(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getNumberLevel());
            assignmentDataResultDTOList.add(assignmentDataResultDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //Get bubble color for letter level
    private String getBubbleColorByReadingLevel(String letterLevel) throws Exception {
        String bubbleColor = null;
        try {
            switch (letterLevel) {
                case "PreA":
                    bubbleColor = AssignmentColor.PreA.getBubbleColor();
                    break;
                case "A":
                    bubbleColor = AssignmentColor.A.getBubbleColor();
                    break;
                case "B":
                    bubbleColor = AssignmentColor.B.getBubbleColor();
                    break;
                case "C":
                    bubbleColor = AssignmentColor.C.getBubbleColor();
                    break;
                case "D":
                    bubbleColor = AssignmentColor.D.getBubbleColor();
                    break;
                case "E":
                    bubbleColor = AssignmentColor.E.getBubbleColor();
                    break;
                case "F":
                    bubbleColor = AssignmentColor.F.getBubbleColor();
                    break;
                case "G":
                    bubbleColor = AssignmentColor.G.getBubbleColor();
                    break;
                case "H":
                    bubbleColor = AssignmentColor.H.getBubbleColor();
                    break;
                case "I":
                    bubbleColor = AssignmentColor.I.getBubbleColor();
                    break;
                case "J":
                    bubbleColor = AssignmentColor.J.getBubbleColor();
                    break;
                case "K":
                    bubbleColor = AssignmentColor.K.getBubbleColor();
                    break;
                case "L":
                    bubbleColor = AssignmentColor.L.getBubbleColor();
                    break;
                case "M":
                    bubbleColor = AssignmentColor.M.getBubbleColor();
                    break;
                case "N":
                    bubbleColor = AssignmentColor.N.getBubbleColor();
                    break;
                case "O":
                    bubbleColor = AssignmentColor.O.getBubbleColor();
                    break;
                case "P":
                    bubbleColor = AssignmentColor.P.getBubbleColor();
                    break;
                case "Q":
                    bubbleColor = AssignmentColor.Q.getBubbleColor();
                    break;
                case "R":
                    bubbleColor = AssignmentColor.R.getBubbleColor();
                    break;
                case "S":
                    bubbleColor = AssignmentColor.S.getBubbleColor();
                    break;
                case "T":
                    bubbleColor = AssignmentColor.T.getBubbleColor();
                    break;
                case "U":
                    bubbleColor = AssignmentColor.U.getBubbleColor();
                    break;
                case "V":
                    bubbleColor = AssignmentColor.V.getBubbleColor();
                    break;
                case "W":
                    bubbleColor = AssignmentColor.W.getBubbleColor();
                    break;
                case "X":
                    bubbleColor = AssignmentColor.X.getBubbleColor();
                    break;
                case "Y":
                    bubbleColor = AssignmentColor.Y.getBubbleColor();
                    break;
                case "Z":
                    bubbleColor = AssignmentColor.Z.getBubbleColor();
                    break;
                case "AA":
                    bubbleColor = AssignmentColor.AA.getBubbleColor();
                    break;
                case "ZZ":
                    bubbleColor = AssignmentColor.ZZ.getBubbleColor();
                    break;
                default:
                    bubbleColor = "";
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return bubbleColor;
    }

    //function to get date range axis
    private void dateRangeAxisData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<DateRangeAxisDTO> dateRangeAxis) throws Exception {
        log.debug("Get Date Range Axis Data");
        try {
            DateRangeAxisDTO dateRangeAxisResult = new DateRangeAxisDTO();
            dateRangeAxisResult.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            dateRangeAxis.add(dateRangeAxisResult);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
