package application.medicines;
import application.Medicine;

public class Toner extends Medicine {
    public Toner(String brand, int doses) {
        super(brand + ": " + "Toner", doses);
    }
}