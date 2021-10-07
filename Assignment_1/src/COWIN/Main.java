package COWIN;

import java.util.*;

class User {
    private String userName;
    private String uniqueID_User;
    private int age;
    private String status;

    User(String name, String ID, int age) {
        if (age < 18) {
            System.out.println("Sorry, only people above 18 years age are allowed to register ");
        } else {
            this.userName = name;
            this.age = age;
            this.uniqueID_User = ID;
            this.status = "Registered";
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return uniqueID_User;
    }

    public int getPatientAge() {
        return age;
    }

    void displayUserDetails() {
        System.out.println("your registered name is " + userName);
        System.out.println("Your registered 12 Digit ID is " + uniqueID_User);
        System.out.println("Your registered age is " + age);
        System.out.println("Your are " + status);
    }


}

class Hospital {
    private String HospitalName;
    private int pincode;
    private String hospitalUnique_ID;

    Hospital(String HospitalName, int Pincode, int count) {
        if (Integer.toString(Pincode).length() != 6) {
            System.out.println("You have entered an invalid pincode");
        } else {
            this.HospitalName = HospitalName;
            this.pincode = Pincode;
            this.hospitalUnique_ID = String.format("%06d", count);
        }
    }

    public int getPincode() {
        return pincode;
    }

    public String getHospitalUnique_ID() {
        return hospitalUnique_ID;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void displayHospitalDetails() {
        System.out.println("Hospital Name registered by you is " + HospitalName);
        System.out.println("Hospital Pincode registered by you is " + pincode);
        System.out.println("The unique 6 digit Hospital ID allotted to you is " + hospitalUnique_ID);
    }

}

class vaccine {
    private final String vaccineName;
    private final int doseRequired;
    private final int gapRequired;

    vaccine(String vaccineName, int doseRequired, int gapRequired) {
        this.vaccineName = vaccineName;
        this.doseRequired = doseRequired;
        this.gapRequired = gapRequired;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public int getDoseRequired() {
        return doseRequired;
    }

    public int getGapRequired() {
        return gapRequired;
    }

    public void displayVaccine() {
        System.out.println("Name of vaccine registered by you is " + vaccineName);
        System.out.println("Number of doses of vaccine required is " + doseRequired);
        System.out.println("Number of days of gap between doses is " + gapRequired);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

    }
}
