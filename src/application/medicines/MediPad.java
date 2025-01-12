package application.medicines;
import application.Medicine;

public class MediPad extends Medicine {
    public MediPad(String brand, int doses) {
        super(brand + ": " + "MediPad", doses);
    }
}