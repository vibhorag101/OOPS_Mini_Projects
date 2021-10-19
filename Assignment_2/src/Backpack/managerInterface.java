package Backpack;

public interface managerInterface {
    void addStudent(String name, String ID);
    void displayStudentList();
    void displayInstructorList();
    void addInstructor(String name, String ID);
    void addMaterialSlides(String slideTopic, int numberOfSlides, Instructor i);
    void addMaterialVideo(String videoTopic, String videoFile, Instructor i);
    void viewMaterial();
    void viewMaterialByInstructor(String instructorName);
    void addComment(String name, String comment);
    void viewComments();
    void addAssignment(String problem, int maxMarks, String instructorName);
    void addQuiz(String problem, String instructorName);
    void viewAssignmentInstructor(String instructorName);
    void viewPendingAssignmentStudent(String studentName);
    void submitPendingAssignment(String studentName);
    void gradeAssignment(String instructorName);
    void viewGrade(String studentName);
    void closeAssignment();
}
