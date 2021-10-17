package Backpack;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Material {
    Scanner scn = new Scanner(System.in);
    private String materialType;
    private String slideTopic;
    private int numberOfSlides;
    private ArrayList<String> slideContent;
    private String videoTopic;
    private String videoFileName;
    private String materialTime;
    private String instructor;

    // constructor for Material Slides
    Material(String slideTopic, int numberOfSlides, String instructor) {
        this.slideTopic = slideTopic;
        this.numberOfSlides = numberOfSlides;
        this.materialType = "slides";
        this.slideContent = new ArrayList<>();
        this.instructor = instructor;
        this.materialTime = getTime();
        for (int i = 0; i < numberOfSlides; i++) {
            System.out.println("Enter the content for slide " + (i + 1));
            String temp = scn.nextLine();
            slideContent.add(temp);
        }
    }

    // Constructor for lecture video
    Material(String videoTopic, String videoFileName, String instructor) {
        this.videoTopic = videoTopic;
        this.videoFileName = videoFileName;
        this.instructor = instructor;
        this.materialType = "video";
        this.materialTime = getTime();
    }

    void viewLectureMaterial() {
        if (materialType.equals("slides")) {
            System.out.println("Lecture Slides By -> " + instructor);
            System.out.println("Lecture Slide Topic -> " + slideTopic);
            System.out.println("Date of Upload : "+materialTime);
            int counter = 1;
            for (String s : slideContent) {
                System.out.println("Slide " + counter);
                System.out.println(s);
                counter++;
            }
        } else {
            System.out.println("Lecture Video By -> " + instructor);
            System.out.println("Lecture Video Topic -> " + videoTopic);
            System.out.println("Date of Upload : "+materialTime);
        }
    }

    void viewLectureMaterialTopic() {
        if (materialType.equals("slides")) {
            System.out.println("Lecture Slides By -> " + instructor);
            System.out.println("Lecture Slide Topic -> " + slideTopic);
            System.out.println("Date of Upload : "+materialTime);

        } else {
            System.out.println("Lecture Video By -> " + instructor);
            System.out.println("Lecture Video Topic -> " + videoTopic);
            System.out.println("Date of Upload : "+materialTime);
        }
    }

    public String getInstructorName() {
        return instructor;
    }

    public static String getTime() {
        return new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
    }
}
