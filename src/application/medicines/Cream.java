package application.medicines;
import application.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Cream datatype
 */

public class Cream extends Medicine {
    public Cream(String name, int doses) {
        super("Cream: " + name, doses);
    }
}
