package Backpack;

import java.util.ArrayList;
import java.util.Scanner;

public class backpackManager {
    Scanner scn = new Scanner(System.in);
    private final ArrayList<Student> studentArrayList;
    private final ArrayList<Instructor> instructorArrayList;
    private final ArrayList<Material> materialArrayList;
    private final ArrayList<Discussion> discussionArrayList;
    private final ArrayList<Assignment> assignmentArrayList;

    backpackManager() {
        this.studentArrayList = new ArrayList<>();
        this.instructorArrayList = new ArrayList<>();
        this.materialArrayList = new ArrayList<>();
        this.discussionArrayList = new ArrayList<>();
        this.assignmentArrayList = new ArrayList<>();
    }


    // Methods related to Student are here
    void addStudent(String name, String ID) {
        studentArrayList.add(new Student(name, ID));
    }

    void displayStudentList() {
        int counter = 0;
        for (Student s : studentArrayList) {
            System.out.println("Student " + counter + " --> " + s.getStudentName());
            counter++;
        }
    }

    void displayInstructorList() {
        int counter = 0;
        for (Instructor s : instructorArrayList) {
            System.out.println("Instructor " + counter + " --> " + s.getInstructorName());
            counter++;
        }
    }


    // Methods Related to Instructor are here.
    void addInstructor(String name, String ID) {
        instructorArrayList.add(new Instructor(name, ID));
    }


    // Methods related to Material are here.
    void addMaterialSlides(String slideTopic, int numberOfSlides, Instructor i) {
        materialArrayList.add(new Material(slideTopic, numberOfSlides, i.getInstructorName()));
    }

    void addMaterialVideo(String videoTopic, String videoFile, Instructor i) {
        String fileExt = videoFile.substring(videoFile.length() - 4, videoFile.length());
        if (!fileExt.equals(".mp4")) {
            System.out.println("Please enter a valid file and try again");
            return;
        }
        materialArrayList.add(new Material(videoTopic, videoFile, i.getInstructorName()));
    }

    void viewMaterial() {
        int counter = 1;
        for (Material m : materialArrayList) {
            System.out.println("Material " + counter);
            m.viewLectureMaterial();
            counter++;
        }
    }

    void viewMaterialByInstructor(String instructorName) {
        int counter = 1;
        boolean notFoundFlag = true;
        for (Material m : materialArrayList) {
            if (m.getInstructorName().equals(instructorName)) {
                System.out.println("Material " + counter);
                m.viewLectureMaterial();
                counter++;
                notFoundFlag = false;
            }
        }
        if (notFoundFlag) {
            System.out.println("You have not added any material");
        }
    }

    // Methods Related to Discussion Forum are here.
    void addComment(String name, String comment) {
        discussionArrayList.add(new Discussion(name, comment));
    }

    void viewComments() {
        for (Discussion d : discussionArrayList) {
            d.displayComment();
        }
    }

    // Methods related to Assignments are here.
    void addAssignment(String problem, int maxMarks, String instructorName) {
        assignmentArrayList.add(new Assignment(problem, maxMarks, instructorName, studentArrayList));
    }

    void addQuiz(String problem, String instructorName) {
        assignmentArrayList.add(new Assignment(problem, instructorName, studentArrayList));
    }

    void viewAssignmentInstructor(String instructorName) {
        int counter = 1;
        boolean notFoundFlag = true;
        for (Assignment a : assignmentArrayList) {
            if (instructorName.equals(a.getInstructorName())) {
                a.viewAssignmentInstructor(counter);
                counter++;
                notFoundFlag = false;
            }
        }
        if (notFoundFlag) {
            System.out.println("You have given no assignment");
        }
    }

    void viewPendingAssignmentStudent(String studentName) {
        int counter = 1;
        boolean notFoundFlag = true;
        for (Assignment a : assignmentArrayList) {
            for (Assignment.studentForAssignment s : a.getStudentListForAssignment()) {
                if ((s.getStudentName().equals(studentName)) && !s.getCompletionStatus() && a.getAssignOpenStatus()) {
                    a.viewAssignment(counter);
                    counter++;
                    notFoundFlag = false;

                }
            }

        }
        if (notFoundFlag) {
            System.out.println("You have no pending assignments");
        }
    }

    void submitPendingAssignment(String studentName) {
        int counter = 0;
        boolean notFoundFlag = true;
        for (Assignment a : assignmentArrayList) {
            for (Assignment.studentForAssignment s : a.getStudentListForAssignment()) {
                if ((s.getStudentName().equals(studentName)) && !s.getCompletionStatus() && a.getAssignOpenStatus()) {
                    a.viewAssignment(counter);
                    notFoundFlag = false;

                }
            }
            counter++;
        }
        if (notFoundFlag) {
            System.out.println("You have no pending assignments");
        } else {
            System.out.println("Choose option to submit assignment");
            int chosenOption = scn.nextInt();
            scn.nextLine();
            Assignment chosenAssignment = assignmentArrayList.get(chosenOption);
            for (Assignment.studentForAssignment s : chosenAssignment.getStudentListForAssignment()) {
                if ((s.getStudentName().equals(studentName))) {
                    if (chosenAssignment.getProblemType().equals("quiz")) {
                        System.out.println("Enter your response to quiz");
                        String quizAns = scn.nextLine();
                        s.setQuizAns(quizAns);
                        s.setCompletionStatus();
                    } else {
                        System.out.println("Enter the filename to submit assignment");
                        String fileName = scn.nextLine();
                        String fileExt = fileName.substring(fileName.length() - 4, fileName.length());
                        if (!fileExt.equals(".zip")) {
                            System.out.println("Please enter a valid file and try again");
                            return;
                        } else {
                            s.setSubmitFileName(fileName);
                            s.setCompletionStatus();
                        }
                    }

                }
            }
        }
    }

