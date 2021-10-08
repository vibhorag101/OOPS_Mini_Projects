package COWIN;

class User {
    private String userName;
    private String uniqueID_User;
    private int age;
    private String registerStatus;
    private String recievedVaccineName;
    private int doseReceived;
    private String vaccineStatus;
    private int nextDate;
    private vaccine vaccineTypeRecieved;


    User(String name, String ID, int age) {
        if (age < 18) {
            System.out.println("Sorry, only people above 18 years age are allowed to register ");
            System.exit(0);
        } else {
            this.userName = name;
            this.age = age;
            this.uniqueID_User = ID;
            this.registerStatus = "Registered";
            this.vaccineStatus = "Not Vaccinated";
            this.doseReceived=0;
        }
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

    public void setDoseRecieved() {
        doseReceived++;
    }

    public void setReceivedVaccineName(String s) {
        recievedVaccineName = s;
    }

    public String getReceivedVaccineName() {
        return (recievedVaccineName);
    }

    public String getVaccineStatus(){
        return (vaccineStatus);
    }

    public int getDoseReceived() {
        return doseReceived;
    }

    public void setNextDate(int slotNumber, int gap) {
        nextDate = slotNumber + gap;
    }

    public void setVaccinationStatus() {
        if (doseReceived == vaccineTypeRecieved.getDoseRequired()) {
            vaccineStatus = "Fully Vaccinated";
        } else if (doseReceived > 0) {
            vaccineStatus = "Partially Vaccinated";
        }
        else{
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
        this.vaccineTypeRecieved = v;
    }

    int getNextDate(){
        return(nextDate);
    }


}