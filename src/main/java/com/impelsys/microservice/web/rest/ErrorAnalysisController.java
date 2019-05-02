package com.impelsys.microservice.web.rest;

import com.impelsys.microservice.service.geterroranalysisdata.GetErrorAnalysisDataRequest;
import com.impelsys.microservice.service.geterroranalysisdata.GetErrorAnalysisDataResponse;
import com.impelsys.microservice.service.geterroranalysisdata.GetErrorAnalysisDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ErrorAnalysisController {
    private final static Logger log = LoggerFactory.getLogger(ErrorAnalysisController.class);

    @Autowired
    private GetErrorAnalysisDataService getErrorAnalysisDataService;

    // get error analysis data
    @PostMapping(value = "/errorAnalsysisData")
    public ResponseEntity getErrorAnalysisData(@RequestBody GetErrorAnalysisDataRequest request){
        log.debug("Fetching Error Analysis Chart Data");
        GetErrorAnalysisDataResponse response = null;
        try {
            response = getErrorAnalysisDataService.execute(request);
        }catch (Exception e){
            log.error("Error in fetching Error Analysis Chart Data :" + e.getMessage());
            response.SUCCESSFULL = false;
            response.setMessage("Error in fetching Error Analysis Chart Data :");
        }
       if (response.SUCCESSFULL)
           return ResponseEntity.ok().header(response.getMessage()).body(response);
       else
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(response.getMessage()).body(response);
    }

}
