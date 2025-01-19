package application.medicines;
import application.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Pill datatype
 */

public class Pill extends Medicine {
    public Pill(String name, int doses) {
        super("Pill: " + name, doses);
    }
}