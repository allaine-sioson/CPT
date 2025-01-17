package application.medicines;
import application.Medicine;

public class Cream extends Medicine {
    public Cream(String name, int doses) {
        super("Cream: " + name, doses);
    }
}
