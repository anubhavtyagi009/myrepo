package com.impelsys.microservice.service.getclassreadinghistorydata;

import com.impelsys.microservice.domain.FactOrrAssignmentNoAggEntity;
import com.impelsys.microservice.dto.ClassReadingHistoryDataDTO;
import com.impelsys.microservice.repository.FactOrrAssignmentNoAggEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;


@Service
public class GetClassReadingHistoryDataServiceImpl implements GetClassReadingHistoryDataService {
    private final Logger log = LoggerFactory.getLogger(GetClassReadingHistoryDataServiceImpl.class);

    @Autowired
    FactOrrAssignmentNoAggEntityRepository factOrrAssignmentNoAggEntityRepository;

    @Override
    public GetClassReadingHistoryDataResponse execute(GetClassReadingHistoryDataRequest request, Pageable pageable) throws Exception {
        log.debug("Started to get class level reading history data service-----");
        GetClassReadingHistoryDataResponse response = null;
        Page<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOPage = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            //validate request
            validateRequest(request);
            //repo call to fetch data
            Page<FactOrrAssignmentNoAggEntity> classReadingHistoryEntityList = factOrrAssignmentNoAggEntityRepository.
                    getClassLevelReadingHistoryData(request.getClassId(), dateFormatter.parse(request.getStartDate()),dateFormatter.parse(request.getEndDate()), pageable);
            //function to set values for class level reading history data
            classReadingHistoryDataDTOPage = setValuesForClassLevelReadingHistoryData(classReadingHistoryEntityList);
           //create response
            response = new GetClassReadingHistoryDataResponse(classReadingHistoryDataDTOPage);
            response.SUCCESSFULL = true;
            response.setMessage("Successfull in reading class level history chart data");
            return response;
        } catch (Exception e) {
            log.error(e.getMessage());
            response = new GetClassReadingHistoryDataResponse();
            response.SUCCESSFULL = false;
            response.setMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    private void validateRequest(GetClassReadingHistoryDataRequest request) throws Exception {
        if ((request.getStartDate() == null || request.getStartDate().isEmpty())
                || (request.getEndDate() == null || request.getEndDate().isEmpty())
                || (request.getClassId() == null)) {
            throw new Exception("Mandatory fields should not be null or empty");
        }
    }

    private Page<ClassReadingHistoryDataDTO> setValuesForClassLevelReadingHistoryData(Page<FactOrrAssignmentNoAggEntity> classReadingHistoryEntityList) throws Exception {
        log.debug("Function call started to set values for class level reading history data---");
        Page<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOPage = null;
        try {
            List<FactOrrAssignmentNoAggEntity> factOrrAssignmentNoAggEntities = classReadingHistoryEntityList.getContent();
            List<ClassReadingHistoryDataDTO> classReadingHistoryDataDTOS = new ArrayList<>();
            for (FactOrrAssignmentNoAggEntity fact : factOrrAssignmentNoAggEntities){
                ClassReadingHistoryDataDTO classReadingHistoryDataDTO = new ClassReadingHistoryDataDTO();
                classReadingHistoryDataDTO.setStudentId(fact.getDimStudentByDimStudentId().getStudentId());
                classReadingHistoryDataDTO.setLetterLevel(fact.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
                classReadingHistoryDataDTO.setLastPassage(fact.getDimAssessmentTestByDimAssessmentTestId().getComponentTitle());
                classReadingHistoryDataDTO.setCategory(fact.getDimAssessmentTestByDimAssessmentTestId().getCategory());
                classReadingHistoryDataDTO.setAccuracy(fact.getAccuracy());
                classReadingHistoryDataDTO.setProficiency(fact.getProficiency());
                classReadingHistoryDataDTO.setFluency(fact.getFluency());
                classReadingHistoryDataDTO.setAssignmentDate(fact.getAssignmentCompletionDate());
                classReadingHistoryDataDTO.setNotes(fact.getNotes());
                classReadingHistoryDataDTOS.add(classReadingHistoryDataDTO);
            }
            classReadingHistoryDataDTOPage = new Page<ClassReadingHistoryDataDTO>() {
                @Override
                public int getTotalPages() {
                    return classReadingHistoryEntityList.getTotalPages();
                }

                @Override
                public long getTotalElements() {
                    return classReadingHistoryEntityList.getTotalElements();
                }

                @Override
                public <U> Page<U> map(Function<? super ClassReadingHistoryDataDTO, ? extends U> function) {
                    return null;
                }

                @Override
                public int getNumber() {
                    return classReadingHistoryEntityList.getNumber();
                }

                @Override
                public int getSize() {
                    return classReadingHistoryEntityList.getSize();
                }

                @Override
                public int getNumberOfElements() {
                    return classReadingHistoryEntityList.getNumberOfElements();
                }

                @Override
                public List<ClassReadingHistoryDataDTO> getContent() {
                    return classReadingHistoryDataDTOS;
                }

                @Override
                public boolean hasContent() {
                    return classReadingHistoryEntityList.hasContent();
                }

                @Override
                public Sort getSort() {
                    return classReadingHistoryEntityList.getSort();
                }

                @Override
                public boolean isFirst() {
                    return classReadingHistoryEntityList.isFirst();
                }

                @Override
                public boolean isLast() {
                    return classReadingHistoryEntityList.isLast();
                }

                @Override
                public boolean hasNext() {
                    return classReadingHistoryEntityList.hasNext();
                }

                @Override
                public boolean hasPrevious() {
                    return classReadingHistoryEntityList.hasPrevious();
                }

                @Override
                public Pageable nextPageable() {
                    return classReadingHistoryEntityList.nextPageable();
                }

                @Override
                public Pageable previousPageable() {
                    return classReadingHistoryEntityList.previousPageable();
                }

                @Override
                public Iterator<ClassReadingHistoryDataDTO> iterator() {
                    return classReadingHistoryDataDTOS.iterator();
                }
            };
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return classReadingHistoryDataDTOPage;
    }
}
