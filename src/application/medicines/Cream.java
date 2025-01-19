package application.medicines;
import application.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Cream datatype
 */

public class Cream extends Medicine {
    /**
     * constructor for Cream Medicine class
     * @param name the name of the medicine
     * @param doses the doses of medicine that the user needs to take
     */
    public Cream(String name, int doses) {
        super("Cream: " + name, doses);
    }
}
