package application;

import java.util.Arrays;

public class MealPlan {
    private String[] mealPlan;
    
    public MealPlan() {
        this.mealPlan = new String[3];
    }

    public void setBreakfast(String breakfast) {
        this.mealPlan[0] = breakfast;
    }

    public void setLunch(String lunch) {
        this.mealPlan[1] = lunch;
    }

    public void setDinner(String dinner) {
        this.mealPlan[2] = dinner;
    }

    public void setMealPlan(String breakfast, String lunch, String dinner) {
        setBreakfast(breakfast);
        setLunch(lunch);
        setDinner(dinner);
    }

    @Override
    public String toString() {
        String printStatement = "[";
        for (int i = 0; i < mealPlan.length; i++) {
            String food = "";
            if (mealPlan[i] != null) {
                food = mealPlan[i];
            }

            if (i == 0) {
                printStatement = printStatement + "\"breakfast: " + food + "\", ";
            } else if (i == 1) {
                printStatement = printStatement + "\"lunch: " + food + "\", ";
            } else {
                printStatement = printStatement + "\"dinner: " + food + "\"]";
            }
        }
        return printStatement;
    }

    
}
