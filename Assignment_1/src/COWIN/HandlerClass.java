package COWIN;

import java.util.ArrayList;
import java.util.Scanner;

class HandlerClass {
    Scanner scn = new Scanner(System.in);
    private int HospitalCounter=1;
    //BUG Possible
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

    void addUser(String userName, int Age, String UserID) {
        User temp = new User(userName, UserID, Age);
        userList.add(temp);
        temp.displayUserDetails();
    }

    void addHospital(String hospitalName, int Pincode) {
        Hospital temp = new Hospital(hospitalName, Pincode, HospitalCounter);
        hospitalList.add(temp);
        temp.displayHospitalDetails();
        HospitalCounter++;
    }

    void addVaccine(String vaccineName, int DoseRequired, int gapRequired) {
        vaccine temp = new vaccine(vaccineName, DoseRequired, gapRequired);
        vaccineList.add(temp);
        temp.displayVaccine();
    }

    void addSlot(String HospitalID, int SlotNumber,HandlerClass hC) {
        //todo do something related to eliminated HospitalName
        Slot temp = new Slot(HospitalID, SlotNumber,hC);
        slotList.add(temp);
        temp.displaySlotDetails();

    }

    void displayVaccineList() {
        int i = 0;
        while (i < vaccineList.size()) {
            System.out.println("select " + i + " for " + vaccineList.get(i).getVaccineName());
            i++;
        }
    }

    void bookVaccineSlot(String userID) {
        User u = null;
        for (User user: userList){
            if (user.getUserID().equals(userID)){
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
        //searching part done , now need to do the booking part


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

    ArrayList<User> getUserList() {
        return (userList);
    }

    ArrayList<Hospital> getHospitalList() {
        return (hospitalList);
    }

    ArrayList<vaccine> getVaccineList() {
        return (vaccineList);
    }


}
