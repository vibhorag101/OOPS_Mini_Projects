package COWIN;

import java.util.ArrayList;
import java.util.Scanner;

class Slot {
    Scanner scn = new Scanner(System.in);
    private final String HospitalID;
    private final int SlotNumber;
    private HandlerClass h;

    class Day {
        private final int dayNumber;
        private final int quantity;
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
            System.out.println("Day Number is " + dayNumber);
            System.out.println("Quantity Booked for " + dayNumber + " is" + quantity);
            System.out.println("The vaccine is " + vaccineType.getVaccineName());
        }

    }

    private ArrayList<Day> dayList = new ArrayList<>();

    Slot(String HospitalID, int SlotNumber) {
        this.SlotNumber = SlotNumber;
        this.HospitalID = HospitalID;
        for (int i = 0; i < SlotNumber; i++) {
            System.out.println("Enter the quantity for day " + i);
            int quantity = scn.nextInt();

            h.displayVaccineList();
            int chosenVaccine = scn.nextInt();
            dayList.add(new Day(i, quantity, h.getVaccineList().get(chosenVaccine)));
        }
    }

    void displaySlotDetails() {
        System.out.println("The hospital id is " + HospitalID);
        System.out.println("The number of slots booked are " + SlotNumber);
        for (Day d : dayList) {
            d.displayDayDetails();
        }


    }


}