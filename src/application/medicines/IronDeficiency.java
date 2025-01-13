package application.medicines;
import application.Medicine;

public class IronDeficiency extends Medicine {
    public IronDeficiency(String brand, int doses) {
        super(brand + ": " + "Iron Deficiency", doses);
    }
}