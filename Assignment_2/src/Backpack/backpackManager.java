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


    // Methods Related to Instructor are here.
    void addInstructor(String name, String ID) {
        instructorArrayList.add(new Instructor(name, ID));
    }


    // Methods related to Material are here.
    void addMaterialSlides(String slideTopic, int numberOfSlides, Instructor i) {
        materialArrayList.add(new Material(slideTopic, numberOfSlides, i.getName()));
    }

    void addMaterialVideo(String videoTopic, String videoFile) {
        materialArrayList.add(new Material(videoTopic, videoFile));
    }

    void viewMaterial() {
        int counter = 1;
        for (Material m : materialArrayList) {
            System.out.println("Material " + counter);
            m.viewLectureMaterialTopic();
            counter++;
        }
        System.out.println("Choose material you want to view");
        int chosen = scn.nextInt();
        materialArrayList.get(counter - 1).viewLectureMaterial();
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
    void addAssignment(String problem, int maxMarks,String instructorName) {
        assignmentArrayList.add(new Assignment(problem, maxMarks,instructorName ,studentArrayList));
    }

    void addQuiz(String problem,String instructorName) {
        assignmentArrayList.add(new Assignment(problem,instructorName, studentArrayList));
    }

    void viewAssignmentInstructor(String instructorName){
        int counter = 1;
        boolean notFoundFlag = true;
        for (Assignment a : assignmentArrayList) {
            if (instructorName.equals(a.getInstructorName())){
                a.viewAssignmentInstructor(counter);
                counter++;
                notFoundFlag= false;
            }
        }
        if (notFoundFlag){
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
                    notFoundFlag= false;

                }
            }

        }
        if (notFoundFlag){
            System.out.println("You have no pending assignments");
        }
    }

    void submitPendingAssignment(String studentName){

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
