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

    Material(String slideTopic, int numberOfSlides, String instructor) {
        this.slideTopic = slideTopic;
        this.numberOfSlides = numberOfSlides;
        this.materialType = "slides";
        this.slideContent = new ArrayList<>();
        this.instructor = instructor;
        this.materialTime = getTime();
        for (int i = 0; i < numberOfSlides; i++) {
            System.out.println("Enter the content for slide " + (i + 1));
            String temp = scn.next();
            slideContent.add(temp);
        }
    }

    Material(String videoTopic, String videoFileName) {
        this.videoTopic = videoTopic;
        this.videoFileName = videoFileName;
    }

    void viewLectureMaterial() {
        if (materialType.equals("slides")) {
            System.out.println("Lecture Slides By -> " + instructor);
            System.out.println("Lecture Slide Topic -> " + slideTopic);
            int counter = 1;
            for (String s : slideContent) {
                System.out.println("Slide " + counter);
                System.out.println(s);
            }
        } else {
            System.out.println("Lecture Video By -> " + instructor);
            System.out.println("Lecture Video Topic -> " + videoTopic);
        }
    }

    void viewLectureMaterialTopic() {
        if (materialType.equals("slides")) {
            System.out.println("Lecture Slides By -> " + instructor);
            System.out.println("Lecture Slide Topic -> " + slideTopic);

        } else {
            System.out.println("Lecture Video By -> " + instructor);
            System.out.println("Lecture Video Topic -> " + videoTopic);
        }
    }

    public static String getTime() {
        return new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
    }
}
