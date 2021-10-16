package Backpack;

import java.util.ArrayList;

public class Assignment {
    private String problemType;
    private String assignProblemStatement;
    private String quizProblemStatement;
    private int maxMarks;
    private String assignOpenStatus;

    private class studentAssign extends Student {
        String completionStatus;
        int marksReceived = -1;
        studentAssign(String studentName, String studentID) {
            super(studentName, studentID);
            completionStatus = "False";
        }

    }

    private ArrayList<studentAssign> studentListForAssignment;
    // constructor for Assignment Type Problem
    Assignment(String assignProblemStatement, int maxMarks , ArrayList<Student> studentList) {
        this.assignProblemStatement = assignProblemStatement;
        this.maxMarks = maxMarks;
        this.problemType = "assignment";
        this.assignOpenStatus = "open";
        addStudentsToList(studentList);
    }

    // constructor for Quiz Type Problem
    Assignment(String quizProblemStatement, ArrayList<Student> studentList) {
        this.quizProblemStatement = quizProblemStatement;
        this.problemType = "quiz";
        addStudentsToList(studentList);
    }

    private void addStudentsToList(ArrayList<Student> studentList){
        for (Student s : studentList){
            studentListForAssignment.add(new studentAssign(s.getStudentName(),s.getStudentID()));
        }
    }

    public String getProblemType() {
        return problemType;
    }

    public String getAssignProblemStatement() {
        return assignProblemStatement;
    }

    public void setAssignProblemStatement(String assignProblemStatement) {
        this.assignProblemStatement = assignProblemStatement;
    }

    public String getQuizProblemStatement() {
        return quizProblemStatement;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public String getAssignOpenStatus() {
        return assignOpenStatus;
    }

    public void setAssignOpenStatus(String assignOpenStatus) {
        this.assignOpenStatus = assignOpenStatus;
    }
}
