package Backpack;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        backpackManager bM = new backpackManager();
        bM.addStudent("S0","2020349");
        bM.addStudent("S1","2020350");
        bM.addStudent("S2","2020351");
        bM.addInstructor("I0","2020120");
        bM.addInstructor("I1","2020121");
        while (true){
            System.out.println("Enter 1 for login as Instructor");
            System.out.println("Enter 2 for login as student");
            System.out.println("Enter 3 for exit");
            int loginChoice = scn.nextInt();
            if (loginChoice==1){
                System.out.println("You have logged in as Instructor");
                loginAsInstructor(bM);
            }
            else if(loginChoice ==2 ){
                System.out.println("You have logged in as a student");
                loginAsStudent(bM);
            }
            else if (loginChoice ==3 ){
                System.out.println("Thanks for using User BackPack");
                break;
            }
        }

    }
    static void loginAsStudent(backpackManager bM){
        Scanner scn = new Scanner(System.in);
        bM.displayStudentList();
        System.out.println("Enter your option of Student");
        int chosenOption = scn.nextInt();
        Student chosenStudent = bM.getStudentArrayList().get(chosenOption);
        String studentName = chosenStudent.getStudentName();
        System.out.println("Enter 1 to view lecture material");
        System.out.println("Enter 2 to view assignments");
        System.out.println("Enter 3 to submit assignments");
        System.out.println("Enter 4 to view grades");
        System.out.println("Enter 5 to view comments");
        System.out.println("Enter 6 to add comments");
        System.out.println("Enter 7 to logout");
        while (true){
            int chosenQuery = scn.nextInt();
            switch(chosenQuery){
                case 1 :
                    bM.viewMaterial();

                case 2:
                    bM.viewPendingAssignmentStudent(studentName);

                case 3:
                    bM.submitPendingAssignment(studentName);

                case 4:
                    bM.viewGrade(studentName);

                case 5:
                    bM.viewComments();

                case 6:
                    System.out.println("Enter the comments to be added");
                    String commentByStudent = scn.nextLine();
                    bM.addComment(studentName,commentByStudent);

                case 7:
                    return;
            }
        }
    }


    static void loginAsInstructor(backpackManager bM){
        Scanner scn = new Scanner(System.in);
        bM.displayInstructorList();
        System.out.println("Enter your option of Student");
        int chosenOption = scn.nextInt();
        Instructor chosenInstructor = bM.getInstructorArrayList().get(chosenOption);
        String instructorName = chosenInstructor.getInstructorName();
        System.out.println("Enter 1 to add lecture material");
        System.out.println("Enter 2 to add assignments");
        System.out.println("Enter 3 to view lecture material");
        System.out.println("Enter 4 to view assignments");
        System.out.println("Enter 5 to view grade assignments");
        System.out.println("Enter 6 to close assignment");
        System.out.println("Enter 7 to view comments");
        System.out.println("Enter 8 to view comments");
        System.out.println("Enter 9 to logout");
        while (true){
            int chosenQuery = scn.nextInt();
            switch(chosenQuery){
                case 1 :
                    System.out.println("Enter 1 to add lecture slides");
                    System.out.println("Enter 2 to add lecture video");
                    int chosenMaterial = scn.nextInt();
                    if (chosenMaterial==1){
                        System.out.println("Add slide topic");
                        String slideTopic = scn.nextLine();
                        System.out.println("Enter number of slides");
                        int numSlides = scn.nextInt();
                        bM.addMaterialSlides(slideTopic,numSlides,chosenInstructor);
                    }
                    else{
                        System.out.println("Add video topic");
                        String videoName = scn.nextLine();
                        System.out.println("Enter the video file name");
                        String videoFileName = scn.nextLine();
                        bM.addMaterialVideo(videoName,videoFileName);
                    }


                case 2:
                    System.out.println("Enter 1 for assignment");
                    System.out.println("Enter 2 for quiz");
                    int chosenPattern = scn.nextInt();
                    if (chosenPattern==1){
                        System.out.println("Add problem statement for assignment");
                        String assignmentProblem = scn.nextLine();
                        System.out.println("Enter Maximum marks for the assignments");
                        int maxMarks = scn.nextInt();
                        bM.addAssignment(assignmentProblem,maxMarks,instructorName);
                    }
                    else{
                        System.out.println("Enter quiz question");
                        String quizProblem = scn.next();
                        bM.addQuiz(quizProblem,instructorName);
                    }

                case 3:


                case 4:
                    bM.viewAssignmentInstructor(instructorName);

                case 5:
                    bM.gradeAssignment(instructorName);

                case 6:
                    bM.closeAssignment(instructorName);

                case 7:
                    bM.viewComments();

                case 8:
                    System.out.println("Enter the comments to be added");
                    String commentByStudent = scn.nextLine();
                    bM.addComment(instructorName,commentByStudent);


                case 9:
                    return;
            }
        }
    }
}
