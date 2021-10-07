package COWIN;

import java.util.ArrayList;
import java.util.Scanner;

class HandlerClass {
    Scanner scn = new Scanner(System.in);
    private int HospitalCounter;
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
        userList.add(new User(userName, UserID, Age));
    }

    void addHospital(String hospitalName, int Pincode) {
        hospitalList.add(new Hospital(hospitalName, Pincode, HospitalCounter));
        HospitalCounter++;
    }

    void addVaccine(String vaccineName, int DoseRequired, int gapRequired) {
        vaccine temp = new vaccine(vaccineName, DoseRequired, gapRequired);
        vaccineList.add(temp);
    }

    void addSlot(String HospitalID, int SlotNumber, String HospitalName) {
        //todo do something related to eliminated HospitalName
        Slot temp = new Slot(HospitalID, SlotNumber, HospitalName);
        slotList.add(temp);

    }

    void displayVaccineList() {
        int i = 0;
        while (i < vaccineList.size()) {
            System.out.println("select " + i + " for " + vaccineList.get(i).getVaccineName());
        }
    }

    void bookVaccineSlot(User u) {
        String userID = scn.next();
        System.out.println("Enter 0 for search by Pincode");
        System.out.println("Enter 1 for search by Hospital");
        System.out.println("Enter 2 to exit");
        int choice = scn.nextInt();
        if (choice == 0) {
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
                    System.out.println("Choose your Slot");
                    int vaccineSlotChosen = scn.nextInt();
                    vaccine chosenVaccine = s.getDayList().get(vaccineSlotChosen).getVaccineType();
                    String chosenVaccineName = chosenVaccine.getVaccineName();
                    u.setRecievedVaccineName(chosenVaccineName);
                    u.setDoseRecieved();
                    s.getDayList().get(vaccineSlotChosen).bookedSlot();
                    System.out.println(u.getUserName() + " vaccinated with " + chosenVaccineName);
                    u.setNextDate(vaccineSlotChosen, chosenVaccine.getGapRequired());
                    u.setVaccineTypeReceived(chosenVaccine);
                }
            }


        } else {
            String vaccineName = scn.next();
            for (Slot s : slotList) {
                for (Slot.Day d : s.getDayList()) {
                    //fixme there might be a bug here.
                    if (d.getVaccineType().getVaccineName().equals(vaccineName)) {
                        s.displayHospitalNameID();
                    }
                }
            }


        }
        //searching part done , now need to do the booking part


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
