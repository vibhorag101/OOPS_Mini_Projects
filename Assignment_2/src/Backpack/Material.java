package Backpack;

import java.util.ArrayList;
import java.util.Scanner;

public class Material {
    Scanner scn = new Scanner(System.in);
    private String materialType;
    private String slideTopic;
    private int numberOfSlides;
    private ArrayList<String> slideContent;
    private String videoTopic;
    private String videoFileName;

    Material(String slideTopic, int numberOfSlides) {
        this.slideTopic = slideTopic;
        this.numberOfSlides = numberOfSlides;
        this.materialType = "slides";
        this.slideContent = new ArrayList<>();
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
}
