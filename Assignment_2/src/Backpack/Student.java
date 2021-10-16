package Backpack;

public class Student {
    private final String studentName;
    private final String studentID;

    Student(String studentName, String studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }
}
