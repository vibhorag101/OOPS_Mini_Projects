package COWIN;

class Hospital {
    private String HospitalName;
    private int pincode;
    private String hospitalUnique_ID;

    Hospital(String HospitalName, int Pincode, int count) {
        if (Integer.toString(Pincode).length() != 6) {
            System.out.println("You have entered an invalid pincode");
        } else {
            this.HospitalName = HospitalName;
            this.pincode = Pincode;
            this.hospitalUnique_ID = String.format("%06d", count);
        }
    }

    public int getPincode() {
        return pincode;
    }

    public String getHospitalUnique_ID() {
        return hospitalUnique_ID;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void displayHospitalDetails() {
        System.out.println("Hospital Name registered by you is " + HospitalName);
        System.out.println("Hospital Pincode registered by you is " + pincode);
        System.out.println("The unique 6 digit Hospital ID allotted to you is " + hospitalUnique_ID);
    }

}