    public void gradeAssignment(String instructorName) {
        int counter = 0;
        boolean notFoundFlag = true;
        for (Assignment a : assignmentArrayList) {
            a.viewAssignmentInstructor(counter);
            notFoundFlag = false;
            counter++;
        }
        if (notFoundFlag) {
            System.out.println("You have no assignment to grade");
        } else {
            System.out.println("Select the assignment to grade");
            int chosenOption = scn.nextInt();
            Assignment chosenAssignment = assignmentArrayList.get(chosenOption);
            notFoundFlag = true;
            counter = 0;
            for (Assignment.studentForAssignment s : chosenAssignment.getStudentListForAssignment()) {
                if (!s.isHasBeenGraded() && s.getCompletionStatus()) {
                    System.out.println("option " + counter + " -> " + s.getStudentName());
                    notFoundFlag = false;
                }
                counter++;
            }
            if (notFoundFlag) {
                System.out.println("There are no ungraded submissions");
            } else {
                System.out.println("Choose the ID of ungraded submissions");
                int chosenStudentOption = scn.nextInt();
                Assignment.studentForAssignment chosenStudent = chosenAssignment.getStudentListForAssignment().get(chosenStudentOption);
                String assignmentType = chosenAssignment.getProblemType();
                chosenStudent.setHasBeenGraded(true);
                chosenStudent.setGradingInstructor(instructorName);
                if (assignmentType.equals("assignment")) {
                    System.out.println("Max marks are " + chosenAssignment.getMaxMarks());
                    System.out.println("Submitted assignment " + chosenStudent.getSubmitFileName());
                    System.out.println("Enter the marks you want to give");
                    int marksGiven = scn.nextInt();
                    chosenStudent.setMarksReceived(marksGiven);
                } else {
                    System.out.println("Submitted Ans " + chosenStudent.getQuizAns());
                    System.out.println("true for correct ans and false otherwise");
                    boolean quizGrade = scn.nextBoolean();
                    if (quizGrade) {
                        chosenStudent.setMarksReceived(1);
                    }
                }
            }
        }

    }

    public void viewGrade(String studentName) {
        ArrayList<Assignment.studentForAssignment> gradedList = new ArrayList<>();
        ArrayList<Assignment.studentForAssignment> ungradedList = new ArrayList<>();

        for (Assignment a : assignmentArrayList) {
            for (Assignment.studentForAssignment s : a.getStudentListForAssignment()) {
                if (s.getStudentName().equals(studentName) && s.getCompletionStatus() && s.isHasBeenGraded()) {
                    gradedList.add(s);
                } else if (s.getStudentName().equals(studentName) && s.getCompletionStatus() && !s.isHasBeenGraded()) {
                    ungradedList.add(s);
                }
            }
        }
        if (ungradedList.size() == 0 && gradedList.size() == 0) {
            System.out.println("All your submissions have been graded");
        } else if (ungradedList.size() == 0) {
            System.out.println("There are no Ungraded Submissions");
            gradedAssignment(gradedList);
        } else if (gradedList.size() == 0) {
            System.out.println("There are no Graded Submissions");
            ungradedAssignment(ungradedList);
        } else {
            gradedAssignment(gradedList);
            ungradedAssignment(ungradedList);
        }
    }

    private void ungradedAssignment(ArrayList<Assignment.studentForAssignment> ungradedList) {
        System.out.println("Ungraded Submissions");
        for (Assignment.studentForAssignment s : ungradedList) {
            String assignType = s.getAssignType();
            if (assignType.equals("assignment")) {
                System.out.println("Submission file name ---> " + s.getSubmitFileName());
                System.out.println("Not yet Graded");
            } else {
                System.out.println("quiz " + s.getQuizQuestion());
                System.out.println("Not yet graded");
            }
        }
    }

    private void gradedAssignment(ArrayList<Assignment.studentForAssignment> gradedList) {
        System.out.println("Graded Submissions");
        for (Assignment.studentForAssignment s : gradedList) {
            String assignType = s.getAssignType();
            if (assignType.equals("assignment")) {
                System.out.println("Submission file name ---> " + s.getSubmitFileName());
                System.out.println("You have been given " + s.getMarksReceived() + " Marks out of " + s.getMaxMarks() + " Marks");
                System.out.println("Graded By --> " + s.getGradingInstructor());
            } else {
                System.out.println("quiz --> " + s.getQuizQuestion());
                System.out.println("You have been given " + s.getMarksReceived() + " Mark out of 1 Mark");
                System.out.println("Graded By --> " + s.getGradingInstructor());

            }
        }
    }

    public void closeAssignment() {
        int counter = 0;
        boolean notFoundFlag = true;
        for (Assignment a : assignmentArrayList) {
            if (a.getAssignOpenStatus()) {
                a.viewAssignmentInstructor(counter);
                notFoundFlag = false;
            }
            counter++;
        }
        if (notFoundFlag) {
            System.out.println("You have no open assignment to close");
        } else {
            System.out.println("Select the assignment to close");
            int chosenOption = scn.nextInt();
            assignmentArrayList.get(chosenOption).setAssignOpenStatus(false);
        }
    }


    // getter methods are here for encapsulation

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public ArrayList<Instructor> getInstructorArrayList() {
        return instructorArrayList;
    }

    public ArrayList<Material> getMaterialArrayList() {
        return materialArrayList;
    }

    public ArrayList<Discussion> getDiscussionArrayList() {
        return discussionArrayList;
    }

    public ArrayList<Assignment> getAssignmentArrayList() {
        return assignmentArrayList;
    }
}
