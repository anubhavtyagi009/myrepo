package com.impelsys.microservice.repository;

import java.util.Date;
import java.util.List;

import com.impelsys.microservice.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface FactOrrAssignmentNoAggEntityRepository extends JpaRepository<FactOrrAssignmentNoAggEntity, Long> {

    @Query("select fact from FactOrrAssignmentNoAggEntity fact left join " +
            " fact.dimClassByDimClassId dc where dc.classId=?1 and fact.assignmentCompletionDate " +
            " between ?2 and ?3")
    Page<FactOrrAssignmentNoAggEntity> getClassLevelReadingHistoryData(Integer classId, Date startDate, Date endDate, Pageable pageable);

    @Query("select fact from FactOrrAssignmentNoAggEntity fact left join " +
            " fact.dimStudentByDimStudentId ds left join " +
            " fact.dimAssignmentCreatorByDimAssignmentCreatorId dac " +
            " where ds.studentId=?1 and ds.grade=?2 and dac.sourceAssignmentCreatorId=?3 and fact.assignmentCompletionDate  between ?4 and ?5")
    Page<FactOrrAssignmentNoAggEntity> getStudentLevelReadingHistoryData(Integer studentId, String studentGrade, Long teacherId, Date startDate, Date endDate, Pageable pageable);

}
