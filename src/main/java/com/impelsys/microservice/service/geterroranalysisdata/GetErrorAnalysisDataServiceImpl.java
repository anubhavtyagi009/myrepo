package com.impelsys.microservice.service.geterroranalysisdata;

import com.impelsys.microservice.domain.DimAssessmentTestEntity;
import com.impelsys.microservice.domain.DimAssignmentCreatorEntity;
import com.impelsys.microservice.domain.DimStudentEntity;
import com.impelsys.microservice.domain.FactOrrAssignmentNoAggEntity;
import com.impelsys.microservice.dto.*;
import com.impelsys.microservice.service.utility.ServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class GetErrorAnalysisDataServiceImpl implements GetErrorAnalysisDataService {
    private final Logger log = LoggerFactory.getLogger(GetErrorAnalysisDataServiceImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public GetErrorAnalysisDataResponse execute(GetErrorAnalysisDataRequest request) throws Exception {
        log.debug("calling error analysis API execute function------");
        GetErrorAnalysisDataResponse response = null;
        ErrorAnalysisResponseDataDTO errorAnalysisResponseDataDTO = null;
        List<ErrorAnalysisDataResultDTO> errorAnalysisDataResultDTOList = new ArrayList<>();
        ErrorAnalysisDataResultDTO errorAnalysisDataResultDTO= new ErrorAnalysisDataResultDTO();
        List<DateRangeAxisDTO> dateRangeAxis = new ArrayList<>();
        List<SubstitutionDTO> substitutionDTOS = new ArrayList<>();
        List<OmissionDTO> omissionDTOS = new ArrayList<>();
        List<InsertionDTO> insertionDTOS = new ArrayList<>();
        List<ToldDTO> toldDTOS = new ArrayList<>();
        List<RepetationDTO> repetationDTOS = new ArrayList<>();
        List<SelfCorrectionDTO> selfCorrectionDTOS = new ArrayList<>();
        List<MeaningCuesDTO> meaningCuesDTOS = new ArrayList<>();
        List<StructuralCuesDTO> structuralCuesDTOS = new ArrayList<>();
        List<VisualCuesDTO> visualCuesDTOS = new ArrayList<>();
        List<OmissionToldsDTO> omissionToldsDTOS = new ArrayList<>();

        try {
            //function to validate request
            validateRequest(request);
            //fetch data from query based on filters
            List<FactOrrAssignmentNoAggEntity> factOrrAssignmentNoAggEntityResultList = createDynamicQueryForErrorAnalysis(request);
            log.info("no values");
            if (!factOrrAssignmentNoAggEntityResultList.isEmpty()) {
                for (FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity : factOrrAssignmentNoAggEntityResultList) {
                    log.info("control is coming here");

                    SetDateRangeAxisData(factOrrAssignmentNoAggEntity, dateRangeAxis);
                    substitutionDTOS = SetSubstitutionData(factOrrAssignmentNoAggEntity, substitutionDTOS);
                    omissionDTOS = SetOmissionData(factOrrAssignmentNoAggEntity, omissionDTOS);
                    insertionDTOS = SetInsertionData(factOrrAssignmentNoAggEntity, insertionDTOS);
                    toldDTOS = SetToldData(factOrrAssignmentNoAggEntity, toldDTOS);
                    repetationDTOS = SetRepetationData(factOrrAssignmentNoAggEntity, repetationDTOS);
                    selfCorrectionDTOS = SetSelfCorrectionData(factOrrAssignmentNoAggEntity, selfCorrectionDTOS);
                    meaningCuesDTOS = SetMeaningCuesData(factOrrAssignmentNoAggEntity, meaningCuesDTOS);
                    structuralCuesDTOS = SetStructuralCuesData(factOrrAssignmentNoAggEntity, structuralCuesDTOS);
                    visualCuesDTOS = SetVisualCuesData(factOrrAssignmentNoAggEntity, visualCuesDTOS);
                    omissionToldsDTOS = SetOmissionToldData(factOrrAssignmentNoAggEntity, omissionToldsDTOS);

                }
            }

            errorAnalysisDataResultDTO.setSubstitution(substitutionDTOS);
            errorAnalysisDataResultDTO.setOmission(omissionDTOS);
            errorAnalysisDataResultDTO.setInsertion(insertionDTOS);
            errorAnalysisDataResultDTO.setTold(toldDTOS);
            errorAnalysisDataResultDTO.setRepetation(repetationDTOS);
            errorAnalysisDataResultDTO.setSelfCorrection(selfCorrectionDTOS);
            errorAnalysisDataResultDTO.setMeaningCues(meaningCuesDTOS);
            errorAnalysisDataResultDTO.setStructuralCues(structuralCuesDTOS);
            errorAnalysisDataResultDTO.setVisualCues(visualCuesDTOS);
            errorAnalysisDataResultDTO.setOmissionTolds(omissionToldsDTOS);
            errorAnalysisDataResultDTOList.add(errorAnalysisDataResultDTO);

            //create response
            errorAnalysisResponseDataDTO = new ErrorAnalysisResponseDataDTO( request.getFilters().getExternalFilter(), request.getFilters().getInternalFilter(), dateRangeAxis,
                    errorAnalysisDataResultDTOList);
            response = new GetErrorAnalysisDataResponse(errorAnalysisResponseDataDTO);
            response.SUCCESSFULL = true;
            response.setMessage("Error Analysis chart data");
            return response;

        } catch (Exception e) {
            log.error(e.getMessage());
            response = new GetErrorAnalysisDataResponse(errorAnalysisResponseDataDTO);
            response.SUCCESSFULL = false;
            response.setMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    private List<OmissionToldsDTO> SetOmissionToldData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<OmissionToldsDTO> omissionToldsDTOS) {
        OmissionToldsDTO omissionToldsDTO = new OmissionToldsDTO();
        omissionToldsDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        omissionToldsDTO.setValue(factOrrAssignmentNoAggEntity.getCuesOmmissions());
        omissionToldsDTOS.add(omissionToldsDTO);
        return omissionToldsDTOS;

    }

    private List<VisualCuesDTO> SetVisualCuesData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<VisualCuesDTO> visualCuesDTOS) {
        VisualCuesDTO visualCuesDTO = new VisualCuesDTO();
        visualCuesDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        visualCuesDTO.setValue(factOrrAssignmentNoAggEntity.getCuesVisual());
        visualCuesDTOS.add(visualCuesDTO);
        return visualCuesDTOS;
    }

    private List<StructuralCuesDTO> SetStructuralCuesData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<StructuralCuesDTO> structuralCuesDTOS) {
        StructuralCuesDTO structuralCuesDTO = new StructuralCuesDTO();
        structuralCuesDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        structuralCuesDTO.setValue(factOrrAssignmentNoAggEntity.getCuesStructural());
        structuralCuesDTOS.add(structuralCuesDTO);
        return structuralCuesDTOS;
    }

    private List<MeaningCuesDTO> SetMeaningCuesData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<MeaningCuesDTO> meaningCuesDTOS) {
        MeaningCuesDTO meaningCuesDTO = new MeaningCuesDTO();
        meaningCuesDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        meaningCuesDTO.setValue(factOrrAssignmentNoAggEntity.getCuesMeaning());
        meaningCuesDTOS.add(meaningCuesDTO);
        return meaningCuesDTOS;
    }

    private List<SelfCorrectionDTO> SetSelfCorrectionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<SelfCorrectionDTO> selfCorrectionDTOS) {
        SelfCorrectionDTO selfCorrectionDTO = new SelfCorrectionDTO();
        selfCorrectionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        selfCorrectionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingSelfCorrections());
        selfCorrectionDTOS.add(selfCorrectionDTO);
        return selfCorrectionDTOS;
    }

    private List<RepetationDTO> SetRepetationData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<RepetationDTO> repetationDTOS) {
        RepetationDTO repetationDTO = new RepetationDTO();
        repetationDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        repetationDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingRepetitions());
        repetationDTOS.add(repetationDTO);
        return repetationDTOS;
    }

    private List<ToldDTO> SetToldData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<ToldDTO> toldDTOS) {
        ToldDTO toldDTO = new ToldDTO();
        toldDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        toldDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingTolds());
        toldDTOS.add(toldDTO);
        return toldDTOS;
    }

    private List<InsertionDTO> SetInsertionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<InsertionDTO> insertionDTOS) {
        InsertionDTO insertionDTO = new InsertionDTO();
        insertionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        insertionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingInsertions());
        insertionDTOS.add(insertionDTO);
        return insertionDTOS;
    }

    private List<OmissionDTO> SetOmissionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<OmissionDTO> omissionDTOS) {
        OmissionDTO omissionDTO = new OmissionDTO();
        omissionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        omissionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingOmmissions());
        omissionDTOS.add(omissionDTO);
        return omissionDTOS;
    }

    private List<SubstitutionDTO> SetSubstitutionData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<SubstitutionDTO> substitutionDTOS) {
        SubstitutionDTO substitutionDTO = new SubstitutionDTO();
        substitutionDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
        substitutionDTO.setValue(factOrrAssignmentNoAggEntity.getMarkingSubstitutions());
        substitutionDTOS.add(substitutionDTO);
        return substitutionDTOS;
    }

    //validate input request
    private void validateRequest(GetErrorAnalysisDataRequest request) throws Exception {
        if((request.getFilters().getExternalFilter().getStartDate() == null || request.getFilters().getExternalFilter().getStartDate().isEmpty())
                || (request.getFilters().getExternalFilter().getEndDate() == null || request.getFilters().getExternalFilter().getEndDate().isEmpty())
                || (request.getFilters().getExternalFilter().getStudentId() == null)
                || (request.getFilters().getExternalFilter().getTeacherId() == null)
                || (request.getFilters().getExternalFilter().getStudentGrade() == null || request.getFilters().getExternalFilter().getStudentGrade().isEmpty())) {
            throw new Exception("Mandatory fields should not be null or empty");
        }
    }

    //create dynamic query
    private List<FactOrrAssignmentNoAggEntity> createDynamicQueryForErrorAnalysis(GetErrorAnalysisDataRequest request) throws Exception {
        List<FactOrrAssignmentNoAggEntity> resultListOfFactOrrAssignmentNoAggEntity = null;
        TypedQuery<FactOrrAssignmentNoAggEntity> typedQuery = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");
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
                    criteriaBuilder.upper(joinAssessmentTestEntity.get(ServiceConstants.DimAssessmentTestEntity_Category)).in(categoryListOfString)));

            typedQuery = entityManager.createQuery(criteriaQuery);
            resultListOfFactOrrAssignmentNoAggEntity = typedQuery.getResultList();
        } catch (ParseException e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return resultListOfFactOrrAssignmentNoAggEntity;
    }

    //function to get date range axis
    private void SetDateRangeAxisData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity, List<DateRangeAxisDTO> dateRangeAxis) throws Exception {
        log.debug("Get Date Range and Reading Level Axis Data");
        try {
            DateRangeAxisDTO dateRangeAxisDTO = new DateRangeAxisDTO();
            dateRangeAxisDTO.setAssignmentDate(factOrrAssignmentNoAggEntity.getAssignmentCompletionDate());
            dateRangeAxisDTO.setReadingLevel(factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getLeterLevel()+"/"+factOrrAssignmentNoAggEntity.getDimReadingLevelsByDimReadingLevelId().getNumberLevel());
            dateRangeAxis.add(dateRangeAxisDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
