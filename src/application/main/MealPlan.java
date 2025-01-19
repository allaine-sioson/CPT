package application.main;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Meal plan datatype
 */

public class MealPlan {
    private String breakfast, lunch, dinner;
    
    /**
     * constructor for the MealPlan class
     */
    public MealPlan() {
        this.breakfast = "";
        this.lunch = "";
        this.dinner = "";
    }

    /**
     * resets the meal plan
     */
    public void resetMealPlan() {
        this.breakfast = "";
        this.lunch = "";
        this.dinner = "";
    }

    /**
     * sets the breakfast in the user's meal plan
     * @param breakfast the new breakfast to be set
     */
    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    /**
     * sets the lunch in the user's meal plan
     * @param lunch the new lunch to be set
     */
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    /**
     * sets the dinner in the user's meal plan
     * @param dinner the new dinner to be set
     */
    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    /**
     * return a string representation of the meal plan class
     */
    @Override
    public String toString() {
        return "[\"breakfast: " + breakfast + "\", \"lunch: " + lunch + "\", \"dinner: " + dinner + "\"]";
    }
}
