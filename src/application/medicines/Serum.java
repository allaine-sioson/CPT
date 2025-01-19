package application.medicines;
import application.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Serum datatype
 */

public class Serum extends Medicine {
    public Serum(String name, int doses) {
        super("Serum: " + name, doses);
    }
}