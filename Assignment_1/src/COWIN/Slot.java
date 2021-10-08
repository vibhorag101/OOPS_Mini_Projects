package COWIN;

import java.util.ArrayList;
import java.util.Scanner;

class Slot {
    Scanner scn = new Scanner(System.in);
    private final String HospitalID;
    private final int SlotNumber;
    private String HospitalName;
    private final HandlerClass h;

    class Day {
        private final int dayNumber;
        private int quantity;
        private final vaccine vaccineType;

        Day(int dayNumber, int quantity, vaccine vaccineType) {
            this.dayNumber = dayNumber;
            this.quantity = quantity;
            this.vaccineType = vaccineType;
        }


        public int getDayNumber() {
            return dayNumber;
        }

        public vaccine getVaccineType() {
            return vaccineType;
        }

        public int getQuantity() {
            return quantity;
        }

        void displayDayDetails() {
//            System.out.println("Hospital ID is " + HospitalID);
            System.out.println("Day Number is " + dayNumber);
            System.out.println("Quantity for " + dayNumber + " is" + quantity);
            System.out.println("The vaccine is " + vaccineType.getVaccineName());
        }
        void bookedSlot(){
            quantity--;
        }

    }

    private final ArrayList<Day> dayList = new ArrayList<>();

    Slot(String HospitalID, int numberOfSlots,HandlerClass hC) {
        this.SlotNumber = numberOfSlots;
        this.HospitalID = HospitalID;
        for (Hospital hospital : hC.getHospitalList()){
            if (hospital.getHospitalUnique_ID().equals(HospitalID)){
                this.HospitalName=hospital.getHospitalName();
                break;
            }
        }
        this.h=hC;
        for (int i = 0; i < numberOfSlots; i++) {
            System.out.println("Enter the quantity for day " + i);
            int quantity = scn.nextInt();

            h.displayVaccineList();
            int chosenVaccine = scn.nextInt();
            dayList.add(new Day(i, quantity, h.getVaccineList().get(chosenVaccine)));
        }
    }

    void displaySlotDetails() {
        System.out.println("The hospital id is " + HospitalID);
        System.out.println("The number of slots are " + SlotNumber);
        for (Day d : dayList) {
            d.displayDayDetails();
        }


    }

    void displayHospitalNameID() {
        System.out.println("The hospital ID is " + HospitalID);
        System.out.println("The Hospital Name is " + HospitalName);
    }

    public String getHospitalID(){
        return HospitalID;
    }
    ArrayList<Day> getDayList() {
        return dayList;
    }


}