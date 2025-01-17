package application.medicines;
import application.Medicine;

public class Pill extends Medicine {
    public Pill(String name, int doses) {
        super("Pill: " + name, doses);
    }
}