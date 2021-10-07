package COWIN;

import java.util.ArrayList;

class HandlerClass {
    private int HospitalCounter;
    //BUG Possible
    private final ArrayList<User> userList;
    private final ArrayList<Hospital> hospitalList;
    private final ArrayList<vaccine> vaccineList;

    HandlerClass() {
        userList = new ArrayList<>();
        hospitalList = new ArrayList<>();
        vaccineList = new ArrayList<>();
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

    void displayVaccineList() {
        int i = 0;
        while (i < vaccineList.size()) {
            System.out.println("select " + i + " for " + vaccineList.get(i).getVaccineName());
        }
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
