package Backpack;

public class Instructor {
    private final String name;
    private final String ID;

    Instructor(String Name, String ID) {
        this.name = Name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
}
