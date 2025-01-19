package application;

import java.util.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Nutrition datatype
 */

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

    public boolean isOkayForMe(Scanner input, String food) {
        String[] dietData;
        String[] religionData;

        String[] existingDietFiles = {"pescatarian", "vegan", "vegetarian"};
        String[] existingReligionFiles = {"jewish", "muslim"};

        String currentDietFile = "none";
        String currentReligionFile = "none";

        for (String existingDietFile : existingDietFiles) {
            if (this.diet.toLowerCase().equals(existingDietFile)) {
                currentDietFile = this.diet.toLowerCase();
                break;
            }
        }

        for (String existingReligionFile : existingReligionFiles) {
            if (this.religion.toLowerCase().equals(existingReligionFile)) {
                currentReligionFile = this.religion.toLowerCase();
                break;
            }
        }

        if (!currentDietFile.equals("none")) {
            dietData = Methods.readFile("assets\\diets\\"+ currentDietFile + "Data.txt").toLowerCase().split(", ");
        } else {
            dietData = new String[0];
        }

        if (!currentReligionFile.equals("none")) {
            religionData = Methods.readFile("assets\\religions\\" + currentReligionFile + "Data.txt").toLowerCase().split(", ");
        } else {
            religionData = new String[0];
        }

        ArrayList<String> foodTypes = new ArrayList<>();
        
        for (String allergy : this.allergies) {
            foodTypes.add(allergy);
        }

        for (String dietInfo : dietData) {
            boolean infoAlreadyAdded = false;
            for (String type : foodTypes) {
                if (type.equals(dietInfo)) {
                    infoAlreadyAdded = true;
                    break;
                }
            }

            if (!infoAlreadyAdded) {
                foodTypes.add(dietInfo);
            }
        }

        for (String religionInfo : religionData) {
            boolean infoAlreadyAdded = false;
            for (String type : foodTypes) {
                if (type.equals(religionInfo)) {
                    infoAlreadyAdded = true;
                    break;
                }
            }

            if (!infoAlreadyAdded) {
                foodTypes.add(religionInfo);
            }
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
            for (String allergy : allergies) {
                if (allergy.toLowerCase().contains(foodInfo.toLowerCase())) {
                    result = false;
                    break;
                }
            }

            for (String dietInfo : dietData) {
                if (dietInfo.toLowerCase().contains(foodInfo.toLowerCase())) {
                    result = false;
                    break;
                }
            }

            for (String religionInfo : religionData) {
                if (religionInfo.toLowerCase().contains(foodInfo.toLowerCase())) {
                    result = false;
                    break;
                }
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
