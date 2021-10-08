package COWIN;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HandlerClass hC = new HandlerClass();
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 for adding vaccine");
            System.out.println("Enter 2 for registering Hospital");
            System.out.println("Enter 3 for registering user");
            System.out.println("Enter 4 for adding slots");
            System.out.println("Enter 5 for booking vaccination slot");
            System.out.println("Enter 6 for Listing all slots in a Hospital");
            System.out.println("Enter 7 for Checking Vaccination Status");
            System.out.println("Enter 8 for exit");
            int chosenQuery = scn.nextInt();
            switch (chosenQuery) {
                case 1:
                    System.out.println("Enter the vaccine name");
                    String VaccineName = scn.next();
                    System.out.println("Enter the number of doses of vaccine required");
                    int doseReq = scn.nextInt();
                    System.out.println("Enter the number of days of gap between doses");
                    int gap = scn.nextInt();
                    hC.addVaccine(VaccineName, doseReq, gap);
                    break;

                case 2:
                    System.out.println("Enter the name of hospital to be registered");
                    String HospitalName = scn.next();
                    System.out.println("Enter the area pincode");
                    int Pincode = scn.nextInt();
                    hC.addHospital(HospitalName, Pincode);
                    break;

                case 3:
                    System.out.println("Enter Citizen Name");
                    String userName = scn.next();
                    System.out.println("Enter your age");
                    int age = scn.nextInt();
                    System.out.println("Enter your unique ID");
                    String userID = scn.next();
                    hC.addUser(userName, age, userID);
                    break;


                case 4:
                    System.out.println("Enter the Hospital ID for slot create");
                    String HospitalID = scn.next();
                    System.out.println("Enter the number of Days");
                    int dayNum = scn.nextInt();
                    hC.addSlot(HospitalID, dayNum,hC);
                    break;

                case 5:
                    System.out.println("Enter your unique user ID");
                    String id = scn.next();
                    hC.bookVaccineSlot(id);
                    break;

                case 8:
                    System.exit(0);


            }


        }
    }
}
