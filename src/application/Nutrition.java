package application;

/**
 * author: Allaine
 * date: 15/01/2025
 * Nutrition datatype
 */

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
        this.medication = new ArrayList<>();

        getJSONNutrition();
    }

    public void resetAllergies() {
        this.allergies.clear();
    }

    public void resetMedication() {
        this.medication.clear();
    }

    public void resetMealPlan() {
        this.mealPlan.resetMealPlan();
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
        this.mealPlan.setBreakfast(breakfast);
    }

    public void setLunch(String lunch) {
        this.mealPlan.setLunch(lunch);
    }

    public void setDinner(String dinner) {
        this.mealPlan.setDinner(dinner);
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

    public ArrayList<Medicine> getMedication() {
        return this.medication;
    }

    //TODO: fix method to also check allergies
    public boolean isOkayForMe(Scanner input, String food) {
        String dietData;
        String religionData;

        if (!diet.toLowerCase().equals("normal")) {
            dietData = Methods.readFile("assets\\diets\\"+ diet.toLowerCase() + "Data.txt").toLowerCase();
        } else {
            dietData = "";
        }

        if (!religion.toLowerCase().equals("christian")) {
            religionData = Methods.readFile("assets\\religions\\" + religion.toLowerCase() + "Data.txt").toLowerCase();
        } else {
            religionData = "";
        }

        ArrayList<String> foodTypes = new ArrayList<>();
        foodTypes.add("beef");
        foodTypes.add("pork");
        foodTypes.add("poultry");
        foodTypes.add("seafood");
        foodTypes.add("animal by-products");
        foodTypes.add("dairy");
        foodTypes.add("gluten");
        
        for (String allergy : this.allergies) {
            foodTypes.add(allergy);
        }

        ArrayList<String> foodData = new ArrayList<>();
        String choice;
        boolean result = true;

        for (String foodType : foodTypes) {
            do {
                System.out.println("Would " + food + " be considered a / contain \"" + foodType + "\" ?");
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

    public void getJSONNutrition() {
        String[] medJSON = Methods.getArrayData("data.json", "Nutrition Medication");
        for (String med : medJSON) {
            String[] newMed = med.split("\\|");
            int doses = Integer.parseInt(newMed[1].replace("x", "").trim());

            this.medication.add(new Medicine(newMed[0].trim(), doses));
        }

        String[] allergiesJSON = Methods.getArrayData("data.json","Allergies");
        for (String allergy : allergiesJSON) {
            this.allergies.add(allergy);
        }

        String[] mealPlanJSON = Methods.getArrayData("data.json","Meal Plan");
        setBreakfast(mealPlanJSON[0].replace("breakfast: ", ""));
        setLunch(mealPlanJSON[1].replace("lunch: ", ""));
        setDinner(mealPlanJSON[2].replace("dinner: ", ""));
    }
    
}
