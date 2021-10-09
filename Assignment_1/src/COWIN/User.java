package COWIN;

class User {
    private final String userName;
    private final String uniqueID_User;
    private final int age;
    private final String registerStatus;
    private String receivedVaccineName;
    private int doseReceived;
    private String vaccineStatus;
    private int nextDate;
    private vaccine vaccineTypeReceived;


    User(String name, String ID, int age) {
        this.userName = name;
        this.age = age;
        this.uniqueID_User = ID;
        this.registerStatus = "Registered";
        this.vaccineStatus = "Not Vaccinated";
        this.doseReceived = 0;
        this.nextDate = 0;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return uniqueID_User;
    }

    public int getPatientAge() {
        return age;
    }

    public void setDoseReceived() {
        doseReceived++;
    }

    public void setReceivedVaccineName(String s) {
        receivedVaccineName = s;
    }

    public String getReceivedVaccineName() {
        return (receivedVaccineName);
    }

    public String getVaccineStatus() {
        return (vaccineStatus);
    }

    public int getDoseReceived() {
        return doseReceived;
    }

    public void setNextDate(int dayNumber, int gap) {
        nextDate = dayNumber + gap;
    }

    public void setVaccinationStatus() {
        if (doseReceived == vaccineTypeReceived.getDoseRequired()) {
            vaccineStatus = "Fully Vaccinated";
        } else if (doseReceived > 0) {
            vaccineStatus = "Partially Vaccinated";
        } else {
            vaccineStatus = "Not Vaccinated";
        }

    }

    void displayUserDetails() {
        System.out.println("your registered name is " + userName);
        System.out.println("Your registered 12 Digit ID is " + uniqueID_User);
        System.out.println("Your registered age is " + age);
        System.out.println("Your are " + registerStatus);
    }

    void setVaccineTypeReceived(vaccine v) {
        this.vaccineTypeReceived = v;
    }

    int getNextDate() {
        return (nextDate);
    }


}