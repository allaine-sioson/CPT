package application.medicines;
import application.Medicine;

public class Other extends Medicine {
    public Other(String name, int doses) {
        super("Other: " + name, doses);
    }
}
