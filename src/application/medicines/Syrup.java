package application.medicines;
import application.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Syrup datatype
 */

public class Syrup extends Medicine {
    public Syrup(String name, int doses) {
        super("Syrup: " + name, doses);
    }
}
