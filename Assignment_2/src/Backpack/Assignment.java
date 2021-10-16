package Backpack;

public class Assignment {
    private String problemType;
    private String assignProblemStatement;
    private String quizProblemStatement;
    private int maxMarks;
    private String assignOpenStatus;

    // constructor for Assignment Type Problem
    Assignment(String assignProblemStatement, int maxMarks) {
        this.assignProblemStatement = assignProblemStatement;
        this.maxMarks = maxMarks;
        this.problemType = "assignment";
        this.assignOpenStatus = "open";
    }

    // constructor for Quiz Type Problem
    Assignment(String quizProblemStatement) {
        this.quizProblemStatement = quizProblemStatement;
        this.problemType = "quiz";
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
