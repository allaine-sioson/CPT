package application;

import java.util.*;

public class Nutrition {
    private ArrayList<String> allergies;
    private ArrayList<Medicine> medication;
    private MealPlan mealPlan;
    private String diet, religion;

    public Nutrition(String diet, String religion) {
        this.allergies = new ArrayList<String>();
        this.mealPlan = new MealPlan();
        this.diet = diet;
        this.religion = religion;
    }

    public void addAllergy(String allergy) {
        this.allergies.add(allergy);
    }

    public void addMedication(Medicine med) {
        this.medication.add(med);
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setBreakfast(String breakfast) {
        setBreakfast(breakfast);
    }

    public void setLunch(String lunch) {
        setLunch(lunch);
    }

    public void setDinner(String dinner) {
        setDinner(dinner);
    }

    public String getDiet() {
        return this.diet;
    }

    public String getReligion() {
        return this.religion;
    }

    public ArrayList<String> getAllergies() {
        return this.allergies;
    }

    public MealPlan getMealPlan() {
        return this.mealPlan;
    }

    public boolean isOkayForMe(Scanner input, String food) {
        String dietData = Methods.readFile(diet.toLowerCase() + "Data.txt");
        String religionData = Methods.readFile(religion.toLowerCase() + "Data.txt");

        String[] foodTypes = {"Meats (beef, pork, poultry etc)", "Seafood", "Animal by-products", "Dairy", "Gluten", "Nuts", "Soy"};
        ArrayList<String> foodData = new ArrayList<>();
        String choice;
        boolean result = true;

        for (String foodType : foodTypes) {
            do {
                System.out.println("Would " + food + "be considered a / contain \"" + foodType + "\" ?");
                System.out.print("Input Y/N: ");
                choice = input.nextLine().toUpperCase();
            } while (!choice.equals("Y") && !choice.equals("N"));
    
            if (choice.equals("Y")) {
                foodData.add(foodType);
            }
        }

        for (String foodInfo : foodData) {
            if (dietData.contains(foodInfo) || religionData.contains(foodInfo)) {
                result = false;
                break;
            }
        }

        return result;
    }
    
}
