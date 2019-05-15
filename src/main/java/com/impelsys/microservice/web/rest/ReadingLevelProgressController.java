package com.impelsys.microservice.web.rest;

import com.impelsys.microservice.domain.*;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.impelsys.microservice.service.getreadinglevelprogressdata.GetReadingLevelProgressDataResponse;
import com.impelsys.microservice.service.getreadinglevelprogressdata.GetReadingLevelProgressDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ReadingLevelProgressController {


    private final static Logger log = LoggerFactory.getLogger(ReadingLevelProgressController.class);

    @Autowired
    private GetReadingLevelProgressDataService getReadingLevelProgressDataService;


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/getReadingLevelProgressData1", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReadingLevelProgressData1(@RequestBody RplSearchCriteriaDto
                                                                     rplSearchCriteriaDto,
                                                         HttpServletRequest request){

        GetReadingLevelProgressDataResponse response = getReadingLevelProgressDataService.execute(null);

   // ResponseData responseData = new ResponseData(response);

     return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/readingLevelProgressData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReadingLevelProgressData(@RequestBody RplSearchCriteriaDto rplSearchCriteriaDto, HttpServletRequest request)

            throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(rplSearchCriteriaDto.getFilters().getExternalfilter()));

        List readingLevelaxisList = Arrays.asList(
                new ReadingLevelaxis("Pre-A", "#F6F5F7", "#D5D8E5"),
                new ReadingLevelaxis("A", "#F6F5F7", "#D5D8E5"),
                new ReadingLevelaxis("B", "#F6F5F7", "#D5D8E5"),
                new ReadingLevelaxis("C", "#F6F5F7", "#D5D8E5")
        );

        List dateRangeaxisList = Arrays.asList(
                new DateRangeaxis("08/09/18T12:00"),
                new DateRangeaxis("09/09/18T12:00"),
                new DateRangeaxis("10/09/18T12:00"),
                new DateRangeaxis("11/09/18T12:00"),
                new DateRangeaxis("12/09/18T12:00")
        );

        List fluencyaxisList = Arrays.asList(
                new Fluencyaxis("10"),
                new Fluencyaxis("20"),
                new Fluencyaxis("30"),
                new Fluencyaxis("40"),
                new Fluencyaxis("50"),
                new Fluencyaxis("60")
        );

        List accuracyaxisList = Arrays.asList(
                new Accuracyaxis("10"),
                new Accuracyaxis("20"),
                new Accuracyaxis("30"),
                new Accuracyaxis("40"),
                new Accuracyaxis("50"),
                new Accuracyaxis("60")
        );

        List assignmentdataList = Arrays.asList(
                new AssignmentData("Starting Level","", "Pre-A", 0,0,"","","#FFFFFF", true, false),
                new AssignmentData("","08/09/18T12:00", "A", 40,80,"Instructional","1","#FFFFFF", true, false),
                new AssignmentData("","09/09/18T12:00", "B", 50,90,"Frustrational","1","#FFFFFF", true, false),
                new AssignmentData("Reading Target","", "E", 0,0,"","","#FFFFFF", false, true)
        );

        List fluencyList = Arrays.asList(
                new FluencyData("Starting Level", "","Pre-A", 0,"#FFFFFF", true, false),
                new FluencyData("", "08/09/18T12:00","A", 50,"#FFFFFF", false, false),
                new FluencyData("", "09/09/18T12:00","B", 70,"#FFFFFF", false, false),
                new FluencyData("Reading Target", "","E", 0,"#FFFFFF", false, true)

        );

        List accuracyList = Arrays.asList(
                new AccuracyData("Starting Level", "","Pre-A", 0,"#FFFFFF", true, false),
                new AccuracyData("", "08/09/18T12:00","A", 50,"#FFFFFF", false, false),
                new AccuracyData("", "09/09/18T12:00","B", 70,"#FFFFFF", false, false),
                new AccuracyData("Reading Target", "","E", 0,"#FFFFFF", false, true)

        );

        RplResponsedataDto rplResponsedataDto = new RplResponsedataDto(rplSearchCriteriaDto.getFilters().getInternalfilter(), rplSearchCriteriaDto.getFilters().getExternalfilter(),readingLevelaxisList, dateRangeaxisList, fluencyaxisList, accuracyaxisList, assignmentdataList,fluencyList, accuracyList);

        ResponseData responseData = new ResponseData(rplResponsedataDto);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
