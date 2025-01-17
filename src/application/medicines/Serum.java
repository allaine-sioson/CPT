package application.medicines;
import application.Medicine;

public class Serum extends Medicine {
    public Serum(String name, int doses) {
        super("Serum: " + name, doses);
    }
}