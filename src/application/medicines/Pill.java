package application.medicines;
import application.main.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Pill datatype
 */

 /**
  * The Pill class represents a type of medicine in the form of a pill
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