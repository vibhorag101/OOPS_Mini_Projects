package COWIN;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HandlerClass hC = new HandlerClass();
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter 1 for adding vaccine");
        System.out.println("Enter 2 for registering Hospital");
        System.out.println("Enter 3 for registering user");
        System.out.println("Enter 4 for adding slots");
        System.out.println("Enter 5 for booking vaccination slot");
        System.out.println("Enter 6 for Listing all slots in a Hospital");
        System.out.println("Enter 7 for Checking Vaccination Status");
        System.out.println("Enter 8 for exit");
        while (true) {
            int chosenQuery = scn.nextInt();
            switch (chosenQuery) {
                case 1:
                    System.out.println("Enter the vaccine name");
                    String VaccineName = scn.next();
                    VaccineName += scn.nextLine();
                    System.out.println("Enter the number of doses of vaccine required");
                    int doseReq = scn.nextInt();
                    if(doseReq<=0){
                        System.out.println("Please add correct number of doses");
                        continue;
                    }
                    else if (doseReq <= 1) {
                        hC.addVaccine(VaccineName, doseReq, 0);
                    } else {
                        System.out.println("Enter the number of days of gap between doses");
                        int gap = scn.nextInt();
                        hC.addVaccine(VaccineName, doseReq, gap);
                    }

                    break;

                case 2:
                    System.out.println("Enter the name of hospital to be registered");
                    String HospitalName = scn.next();
                    HospitalName += scn.nextLine();
                    System.out.println("Enter the area pincode");
                    int Pincode = scn.nextInt();
                    hC.addHospital(HospitalName, Pincode);
                    break;

                case 3:
                    System.out.println("Enter Citizen Name");
                    String userName = scn.next();
                    userName += scn.nextLine();
                    System.out.println(userName);
                    System.out.println("Enter your age");
                    int age = scn.nextInt();
                    if (age < 18) {
                        System.out.println("Sorry below 18 years age are not allowed to register");
                        continue;
                    }
                    System.out.println("Enter your unique ID");
                    String userID = scn.next();
                    hC.addUser(userName, age, userID);
                    break;


                case 4:
                    System.out.println("Enter the Hospital ID for slot create");
                    String HospitalID = scn.next();
                    System.out.println("Enter the number of Days");
                    int dayNum = scn.nextInt();
                    hC.addSlot(HospitalID, dayNum, hC);
                    break;

                case 5:
                    System.out.println("Enter your unique user ID");
                    String id = scn.next();
                    hC.bookVaccineSlot(id);
                    break;


                case 6:
                    System.out.println("Enter the Hospital ID to get Slots");
                    id = scn.next();
                    hC.slotDetailsByHospital(id);
                    break;


                case 7:
                    System.out.println("Enter the user ID");
                    userID = scn.next();
                    hC.checkVaccinationStatus(userID);
                    break;


                case 8:
                    System.out.println("Thanks for using CoWin portal");
                    System.exit(0);


            }


        }
    }
}
