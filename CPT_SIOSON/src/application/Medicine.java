package application;

public class Medicine {
    private String name;
    private int doses;

    public Medicine(String name, int doses) {
        this.name = name;
        this.doses = doses;
    }

    @Override
    public String toString() {
        return "Take " + name + " " + doses + "x a day.";
    }
}

class SalicylicAcid extends Medicine{
    public SalicylicAcid(String brand, int doses) {
        super(brand + ": " + "Salicylic Acid", doses);
    }
}