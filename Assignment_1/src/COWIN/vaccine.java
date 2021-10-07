package COWIN;

class vaccine {

    private final String vaccineName;
    private final int doseRequired;
    private final int gapRequired;

    vaccine(String vaccineName, int doseRequired, int gapRequired) {
        this.vaccineName = vaccineName;
        this.doseRequired = doseRequired;
        this.gapRequired = gapRequired;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public int getDoseRequired() {
        return doseRequired;
    }

    public int getGapRequired() {
        return gapRequired;
    }

    public void displayVaccine() {
        System.out.println("Name of vaccine registered by you is " + vaccineName);
        System.out.println("Number of doses of vaccine required is " + doseRequired);
        System.out.println("Number of days of gap between doses is " + gapRequired);
    }
}
