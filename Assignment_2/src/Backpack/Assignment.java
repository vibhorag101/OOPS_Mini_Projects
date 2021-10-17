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
        private boolean hasBeenGraded;
        private int marksReceived;
        private String submitFileName;
        private String quizAns;
        private String instructorName;
        private int maxMarks;
        private String assignType;
        private String quizQuestion;
        private String gradingInstructor;

        studentForAssignment(String studentName, String studentID) {
            super(studentName, studentID);
            completionStatus = false;
            this.marksReceived = 0;
            hasBeenGraded = false;
            this.instructorName = Assignment.this.instructorName;
            this.maxMarks = Assignment.this.maxMarks;
            this.assignType = problemType;
            this.quizQuestion = quizProblemStatement;
        }

        public void setCompletionStatus() {
            this.completionStatus = true;
        }

        public boolean getCompletionStatus() {
            return completionStatus;
        }


        public int getMarksReceived() {
            return marksReceived;
        }

        public void setMarksReceived(int marks) {
            this.marksReceived = marks;
        }

        public String getSubmitFileName() {
            return submitFileName;
        }

        public void setQuizAns(String quizAns) {
            this.quizAns = quizAns;
        }

        public String getQuizAns() {
            return quizAns;
        }

        public void setSubmitFileName(String submitFileName) {
            this.submitFileName = submitFileName;
        }

        public boolean isHasBeenGraded() {
            return hasBeenGraded;
        }

        public void setHasBeenGraded(boolean hasBeenGraded) {
            this.hasBeenGraded = hasBeenGraded;
        }


        public String getInstructorName() {
            return instructorName;
        }

        public int getMaxMarks() {
            return maxMarks;
        }

        public String getAssignType() {
            return assignType;
        }

        public String getQuizQuestion() {
            return quizQuestion;
        }

        public String getGradingInstructor() {
            return gradingInstructor;
        }

        public void setGradingInstructor(String gradingInstructor) {
            this.gradingInstructor = gradingInstructor;
        }
    }


    // constructor for Assignment Type Problem
    Assignment(String assignProblemStatement, int maxMarks, String instructorName, ArrayList<Student> studentList) {
        this.assignProblemStatement = assignProblemStatement;
        this.maxMarks = maxMarks;
        this.problemType = "assignment";
        this.assignOpenStatus = true;
        this.instructorName = instructorName;
        this.studentListForAssignment = new ArrayList<>();
        addStudentsToList(studentList);

    }

    // constructor for Quiz Type Problem
    Assignment(String quizProblemStatement, String instructorName, ArrayList<Student> studentList) {
        this.quizProblemStatement = quizProblemStatement;
        this.assignOpenStatus = true;
        this.problemType = "quiz";
        this.instructorName = instructorName;
        this.studentListForAssignment = new ArrayList<>();
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
            System.out.println("ID : " + counter + " | Assignment : " + assignProblemStatement + " Max Marks " + maxMarks + " Open Status ---> " + getAssignOpenStatus());
        } else {
            System.out.println("ID " + counter + " Question : " + quizProblemStatement + " Open Status ---> " + getAssignOpenStatus());
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

    public void setAssignOpenStatus(Boolean b) {
        this.assignOpenStatus = b;
    }

}
