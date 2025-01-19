package application.medicines;
import application.Medicine;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Other datatype
 */

public class Other extends Medicine {
    public Other(String name, int doses) {
        super("Other: " + name, doses);
    }
}
