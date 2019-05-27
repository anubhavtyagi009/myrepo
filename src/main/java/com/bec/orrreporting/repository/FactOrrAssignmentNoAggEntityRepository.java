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

import com.bec.orrreporting.domain.FactOrrAssignmentNoAggEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FactOrrAssignmentNoAggEntityRepository extends JpaRepository<FactOrrAssignmentNoAggEntity, Long> {

    @Query("select fact from FactOrrAssignmentNoAggEntity fact where fact.sourceAssignmentId=?1 and fact.deleteIndicator=0 order by fact.orrAssignmentId ASC")
    List<FactOrrAssignmentNoAggEntity> getOrrAssignmentRecordsByAssignmentId(Long assignmentId);

    @Transactional
    @Modifying
    @Query("update FactOrrAssignmentNoAggEntity set deleteIndicator=1, isLatest=0, recordModifiedDatetime=current_timestamp where orrAssignmentId IN ?1")
    Integer updateFactOrrAssignmentNoAggEntity(List<Long> orrAssignmentList);

}
