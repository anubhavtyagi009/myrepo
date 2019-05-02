package com.impelsys.microservice.service.utility;

public final class ServiceConstants {
    //proficiency constants
    public static final String PROFICIENCY_INDEPENDENT = "INDEPENDENT";
    public static final String PROFICIENCY_INSTRUCTIONAL = "INSTRUCTIONAL";
    public static final String PROFICIENCY_FRUSTRATIONAL = "FRUSTRATIONAL";
    //read type constants
    public static final String READTYPE_SEEN = "SEEN";
    public static final String READTYPE_UNSEEN = "UNSEEN";
    //language constants
    public static final String LANGUAGE_ENGLISH = "ENGLISH";
    public static final String LANGUAGE_SPANISH = "SPANISH";
    //category constants
    public static final String CATEGORY_FICTION = "FICTION";
    public static final String CATEGORY_NONFICTION = "NONFICTION";
    //join table constants
    public static final String JOIN_DimStudentEntity = "dimStudentByDimStudentId";
    public static final String JOIN_DimAssignmentCreatorEntity = "dimAssignmentCreatorByDimAssignmentCreatorId";
    public static final String JOIN_DimAssessmentTestEntity = "dimAssessmentTestByDimAssessmentTestId";
    //table attribute constants
    public static final String DimStudentEntity_STUDENTID = "studentId";
    public static final String DimStudentEntity_GRADE = "grade";
    public static final String DimAssessmentTestEntity_AssessmentTestId = "assessmentTestId";
    public static final String DimAssessmentTestEntity_Language = "language";
    public static final String DimAssessmentTestEntity_Category = "category";
    public static final String FactOrrAssignmentNoAggEntity_Proficiency = "proficiency";
    public static final String FactOrrAssignmentNoAggEntity_ReadType = "readType";
    public static final String FactOrrAssignmentNoAggEntity_AssignmentCompletionDate = "assignmentCompletionDate";
    public static final String DimAssignmentCreatorEntity_TeacherId = "sourceAssignmentCreatorId";
}
