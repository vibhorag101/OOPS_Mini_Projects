package Backpack;

public class Assignment {
    private String problemType;
    private String assignProblemStatement;
    private String quizProblemStatement;
    private int maxMarks;

    Assignment(String assignProblemStatement, int maxMarks) {
        this.assignProblemStatement = assignProblemStatement;
        this.maxMarks = maxMarks;
        this.problemType = "assignment";
    }

    Assignment(String quizProblemStatement) {
        this.quizProblemStatement = quizProblemStatement;
        this.problemType = "quiz";
    }

}
