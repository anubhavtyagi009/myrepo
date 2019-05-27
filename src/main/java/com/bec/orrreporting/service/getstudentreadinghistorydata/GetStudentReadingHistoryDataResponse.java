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

import com.bec.orrreporting.dto.StudentReadingHistoryDataDTO;
import com.bec.orrreporting.dto.StudentReadingLevelDTO;
import com.bec.orrreporting.service.CommonServiceResponse;

import java.util.List;

public class GetStudentReadingHistoryDataResponse extends CommonServiceResponse {

    private List<StudentReadingHistoryDataDTO> studentReadingHistoryData;
    private StudentReadingLevelDTO studentReadingLevel;

    public GetStudentReadingHistoryDataResponse(List<StudentReadingHistoryDataDTO> studentReadingHistoryData, StudentReadingLevelDTO studentReadingLevel) {
        this.studentReadingHistoryData = studentReadingHistoryData;
        this.studentReadingLevel = studentReadingLevel;
    }

    public GetStudentReadingHistoryDataResponse() {
    }

    public List<StudentReadingHistoryDataDTO> getStudentReadingHistoryData() {
        return studentReadingHistoryData;
    }

    public void setStudentReadingHistoryData(List<StudentReadingHistoryDataDTO> studentReadingHistoryData) {
        this.studentReadingHistoryData = studentReadingHistoryData;
    }

    public StudentReadingLevelDTO getStudentReadingLevel() {
        return studentReadingLevel;
    }

    public void setStudentReadingLevel(StudentReadingLevelDTO studentReadingLevel) {
        this.studentReadingLevel = studentReadingLevel;
    }
}
