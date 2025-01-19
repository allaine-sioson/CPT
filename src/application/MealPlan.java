package application;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Meal plan datatype
 */

public class MealPlan {
    private String breakfast, lunch, dinner;
    
    public MealPlan() {
        this.breakfast = "";
        this.lunch = "";
        this.dinner = "";
    }

    public void resetMealPlan() {
        this.breakfast = "";
        this.lunch = "";
        this.dinner = "";
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    @Override
    public String toString() {
        return "[\"breakfast: " + breakfast + "\", \"lunch: " + lunch + "\", \"dinner: " + dinner + "\"]";
    }
}
