package com.impelsys.microservice.service.getstudentreadinghistorydata;

import com.impelsys.microservice.domain.FactOrrAssignmentNoAggEntity;
import com.impelsys.microservice.dto.*;
import com.impelsys.microservice.repository.FactOrrAssignmentNoAggEntityRepository;
import com.impelsys.microservice.dto.StudentReadingHistoryDataDTO;
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
public class GetStudentReadingHistoryDataServiceImpl implements GetStudentReadingHistoryDataService {
    private final Logger log = LoggerFactory.getLogger(GetStudentReadingHistoryDataServiceImpl.class);

    @Autowired
    FactOrrAssignmentNoAggEntityRepository factOrrAssignmentNoAggEntityRepository;

    @Override
    public GetStudentReadingHistoryDataResponse execute(GetStudentReadingHistoryDataRequest request, Pageable pageable) throws Exception {
        log.debug("Started to get student level reading history data service-----");
        GetStudentReadingHistoryDataResponse response = null;
        Page<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTOPage = null;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            //validate request
            validateRequest(request);
            //repo call to fetch data
            Page<FactOrrAssignmentNoAggEntity> studentReadingHistoryEntityList = factOrrAssignmentNoAggEntityRepository.
                    getStudentLevelReadingHistoryData(request.getStudentId(), request.getStudentGrade(), request.getTeacherId(), dateFormatter.parse(request.getStartDate()),dateFormatter.parse(request.getEndDate()), pageable);
            //function to set values for student level reading history data
            studentReadingHistoryDataDTOPage = setValuesForStudentLevelReadingHistoryData(studentReadingHistoryEntityList);
           //create response
            response = new GetStudentReadingHistoryDataResponse(studentReadingHistoryDataDTOPage);
            response.SUCCESSFULL = true;
            response.setMessage("Successfull in reading student level history chart data");
            return response;
        } catch (Exception e) {
            log.error(e.getMessage());
            response = new GetStudentReadingHistoryDataResponse();
            response.SUCCESSFULL = false;
            response.setMessage("Error in Fetching Data : " + e.getMessage());
            return response;
        }
    }

    //validate mandatory user inputs
    private void validateRequest(GetStudentReadingHistoryDataRequest request) throws Exception {
        //check user input fields contains value
        if ((request.getStartDate() == null || request.getStartDate().isEmpty())
                || (request.getEndDate() == null || request.getEndDate().isEmpty())
                || (request.getStudentId() == null)
                || (request.getTeacherId() == null)
                || (request.getStudentGrade() == null || request.getStudentGrade().isEmpty())) {
            throw new Exception("Mandatory fields should not be null or empty");
        }

    }

    private Page<StudentReadingHistoryDataDTO> setValuesForStudentLevelReadingHistoryData(Page<FactOrrAssignmentNoAggEntity> studentReadingHistoryEntityList) throws Exception {
        log.debug("Function call started to set values for student level reading history data---");
        Page<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTOPage = null;
        try {
            List<FactOrrAssignmentNoAggEntity> factOrrAssignmentNoAggEntities = studentReadingHistoryEntityList.getContent();
            List<StudentReadingHistoryDataDTO> studentReadingHistoryDataDTOS = new ArrayList<>();
            for (FactOrrAssignmentNoAggEntity fact : factOrrAssignmentNoAggEntities){
                StudentReadingHistoryDataDTO studentReadingHistoryDataDTO = new StudentReadingHistoryDataDTO();
                studentReadingHistoryDataDTO.setStudentId(fact.getDimStudentByDimStudentId().getStudentId());
                studentReadingHistoryDataDTO.setLetterLevel(fact.getDimReadingLevelsByDimReadingLevelId().getLeterLevel());
                studentReadingHistoryDataDTO.setLastPassage(fact.getDimAssessmentTestByDimAssessmentTestId().getComponentTitle());
                studentReadingHistoryDataDTO.setCategory(fact.getDimAssessmentTestByDimAssessmentTestId().getCategory());
                studentReadingHistoryDataDTO.setAccuracy(fact.getAccuracy());
                studentReadingHistoryDataDTO.setProficiency(fact.getProficiency());
                studentReadingHistoryDataDTO.setFluency(fact.getFluency());
                studentReadingHistoryDataDTO.setAssignmentDate(fact.getAssignmentCompletionDate());
                studentReadingHistoryDataDTO.setNotes(fact.getNotes());
                studentReadingHistoryDataDTOS.add(studentReadingHistoryDataDTO);
            }
            studentReadingHistoryDataDTOPage = new Page<StudentReadingHistoryDataDTO>() {
                @Override
                public int getTotalPages() {
                    return studentReadingHistoryEntityList.getTotalPages();
                }

                @Override
                public long getTotalElements() {
                    return studentReadingHistoryEntityList.getTotalElements();
                }

                @Override
                public <U> Page<U> map(Function<? super StudentReadingHistoryDataDTO, ? extends U> function) {
                    return null;
                }

                @Override
                public int getNumber() {
                    return studentReadingHistoryEntityList.getNumber();
                }

                @Override
                public int getSize() {
                    return studentReadingHistoryEntityList.getSize();
                }

                @Override
                public int getNumberOfElements() {
                    return studentReadingHistoryEntityList.getNumberOfElements();
                }

                @Override
                public List<StudentReadingHistoryDataDTO> getContent() {
                    return studentReadingHistoryDataDTOS;
                }

                @Override
                public boolean hasContent() {
                    return studentReadingHistoryEntityList.hasContent();
                }

                @Override
                public Sort getSort() {
                    return studentReadingHistoryEntityList.getSort();
                }

                @Override
                public boolean isFirst() {
                    return studentReadingHistoryEntityList.isFirst();
                }

                @Override
                public boolean isLast() {
                    return studentReadingHistoryEntityList.isLast();
                }

                @Override
                public boolean hasNext() {
                    return studentReadingHistoryEntityList.hasNext();
                }

                @Override
                public boolean hasPrevious() {
                    return studentReadingHistoryEntityList.hasPrevious();
                }

                @Override
                public Pageable nextPageable() {
                    return studentReadingHistoryEntityList.nextPageable();
                }

                @Override
                public Pageable previousPageable() {
                    return studentReadingHistoryEntityList.previousPageable();
                }

                @Override
                public Iterator<StudentReadingHistoryDataDTO> iterator() {
                    return null;
                }
            };
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return studentReadingHistoryDataDTOPage;
    }
}
