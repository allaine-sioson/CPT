package application.medicines;
import application.main.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Syrup datatype
 */

 /**
  * The Syrup class represents a type of medicine in the form of a syrup
  */
public class Syrup extends Medicine {
    /**
     * constructor for Syrup Medicine class
     * @param name the name of the medicine
     * @param doses the doses of medicine that the user needs to take
     */
    public Syrup(String name, int doses) {
        super("Syrup: " + name, doses);
    }
}
