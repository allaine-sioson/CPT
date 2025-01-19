package application.medicines;
import application.main.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Serum datatype
 */

 /**
  * The Serum class represents a type of medicine in the form of a serum
  */
public class Serum extends Medicine {
    /**
     * constructor for Serum Medicine class
     * @param name the name of the medicine
     * @param doses the doses of medicine that the user needs to take
     */
    public Serum(String name, int doses) {
        super("Serum: " + name, doses);
    }
}