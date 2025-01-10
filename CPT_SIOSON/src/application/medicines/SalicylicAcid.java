package application.medicines;
import application.Medicine;

public class SalicylicAcid extends Medicine {
    public SalicylicAcid(String brand, int doses) {
        super(brand + ": " + "Salicylic Acid", doses);
    }
}