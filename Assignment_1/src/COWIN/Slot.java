package COWIN;

import java.util.ArrayList;
import java.util.Scanner;

class Slot {
    Scanner scn = new Scanner(System.in);
    private final String HospitalID;
    private final int numberOFDays;
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
            System.out.println(quantity + " " + vaccineType.getVaccineName() + " vaccines available for  day " + dayNumber);
        }

        void displayDayDetailsCounter(int counter) {
            System.out.println("option " + counter + "---> " + quantity + " " + vaccineType.getVaccineName() + " vaccines available for  day " + dayNumber);
        }

        void bookedSlot() {
            quantity--;
        }

    }

    private final ArrayList<Day> dayList = new ArrayList<>();

    Slot(String HospitalID, int numberOFDays, HandlerClass hC) {
        this.numberOFDays = numberOFDays;
        this.HospitalID = HospitalID;
        for (Hospital hospital : hC.getHospitalList()) {
            if (hospital.getHospitalUnique_ID().equals(HospitalID)) {
                this.HospitalName = hospital.getHospitalName();
                break;
            }
        }
        this.h = hC;
        for (int i = 0; i < numberOFDays; i++) {
            System.out.println("Enter the day number");
            int dayNum = scn.nextInt();
            System.out.println("Enter the quantity for day " + dayNum);
            int quantity = scn.nextInt();
            h.displayVaccineList();
            int chosenVaccine = scn.nextInt();
            dayList.add(new Day(dayNum, quantity, h.getVaccineList().get(chosenVaccine)));
        }
    }

    void displaySlotDetails() {
        System.out.println("The hospital id is " + HospitalID);
        System.out.println("The number of slots are " + numberOFDays);
        int slotCounter = 0;
        for (Day d : dayList) {
            if (d.getQuantity() > 0) {
                System.out.print("Option " + slotCounter + " --> ");
                d.displayDayDetails();
            }
            slotCounter++;
        }


    }

    void displaySlotDetailsMin() {
        int slotCounter = 0;
        for (Day d : dayList) {
            System.out.print("Option " + slotCounter + " --> ");
            d.displayDayDetails();
            slotCounter++;
        }
    }


    void displayHospitalNameID() {
        System.out.println("The hospital ID is " + HospitalID);
        System.out.println("The Hospital Name is " + HospitalName);
    }

    public String getHospitalID() {
        return HospitalID;
    }

    ArrayList<Day> getDayList() {
        return dayList;
    }


}