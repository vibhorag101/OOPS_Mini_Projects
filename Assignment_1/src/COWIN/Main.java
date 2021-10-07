package COWIN;
import java.util.*;
import java.io.*;
class User {
    private String name;
    private String uniqueID_User;
    private int age;
    private String status;

    User(String name, String ID, int age) {
        if (age < 18) {
            System.out.println("Sorry, only people above 18 years age are allowed to register ");
        } else {
            this.name = name;
            this.age = age;
            this.uniqueID_User = ID;
            this.status = "Registered";
        }
    }

    public String getUserName() {
        return name;
    }

    public String getUserID() {
        return uniqueID_User;
    }

    public int getPatientAge() {
        return age;
    }

    void displayUserDetails() {
        System.out.println("your registered name is " + name);
        System.out.println("Your registered 12 Digit ID is " + uniqueID_User);
        System.out.println("Your registered age is " + age);
        System.out.println("Your are " + status);
    }


}

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

    }
}
