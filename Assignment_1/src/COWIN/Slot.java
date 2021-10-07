package COWIN;
import java.util.ArrayList;
import java.util.Scanner;

class Slot {
    private Scanner scn = new Scanner(System.in);
    private String HospitalID;
    private int SlotNumber;
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

    }

    private ArrayList<Day> dayList = new ArrayList<>();

    Slot(String HospitalID, int SlotNumber) {
        for (int i = 0; i < SlotNumber; i++) {
            System.out.println("Enter the quantity for day " + i);
            int quantity = scn.nextInt();
            h.displayVaccineList();
            int chosenVaccine = scn.nextInt();
            dayList.add(new Day(i, quantity, h.getVaccineList().get(chosenVaccine)));
        }
    }


}