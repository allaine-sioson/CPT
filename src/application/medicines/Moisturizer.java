package application.medicines;
import application.Medicine;

public class Moisturizer extends Medicine {
    public Moisturizer(String brand, int doses) {
        super(brand + ": " + "Moisturizer", doses);
    }
}