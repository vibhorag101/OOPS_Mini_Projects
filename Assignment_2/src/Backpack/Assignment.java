package Backpack;

import java.util.ArrayList;

public class Assignment {
    private String problemType;
    private String assignProblemStatement;
    private String quizProblemStatement;
    private int maxMarks;
    private boolean assignOpenStatus;
    private String instructorName;
    private ArrayList<studentForAssignment> studentListForAssignment;

    public ArrayList<studentForAssignment> getStudentListForAssignment() {
        return studentListForAssignment;
    }

    public String getInstructorName() {
        return instructorName;
    }

    class studentForAssignment extends Student {
        private boolean completionStatus;
        private int marksReceived;
        private String submitFileName;

        studentForAssignment(String studentName, String studentID) {
            super(studentName, studentID);
            completionStatus = false;
            this.marksReceived = -1;
        }

        public boolean getCompletionStatus() {
            return completionStatus;
        }

        public int getMarksReceived() {
            return marksReceived;
        }

        public String getSubmitFileName() {
            return submitFileName;
        }
    }


    // constructor for Assignment Type Problem
    Assignment(String assignProblemStatement, int maxMarks, String instructorName, ArrayList<Student> studentList) {
        this.assignProblemStatement = assignProblemStatement;
        this.maxMarks = maxMarks;
        this.problemType = "assignment";
        this.assignOpenStatus = true;
        this.instructorName = instructorName;
        addStudentsToList(studentList);
    }

    // constructor for Quiz Type Problem
    Assignment(String quizProblemStatement, String instructorName, ArrayList<Student> studentList) {
        this.quizProblemStatement = quizProblemStatement;
        this.problemType = "quiz";
        this.instructorName = instructorName;
        addStudentsToList(studentList);
    }

    private void addStudentsToList(ArrayList<Student> studentList) {
        for (Student s : studentList) {
            studentListForAssignment.add(new studentForAssignment(s.getStudentName(), s.getStudentID()));
        }
    }

    public void viewAssignment(int counter) {
        if (problemType.equals("assignment")) {
            System.out.println("ID " + counter + " Assignment : " + assignProblemStatement + " Max Marks " + maxMarks);
        } else {
            System.out.println("ID " + counter + " Question : " + quizProblemStatement);
        }
    }

    public void viewAssignmentInstructor(int counter) {
        if (problemType.equals("assignment")) {
            System.out.println("ID " + counter + " Assignment : " + assignProblemStatement + " Max Marks " + maxMarks + " Open Status " + getAssignOpenStatus());
        } else {
            System.out.println("ID " + counter + " Question : " + quizProblemStatement + " Open Status " + getAssignOpenStatus());
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

    public boolean getAssignOpenStatus() {
        return assignOpenStatus;
    }

}
