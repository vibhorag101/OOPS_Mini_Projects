package Backpack;

import java.util.ArrayList;

public interface assignmentInterface {
    ArrayList<Assignment.studentForAssignment> getStudentListForAssignment();
    String getInstructorName();
    void viewAssignment(int counter);
    void viewAssignmentInstructor(int counter);
    String getProblemType();
    String getAssignProblemStatement();
    String getQuizProblemStatement();
}
