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
package com.bec.orrreporting.repository;

import com.bec.orrreporting.domain.DimAssignmentCreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DimAssignmentCreatorEntityRepository extends JpaRepository<DimAssignmentCreatorEntity, Long> {

    @Query("select teacher.sourceAssignmentCreatorId from DimAssignmentCreatorEntity teacher where teacher.sourceAssignmentCreatorId=?1 ")
    Long findByTeacherId(Long teacherId);

    @Query("select teacher from DimAssignmentCreatorEntity teacher where teacher.sourceAssignmentCreatorId=?1 ")
    DimAssignmentCreatorEntity findByAssignmentCreatorId(Long teacherId);
}
