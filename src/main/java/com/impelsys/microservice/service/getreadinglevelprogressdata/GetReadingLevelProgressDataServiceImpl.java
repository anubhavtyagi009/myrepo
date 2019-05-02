package com.impelsys.microservice.service.getreadinglevelprogressdata;

import com.impelsys.microservice.domain.DimAssessmentTestEntity;
import com.impelsys.microservice.domain.DimAssignmentCreatorEntity;
import com.impelsys.microservice.domain.DimStudentEntity;
import com.impelsys.microservice.dto.*;
import com.impelsys.microservice.domain.FactOrrAssignmentNoAggEntity;
import com.impelsys.microservice.service.utility.ServiceConstants;
import com.impelsys.microservice.service.utility.BubbleColor;
import com.impelsys.microservice.service.utility.LevelAxisColor;
import com.impelsys.microservice.service.utility.LevelBackGroundColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class GetReadingLevelProgressDataServiceImpl implements GetReadingLevelProgressDataService {
    private final Logger log = LoggerFactory.getLogger(GetReadingLevelProgressDataServiceImpl.class);

    @PersistenceContext
    EntityManager entityManager;

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
            //function call to get fluency axis data
            fluencyAxisData(fluencyArray, noOfLevels, fluencyAxisDTOList);
            //function call to get accuracy axis data
            accuracyAxisData(accuracyAxisDTOList);
            //create response
            rplResponsedataDto = new RplResponseDataDTO( request.getFilters().getExternalFilter(), request.getFilters().getInternalFilter(), dateRangeAxis, readingLevelAxis,
                    assignmentDataResultDTOList, fluencyAxisDTOList, fluencyResultList, accuracyAxisDTOList, accuracyResultList);
            response = new GetReadingLevelProgressDataResponse(rplResponsedataDto);
            response.SUCCESSFULL = true;
            response.setMessage("Reading level progress chart data");
            return response;

        } catch (Exception e) {
            log.error(e.getMessage());
            response = new GetReadingLevelProgressDataResponse(null);
            response.SUCCESSFULL = false;
            response.setMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    //validate input request
    private void validateRequest(GetReadingLevelProgressDataRequest request) throws Exception {
        //validate mandatory fields
        //validate request data exist or not
        if((request.getFilters().getExternalFilter().getStartDate() == null || request.getFilters().getExternalFilter().getStartDate().isEmpty())
                || (request.getFilters().getExternalFilter().getEndDate() == null || request.getFilters().getExternalFilter().getEndDate().isEmpty())
                || (request.getFilters().getExternalFilter().getAssesmentId() == null )
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
                    criteriaBuilder.equal(joinAssessmentTestEntity.get(ServiceConstants.DimAssessmentTestEntity_AssessmentTestId), request.getFilters().getExternalFilter().getAssesmentId()),
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

    //function to get accuracy axis data
    private void accuracyAxisData(List<AccuracyAxisDTO> accuracyAxisDTOList) throws Exception {
        log.debug("Get Accuracy Axis Data");
        try {
            for (int j=10; j<=100; j+=10){
                AccuracyAxisDTO accuracyAxisDTO = new AccuracyAxisDTO();
                accuracyAxisDTO.setValue(j);
                accuracyAxisDTOList.add(accuracyAxisDTO);
            }
        }
        catch (Exception e){
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //function to get fluency axis data
    private void fluencyAxisData(List<Integer> fluencyArray, List<String> noOfLevels, List<FluencyAxisDTO> fluencyAxisDTOList) throws Exception {
        log.debug("Get Fluency Axis Data");
        try {
            if (!fluencyArray.isEmpty() && !noOfLevels.isEmpty()){
                int valuePerLevel = Collections.max(fluencyArray)/noOfLevels.size();
                for (int i=1; i<=noOfLevels.size(); i++) {
                    FluencyAxisDTO fluencyAxisDTO = new FluencyAxisDTO();
                    int incrementLevel = valuePerLevel*i;
                    fluencyAxisDTO.setValue(incrementLevel);
                    fluencyAxisDTOList.add(fluencyAxisDTO);
                }
            }
        }catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //function to get accuracy data
    private void accuracyData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity,List<AccuracyDataDTO> accuracyResultList) throws Exception {
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
        }catch (Exception e){
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
            readingLevelAxisResult.setLevelAxisColor(levelAxisColor);
            readingLevelAxisResult.setLevelBgColor(levelBackGroundColor);
            readingLevelAxis.add(readingLevelAxisResult);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    //Get level background color for letter level
    private String getLevelBackGroundColor(String letterLevel) {
        String levelBackGroundColor = null;
        if (letterLevel.equals("A")){
            levelBackGroundColor = LevelBackGroundColor.A.getLevelBackgroundColor();
        } else if (letterLevel.equals("B")){
            levelBackGroundColor = LevelBackGroundColor.B.getLevelBackgroundColor();
        } else if (letterLevel.equals("C")){
            levelBackGroundColor = LevelBackGroundColor.C.getLevelBackgroundColor();
        }
        else if (letterLevel.equals("D")){
            levelBackGroundColor = LevelBackGroundColor.D.getLevelBackgroundColor();
        }
        else {
            levelBackGroundColor = LevelBackGroundColor.E.getLevelBackgroundColor();
        }
        return levelBackGroundColor;
    }

    //get level axis color for letter level
    private String getLevelAxisColor(String letterLevel) {
        String levelAxisColor = null;
        if (letterLevel.equals("A")){
            levelAxisColor = LevelAxisColor.A.getLevelAxisColor();
        } else if (letterLevel.equals("B")){
            levelAxisColor = LevelAxisColor.B.getLevelAxisColor();
        } else if (letterLevel.equals("C")){
            levelAxisColor = LevelAxisColor.C.getLevelAxisColor();
        }
        else if (letterLevel.equals("D")){
            levelAxisColor = LevelAxisColor.D.getLevelAxisColor();
        }
        else {
            levelAxisColor = LevelAxisColor.E.getLevelAxisColor();
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
    private String getBubbleColorByReadingLevel(String letterLevel) {
        String bubbleColor = null;
        if (letterLevel.equals("A")){
            bubbleColor = BubbleColor.A.getBubbleColor();
        } else if (letterLevel.equals("B")){
            bubbleColor = BubbleColor.B.getBubbleColor();
        } else if (letterLevel.equals("C")){
            bubbleColor = BubbleColor.C.getBubbleColor();
        }
        else if (letterLevel.equals("D")){
            bubbleColor = BubbleColor.D.getBubbleColor();
        }
        else {
            bubbleColor = BubbleColor.E.getBubbleColor();
        }
        return bubbleColor;
    }

    //function to get date range axis
    private void dateRangeAxisData(FactOrrAssignmentNoAggEntity factOrrAssignmentNoAggEntity,  List<DateRangeAxisDTO> dateRangeAxis) throws Exception {
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
