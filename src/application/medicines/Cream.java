package application.medicines;
import application.main.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Cream datatype
 */

 /**
  * The Cream class represents a type of medicine in the form of a cream
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
