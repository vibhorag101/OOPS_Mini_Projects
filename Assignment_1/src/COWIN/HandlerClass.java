package COWIN;

import java.util.ArrayList;
import java.util.Scanner;

class HandlerClass {
    // all the declarations are below
    Scanner scn = new Scanner(System.in);
    private int HospitalCounter = 1;
    private final ArrayList<User> userList;
    private final ArrayList<Hospital> hospitalList;
    private final ArrayList<vaccine> vaccineList;
    private final ArrayList<Slot> slotList;

    HandlerClass() {
        userList = new ArrayList<>();
        hospitalList = new ArrayList<>();
        vaccineList = new ArrayList<>();
        slotList = new ArrayList<>();
    }

    // functions related to user Class are below
    void addUser(String userName, int Age, String UserID) {
        User temp = new User(userName, UserID, Age);
        userList.add(temp);
        temp.displayUserDetails();
    }

    ArrayList<User> getUserList() {
        return (userList);
    }

    void checkVaccinationStatus(String userID){
        for(User u: userList){
            if(u.getUserID().equals(userID)){
                String temp = u.getVaccineStatus();
                if(temp.equals("Fully Vaccinated")){
                    System.out.println("Congratulations you are fully vaccinated");
                }
                else if (temp.equals("Partially Vaccinated")){
                    System.out.println("You are partially vaccinated");
                    System.out.println("Next vaccine data is "+u.getNextDate());
                }
                else{
                    System.out.println("You are not vaccinated! Kindly register for the slot");
                }
            }
        }

    }
    // function for the hospital class are below

    void addHospital(String hospitalName, int Pincode) {
        Hospital temp = new Hospital(hospitalName, Pincode, HospitalCounter);
        hospitalList.add(temp);
        temp.displayHospitalDetails();
        HospitalCounter++;
    }

    ArrayList<Hospital> getHospitalList() {
        return (hospitalList);
    }

    // Functions for the vaccine class are below

    void addVaccine(String vaccineName, int DoseRequired, int gapRequired) {
        vaccine temp = new vaccine(vaccineName, DoseRequired, gapRequired);
        vaccineList.add(temp);
        temp.displayVaccine();
    }

    void displayVaccineList() {
        int i = 0;
        while (i < vaccineList.size()) {
            System.out.println("select " + i + " for " + vaccineList.get(i).getVaccineName());
            i++;
        }
    }

    ArrayList<vaccine> getVaccineList() {
        return (vaccineList);
    }

    // functions related to the Slot class are below

    void addSlot(String HospitalID, int SlotNumber, HandlerClass hC) {
        Slot temp = new Slot(HospitalID, SlotNumber, hC);
        slotList.add(temp);
        temp.displaySlotDetails();

    }

    void slotDetailsByHospital(String id) {
        for (Slot s : slotList) {
            if (s.getHospitalID().equals(id)) {
                s.displaySlotDetailsMin();
            }
        }
    }

    // function to implement booking Mechanism are below

    void bookVaccineSlot(String userID) {
        User u = null;
        for (User user : userList) {
            if (user.getUserID().equals(userID)) {
                u = user;
                break;
            }
        }
        System.out.println("Enter 0 for search by Pincode");
        System.out.println("Enter 1 for search by Vaccine");
        System.out.println("Enter 2 to exit");
        int choice = scn.nextInt();
        if (choice == 0) {
            System.out.println("Enter the Pincode");
            int Pincode = scn.nextInt();
            boolean notfoundFlag = true;
            for (Hospital h : hospitalList) {
                if (h.getPincode() == Pincode) {
                    System.out.println(h.getHospitalName() + " " + h.getHospitalUnique_ID());
                    notfoundFlag = false;
                }
            }
            if (notfoundFlag) {
                System.out.println("No Hospital having slots in current pincode exists");
                System.exit(0);
            }
            System.out.println("Enter the ID of the Hospital");
            String hospitalID = scn.next();
            for (Slot s : slotList) {
                if (s.getHospitalID().equals(hospitalID)) {
                    s.displaySlotDetails();

                    assert u != null;
                    doBooking(u, s);
                }
            }


        } else {
            System.out.println("Enter the vaccine name");
            String vaccineNameSearch = scn.next();
            for (Slot s : slotList) {
                for (Slot.Day d : s.getDayList()) {
                    //fixme there might be a bug here.
                    if (d.getVaccineType().getVaccineName().equals(vaccineNameSearch)) {
                        s.displayHospitalNameID();
                        break;
                    }
                }
            }
            System.out.println("Enter the ID of the Hospital");
            String hospitalID = scn.next();
            for (Slot s : slotList) {
                if (s.getHospitalID().equals(hospitalID)) {
                    for (Slot.Day d : s.getDayList()) {
                        if (d.getVaccineType().getVaccineName().equals(vaccineNameSearch)) {
                            d.displayDayDetails();
                        }
                    }
                    assert u != null;
                    doBooking(u, s);

                }
            }

        }

    }

    private void doBooking(User u, Slot s) {
        System.out.println("Choose your Day");
        int vaccineDayChosen = scn.nextInt();
        vaccine chosenVaccine = s.getDayList().get(vaccineDayChosen).getVaccineType();
        String chosenVaccineName = chosenVaccine.getVaccineName();
        if ((u.getReceivedVaccineName() != null) && (!u.getReceivedVaccineName().equals(chosenVaccineName))) {
            System.out.println("You cant take this vaccine. Please select previously taken vaccine");
            System.exit(0);
        }
        u.setReceivedVaccineName(chosenVaccineName);
        u.setDoseRecieved();
        s.getDayList().get(vaccineDayChosen).bookedSlot();
        System.out.println(u.getUserName() + " vaccinated with " + chosenVaccineName);
        u.setNextDate(vaccineDayChosen, chosenVaccine.getGapRequired());
        u.setVaccineTypeReceived(chosenVaccine);
    }







}
