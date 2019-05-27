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
package com.bec.orrreporting.service.geterroranalysisdata;

import com.bec.orrreporting.domain.DimAssessmentTestEntity;
import com.bec.orrreporting.domain.DimAssignmentCreatorEntity;
import com.bec.orrreporting.domain.DimStudentEntity;
import com.bec.orrreporting.domain.FactOrrAssignmentNoAggEntity;
import com.bec.orrreporting.dto.*;
import com.bec.orrreporting.repository.DimAssignmentCreatorEntityRepository;
import com.bec.orrreporting.repository.DimStudentEntityRepository;
import com.bec.orrreporting.service.utility.CommonFunctions;
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


@SuppressWarnings("BoxingBoxedValue")
@Service
public class GetErrorAnalysisDataServiceImpl implements GetErrorAnalysisDataService {
    private final Logger log = LoggerFactory.getLogger(GetErrorAnalysisDataServiceImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    DimAssignmentCreatorEntityRepository dimAssignmentCreatorEntityRepository;

    @Autowired
    DimStudentEntityRepository dimStudentEntityRepository;

    @SuppressWarnings("BoxingBoxedValue")
    @Override
    public GetErrorAnalysisDataResponse execute(GetErrorAnalysisDataRequest request) throws Exception {
        log.debug("calling error analysis API execute function------");
        GetErrorAnalysisDataResponse response = null;
        ErrorAnalysisResponseDataDTO errorAnalysisResponseDataDTO = null;
        ErrorAnalysisDataResultDTO errorAnalysisDataResultDTO = new ErrorAnalysisDataResultDTO();
        List<DateRangeReadingLevelAxisDTO> dateRangeReadingLevelAxisList = new ArrayList<>();
        ErrorAnalysisAverageDTO errorAnalysisAverageDTO = new ErrorAnalysisAverageDTO();
        ErrorAnalysisDonutDTO errorAnalysisDonutDTO = new ErrorAnalysisDonutDTO();
        MsvAnalysisDonutDTO msvAnalysisDonutDTO = new MsvAnalysisDonutDTO();
        List<SubstitutionDTO> substitutionList = new ArrayList<>();
        List<OmissionDTO> omissionList = new ArrayList<>();
        List<InsertionDTO> insertionList = new ArrayList<>();
        List<ToldDTO> toldList = new ArrayList<>();
        List<RepetationDTO> repetationList = new ArrayList<>();
        List<SelfCorrectionDTO> selfCorrectionList = new ArrayList<>();
        List<MeaningCuesDTO> meaningCuesList = new ArrayList<>();
        List<StructuralCuesDTO> structuralCuesList = new ArrayList<>();
        List<VisualCuesDTO> visualCuesList = new ArrayList<>();
        List<OmissionToldsDTO> omissionToldsList = new ArrayList<>();
        List<Integer> substitutionArray = new ArrayList<>();
        List<Integer> ommissionArray = new ArrayList<>();
        List<Integer> insertionArray = new ArrayList<>();
        List<Integer> toldArray = new ArrayList<>();
        List<Integer> repetationArray = new ArrayList<>();
        List<Integer> selfCorrectionArray = new ArrayList<>();
        List<Float> meaningCuesArray = new ArrayList<>();
        List<Float> structuralCuesArray = new ArrayList<>();
        List<Float> visualCuesArray = new ArrayList<>();
        List<Float> ommissionToldsArray = new ArrayList<>();
        List<Double> errorAnalysisItemsArray = new ArrayList<>();
        List<Float> msvAnalysisItemsArray = new ArrayList<>();

        try {
            //function to validate request
            validateRequest(request);
            //fetch data from query based on filters
            List<FactOrrAssignmentNoAggEntity> factOrrAssignmentNoAggEntityResultList = createDynamicQueryForStudentLevelErrorAnalysis(request);
            if (!factOrrAssignmentNoAggEntityResultList.isEmpty()) {
                for (FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity : factOrrAssignmentNoAggEntityResultList) {
                    //function to set date range axis
                    setDateRangeAxisData(factOrrAssignmentNoAggEntity, dateRangeReadingLevelAxisList);
                    //function to set substitution data
                    substitutionList = setSubstitutionData(factOrrAssignmentNoAggEntity, substitutionList);
                    //function to set omission data
                    omissionList = setOmissionData(factOrrAssignmentNoAggEntity, omissionList);
                    //function to set insertion data
                    insertionList = setInsertionData(factOrrAssignmentNoAggEntity, insertionList);
                    //function to set told data
                    toldList = setToldData(factOrrAssignmentNoAggEntity, toldList);
                    //function to set repetation data
                    repetationList = setRepetationData(factOrrAssignmentNoAggEntity, repetationList);
                    //function to set self correction data
                    selfCorrectionList = setSelfCorrectionData(factOrrAssignmentNoAggEntity, selfCorrectionList);
                    //function to set meaning cues data
                    meaningCuesList = setMeaningCuesData(factOrrAssignmentNoAggEntity, meaningCuesList);
                    //function to set structural cues data
                    structuralCuesList = setStructuralCuesData(factOrrAssignmentNoAggEntity, structuralCuesList);
                    //function to set visual cues data
                    visualCuesList = setVisualCuesData(factOrrAssignmentNoAggEntity, visualCuesList);
                    //function to set omission told data
                    omissionToldsList = setOmissionToldData(factOrrAssignmentNoAggEntity, omissionToldsList);
                    //substitution values array
                    substitutionArray.add(factOrrAssignmentNoAggEntity.getMarkingSubstitutions());
                    //ommisson values array
                    ommissionArray.add(factOrrAssignmentNoAggEntity.getMarkingOmmissions());
                    //insertion values array
                    insertionArray.add(factOrrAssignmentNoAggEntity.getMarkingInsertions());
                    //told values array
                    toldArray.add(factOrrAssignmentNoAggEntity.getMarkingTolds());
                    //repetation values array
                    repetationArray.add(factOrrAssignmentNoAggEntity.getMarkingRepetitions());
                    //self correction values array
                    selfCorrectionArray.add(factOrrAssignmentNoAggEntity.getMarkingSelfCorrections());
                    //meaning cues values array
                    meaningCuesArray.add(Float.valueOf(String.valueOf(factOrrAssignmentNoAggEntity.getCuesMeaning())));
                    //structural cues values array
                    structuralCuesArray.add(Float.valueOf(String.valueOf(factOrrAssignmentNoAggEntity.getCuesStructural())));
                    //visual cues values array
                    visualCuesArray.add(Float.valueOf(String.valueOf(factOrrAssignmentNoAggEntity.getCuesVisual())));
                    //ommission tolds values array
                    ommissionToldsArray.add(Float.valueOf(String.valueOf(factOrrAssignmentNoAggEntity.getCuesOmmissions())));
                }
            }
            //caliculate average for each Error type
            Double substitutionAverage = CommonFunctions.sum(substitutionArray) / Double.valueOf(substitutionArray.size());
            Double ommissionAverage = CommonFunctions.sum(ommissionArray) / Double.valueOf(ommissionArray.size());
            Double insertionAverage = CommonFunctions.sum(insertionArray) / Double.valueOf(insertionArray.size());
            Double toldAverage = CommonFunctions.sum(toldArray) / Double.valueOf(toldArray.size());
            Double repetationAverage = CommonFunctions.sum(repetationArray) / Double.valueOf(repetationArray.size());
            Double selfCorrectionAverage = CommonFunctions.sum(selfCorrectionArray) / Double.valueOf(selfCorrectionArray.size());
            Float meaningCuesAverage = CommonFunctions.sumFLoatNumbers(meaningCuesArray) / meaningCuesArray.size();
            Float structuralCuesAverage = CommonFunctions.sumFLoatNumbers(structuralCuesArray) / structuralCuesArray.size();
            Float visualCuesAverage = CommonFunctions.sumFLoatNumbers(visualCuesArray) / visualCuesArray.size();
            Float ommissionToldsAverage = CommonFunctions.sumFLoatNumbers(ommissionToldsArray) / ommissionToldsArray.size();

            //add all error type average values to array
            errorAnalysisItemsArray.add(Double.valueOf(Math.round(substitutionAverage)));
            errorAnalysisItemsArray.add(Double.valueOf(Math.round(ommissionAverage)));
            errorAnalysisItemsArray.add(Double.valueOf(Math.round(insertionAverage)));
            errorAnalysisItemsArray.add(Double.valueOf(Math.round(toldAverage)));
            errorAnalysisItemsArray.add(Double.valueOf(Math.round(repetationAverage)));
            errorAnalysisItemsArray.add(Double.valueOf(Math.round(selfCorrectionAverage)));

            //add all msv type values to array
            msvAnalysisItemsArray.add(meaningCuesAverage);
            msvAnalysisItemsArray.add(structuralCuesAverage);
            msvAnalysisItemsArray.add(visualCuesAverage);
            msvAnalysisItemsArray.add(ommissionToldsAverage);

            //sum all error analysis values of array
            Double errorAnalysisItemsTotal = CommonFunctions.sumDoubleNumbers(errorAnalysisItemsArray);
            //sum all msv analysis values of array
            Float msvAnalysisItemsTotal = CommonFunctions.sumFLoatNumbers(msvAnalysisItemsArray);

            Double substitutionPercentage = (Double.valueOf(Math.round(substitutionAverage)) / Double.valueOf(Math.round(errorAnalysisItemsTotal))) * 100;
            Double ommissionPercentage = (Double.valueOf(Math.round(ommissionAverage)) / Double.valueOf(Math.round(errorAnalysisItemsTotal))) * 100;
            Double insertionPercentage = (Double.valueOf(Math.round(insertionAverage)) / Double.valueOf(Math.round(errorAnalysisItemsTotal))) * 100;
            Double toldPercentage = (Double.valueOf(Math.round(toldAverage)) / Double.valueOf(Math.round(errorAnalysisItemsTotal))) * 100;
            Double repetationPercentage = (Double.valueOf(Math.round(repetationAverage)) / Double.valueOf(Math.round(errorAnalysisItemsTotal))) * 100;
            Double selfCorrectionPercentage = (Double.valueOf(Math.round(selfCorrectionAverage)) / Double.valueOf(Math.round(errorAnalysisItemsTotal))) * 100;

            //all error analysis donut chart percentage values to response
            errorAnalysisDonutDTO.setSubstitution(Math.round(substitutionPercentage));
            errorAnalysisDonutDTO.setOmmission(Math.round(ommissionPercentage));
            errorAnalysisDonutDTO.setInsertion(Math.round(insertionPercentage));
            errorAnalysisDonutDTO.setTold(Math.round(toldPercentage));
            errorAnalysisDonutDTO.setRepetation(Math.round(repetationPercentage));
            errorAnalysisDonutDTO.setSelfCorrection(Math.round(selfCorrectionPercentage));

            //all msv analysis donut chart percentage values to Response
            msvAnalysisDonutDTO.setMeaningCues((Math.round(meaningCuesAverage / msvAnalysisItemsTotal * 100)));
            msvAnalysisDonutDTO.setStructuralCues((Math.round(structuralCuesAverage / msvAnalysisItemsTotal * 100)));
            msvAnalysisDonutDTO.setVisualCues((Math.round(visualCuesAverage / msvAnalysisItemsTotal * 100)));
            msvAnalysisDonutDTO.setOmmissionAndTolds((Math.round(ommissionToldsAverage / msvAnalysisItemsTotal * 100)));

            //all error analysis average values to response
            errorAnalysisAverageDTO.setSubstitutionAverage(Math.round(substitutionAverage));
            errorAnalysisAverageDTO.setOmmissionAverage(Math.round(ommissionAverage));
            errorAnalysisAverageDTO.setInsertionAverage(Math.round(insertionAverage));
            errorAnalysisAverageDTO.setToldAverage(Math.round(toldAverage));
            errorAnalysisAverageDTO.setRepetationAverage(Math.round(repetationAverage));
            errorAnalysisAverageDTO.setSelfCorrectionAverage(Math.round(selfCorrectionAverage));
            errorAnalysisAverageDTO.setMeaningCuesAverage(Math.round(Double.valueOf(meaningCuesAverage)));
            errorAnalysisAverageDTO.setStructuralCuesAverage(Math.round(Double.valueOf(structuralCuesAverage)));
            errorAnalysisAverageDTO.setVisualCuesAverage(Math.round(Double.valueOf(visualCuesAverage)));
            errorAnalysisAverageDTO.setOmmissionToldsAverage(Math.round(Double.valueOf(ommissionToldsAverage)));

            //set error analysis items datewise data
            errorAnalysisDataResultDTO.setSubstitution(substitutionList);
            errorAnalysisDataResultDTO.setOmission(omissionList);
            errorAnalysisDataResultDTO.setInsertion(insertionList);
            errorAnalysisDataResultDTO.setTold(toldList);
            errorAnalysisDataResultDTO.setRepetation(repetationList);
            errorAnalysisDataResultDTO.setSelfCorrection(selfCorrectionList);
            errorAnalysisDataResultDTO.setMeaningCues(meaningCuesList);
            errorAnalysisDataResultDTO.setStructuralCues(structuralCuesList);
            errorAnalysisDataResultDTO.setVisualCues(visualCuesList);
            errorAnalysisDataResultDTO.setOmissionTolds(omissionToldsList);
            //create response
            errorAnalysisResponseDataDTO = new ErrorAnalysisResponseDataDTO(request.getFilters().getExternalFilter(), request.getFilters().getInternalFilter(), dateRangeReadingLevelAxisList,
                    errorAnalysisDataResultDTO, errorAnalysisAverageDTO, errorAnalysisDonutDTO, msvAnalysisDonutDTO);
            response = new GetErrorAnalysisDataResponse(errorAnalysisResponseDataDTO);
            response.SUCCESSFULL = true;
            response.setMessage("Error Analysis chart data");
            return response;
        } catch (Exception e) {
            log.error(e.getMessage());
            response = new GetErrorAnalysisDataResponse(errorAnalysisResponseDataDTO);
            response.SUCCESSFULL = false;
            response.setErrorCode(500);
            response.setErrorMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    private List<OmissionToldsDTO> setOmissionToldData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<OmissionToldsDTO> omissionToldsDTOS) throws Exception {
        try {
            OmissionToldsDTO omissionToldsDTO = new OmissionToldsDTO();
            omissionToldsDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            omissionToldsDTO.setValue(factOrrAssignmentNoAggEntity.getCuesOmmissions());
            omissionToldsDTOS.add(omissionToldsDTO);
            return omissionToldsDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<VisualCuesDTO> setVisualCuesData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<VisualCuesDTO> visualCuesDTOS) throws Exception {
        try {
            VisualCuesDTO visualCuesDTO = new VisualCuesDTO();
            visualCuesDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            visualCuesDTO.setValue(factOrrAssignmentNoAggEntity.getCuesVisual());
            visualCuesDTOS.add(visualCuesDTO);
            return visualCuesDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<StructuralCuesDTO> setStructuralCuesData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<StructuralCuesDTO> structuralCuesDTOS) throws Exception {
        try {
            StructuralCuesDTO structuralCuesDTO = new StructuralCuesDTO();
            structuralCuesDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            structuralCuesDTO.setValue(factOrrAssignmentNoAggEntity.getCuesStructural());
            structuralCuesDTOS.add(structuralCuesDTO);
            return structuralCuesDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<MeaningCuesDTO> setMeaningCuesData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<MeaningCuesDTO> meaningCuesDTOS) throws Exception {
        try {
            MeaningCuesDTO meaningCuesDTO = new MeaningCuesDTO();
            meaningCuesDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            meaningCuesDTO.setValue(factOrrAssignmentNoAggEntity.getCuesMeaning());
            meaningCuesDTOS.add(meaningCuesDTO);
            return meaningCuesDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<SelfCorrectionDTO> setSelfCorrectionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<SelfCorrectionDTO> selfCorrectionDTOS) throws Exception {
        try {
            SelfCorrectionDTO selfCorrectionDTO = new SelfCorrectionDTO();
            selfCorrectionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            selfCorrectionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingSelfCorrections());
            selfCorrectionDTOS.add(selfCorrectionDTO);
            return selfCorrectionDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<RepetationDTO> setRepetationData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<RepetationDTO> repetationDTOS) throws Exception {
        try {
            RepetationDTO repetationDTO = new RepetationDTO();
            repetationDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            repetationDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingRepetitions());
            repetationDTOS.add(repetationDTO);
            return repetationDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<ToldDTO> setToldData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<ToldDTO> toldDTOS) throws Exception {
        try {
            ToldDTO toldDTO = new ToldDTO();
            toldDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            toldDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingTolds());
            toldDTOS.add(toldDTO);
            return toldDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<InsertionDTO> setInsertionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<InsertionDTO> insertionDTOS) throws Exception {
        try {
            InsertionDTO insertionDTO = new InsertionDTO();
            insertionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            insertionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingInsertions());
            insertionDTOS.add(insertionDTO);
            return insertionDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<OmissionDTO> setOmissionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<OmissionDTO> omissionDTOS) throws Exception {
        try {
            OmissionDTO omissionDTO = new OmissionDTO();
            omissionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            omissionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingOmmissions());
            omissionDTOS.add(omissionDTO);
            return omissionDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private List<SubstitutionDTO> setSubstitutionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<SubstitutionDTO> substitutionDTOS) throws Exception {
        try {
            SubstitutionDTO substitutionDTO = new SubstitutionDTO();
            substitutionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            substitutionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingSubstitutions());
            substitutionDTOS.add(substitutionDTO);
            return substitutionDTOS;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //validate input request
    private void validateRequest(GetErrorAnalysisDataRequest request) throws Exception {
        try {
            validateMandatoryFields(request);
            validateRequestDataExistOrNot(request);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void validateRequestDataExistOrNot(GetErrorAnalysisDataRequest request) throws Exception {
        Long teacherId = dimAssignmentCreatorEntityRepository.findByTeacherId(request.getFilters().getExternalFilter().getTeacherId());
        if (teacherId == null) {
            throw new Exception("Teacher Id does not exist :");
        }
        Long studentId = dimStudentEntityRepository.findByStudentId(request.getFilters().getExternalFilter().getStudentId());
        if (studentId == null) {
            throw new Exception("Student Id does not exist :");
        }
    }

    private void validateMandatoryFields(GetErrorAnalysisDataRequest request) throws Exception {
        if ((request.getFilters().getExternalFilter().getStartDate() == null || request.getFilters().getExternalFilter().getStartDate().isEmpty())
                || (request.getFilters().getExternalFilter().getEndDate() == null || request.getFilters().getExternalFilter().getEndDate().isEmpty())
                || (request.getFilters().getExternalFilter().getStudentId() == null)
                || (request.getFilters().getExternalFilter().getTeacherId() == null)
                || (request.getFilters().getExternalFilter().getStudentGrade() == null || request.getFilters().getExternalFilter().getStudentGrade().isEmpty())) {
            throw new Exception("Mandatory fields should not be null or empty");
        }
    }

    //create dynamic query
    private List<FactOrrAssignmentNoAggEntity> createDynamicQueryForStudentLevelErrorAnalysis(GetErrorAnalysisDataRequest request) throws Exception {
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

            typedQuery = entityManager.createQuery(criteriaQuery);
            resultListOfFactOrrAssignmentNoAggEntity = typedQuery.getResultList();
        } catch (ParseException e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return resultListOfFactOrrAssignmentNoAggEntity;
    }

    //function to get date range axis
    private void setDateRangeAxisData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<DateRangeReadingLevelAxisDTO> dateRangeReadingLevelAxisDTOS) throws Exception {
        try {
            DateRangeReadingLevelAxisDTO dateRangeReadingLevelAxisDTO = new DateRangeReadingLevelAxisDTO();
            dateRangeReadingLevelAxisDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            dateRangeReadingLevelAxisDTO.setReadingLevel(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
            dateRangeReadingLevelAxisDTO.setProficiency(factOrrAssignmentNoAggEntity.getProficiency());
            dateRangeReadingLevelAxisDTO.setLastPassage(factOrrAssignmentNoAggEntity.getDimAssessmentTestByDimAssessmentTestId().getComponentTitle());
            dateRangeReadingLevelAxisDTOS.add(dateRangeReadingLevelAxisDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
