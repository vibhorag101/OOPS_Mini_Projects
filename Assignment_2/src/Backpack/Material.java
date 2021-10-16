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

    Material(String slideTopic, int numberOfSlides) {
        this.slideTopic = slideTopic;
        this.numberOfSlides = numberOfSlides;
        this.materialType = "slides";
        this.slideContent = new ArrayList<>();
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

    public static String getTime() {
        return new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
    }

    public String getSlideTopic() {
        return slideTopic;
    }

    public String getMaterialType() {
        return materialType;
    }

    public int getNumberOfSlides() {
        return numberOfSlides;
    }

    public String getVideoTopic() {
        return videoTopic;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

    public String getMaterialTime() {
        return materialTime;
    }
    public ArrayList<String> getSlideContent(){
        return slideContent;
    }
}
