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
package com.bec.orrreporting.service.getdimensioninsertionkey;

import com.bec.orrreporting.service.CommonServiceResponse;

public class GetDimensionInsertionKeyResponse extends CommonServiceResponse {
    private long classKey;
    private long studentKey;
    private long schoolKey;
    private long teacherKey;
    private long districtKey;

    public long getClassKey() {
        return classKey;
    }

    public void setClassKey(long classKey) {
        this.classKey = classKey;
    }

    public long getStudentKey() {
        return studentKey;
    }

    public void setStudentKey(long studentKey) {
        this.studentKey = studentKey;
    }

    public long getSchoolKey() {
        return schoolKey;
    }

    public void setSchoolKey(long schoolKey) {
        this.schoolKey = schoolKey;
    }

    public long getTeacherKey() {
        return teacherKey;
    }

    public void setTeacherKey(long teacherKey) {
        this.teacherKey = teacherKey;
    }

    public long getDistrictKey() {
        return districtKey;
    }

    public void setDistrictKey(long districtKey) {
        this.districtKey = districtKey;
    }
}
