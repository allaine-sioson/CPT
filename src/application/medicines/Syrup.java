package application.medicines;
import application.Medicine;

public class Syrup extends Medicine {
    public Syrup(String name, int doses) {
        super("Syrup: " + name, doses);
    }
}
