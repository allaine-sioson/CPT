package application.medicines;
import application.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Pill datatype
 */

public class Pill extends Medicine {
    /**
     * constructor for Pill Medicine class
     * @param name the name of the medicine
     * @param doses the doses of medicine that the user needs to take
     */
    public Pill(String name, int doses) {
        super("Pill: " + name, doses);
    }
}