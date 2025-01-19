package application.main;

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

    /**
     * constructor for the nutrition class
     * @param diet
     * @param religion
     */
    public Nutrition(String diet, String religion) {
        this.allergies = new ArrayList<String>();
        this.mealPlan = new MealPlan();
        this.diet = diet;
        this.religion = religion;
        this.medication = new ArrayList<>();

        getJSONNutrition();
    }

    /**
     * resets the user's allergies
     */
    public void resetAllergies() {
        this.allergies.clear();
    }

    /**
     * resets the user's nutritional medication
     */
    public void resetMedication() {
        this.medication.clear();
    }

    /**
     * resets the user's meal plan
     */
    public void resetMealPlan() {
        this.mealPlan.resetMealPlan();
    }

    /**
     * adds a new allergy to the list of allergies the user ha
     * @param allergy the new allergy to be added
     */
    public void addAllergy(String allergy) {
        this.allergies.add(allergy);
    }

    /**
     * adds a new medicine to the list of nutritional medication the user has
     * @param med the new medicine to be added
     */
    public void addMedication(Medicine med) {
        this.medication.add(med);
    }

    /**
     * sets the diet of the user
     * @param diet the new diet of the user
     */
    public void setDiet(String diet) {
        this.diet = diet;
    }

    /**
     * sets the religion of the user
     * @param religion the new diet of the user
     */
    public void setReligion(String religion) {

        switch (religion) {
            case "Islam":
                this.religion = "Muslim";
                break;
            case "Judaism":
                this.religion = "Jewish";
                break;
            case "Christianity":
                this.religion = "Christian";
                break;
            case "Hinduism":
                this.religion = "Hindu";
                break;
            case "Sikhism":
                this.religion = "Hindu";
                break;
            default:
                this.religion = religion;
                break;
        }
    }

    /**
     * sets the user's breakfast in thei meal plan
     * @param breakfast the user's new breakfast
     */
    public void setBreakfast(String breakfast) {
        this.mealPlan.setBreakfast(breakfast);
    }

    /**
     * sets the user's lunch in their meal plan
     * @param lunch the user's new lunch
     */
    public void setLunch(String lunch) {
        this.mealPlan.setLunch(lunch);
    }

    /**
     * sets the user's dinner in their meal plan
     * @param dinner the user's new dinner
     */
    public void setDinner(String dinner) {
        this.mealPlan.setDinner(dinner);
    }

    /**
     * gets the user's current diet
     * @return the user's diet
     */
    public String getDiet() {
        return this.diet;
    }

    /**
     * gets the user's current religion
     * @return the user's religion
     */
    public String getReligion() {
        return this.religion;
    }

    /**
     * get the user's list of allergies
     * @return the user's list of allergies
     */
    public ArrayList<String> getAllergies() {
        return this.allergies;
    }

    /**
     * get the user's meal plan
     * @return the user's meal plan
     */
    public MealPlan getMealPlan() {
        return this.mealPlan;
    }

    /**
     * get the user's nutritional medication list
     * @return the user's nutritional medication list
     */
    public ArrayList<Medicine> getMedication() {
        return this.medication;
    }

    /**
     * returns whether or not the food is okay for the user
     * @param input scanner to allow user input
     * @param food food to be checked
     * @return true if food is okay, false if food is not
     */
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

    /**
     * gets the user's nutritional information from the data.json file
     */
    public void getJSONNutrition() {
        String[] medJSON = Methods.getArrayData("main\\data.json", "Nutrition Medication");
        for (String med : medJSON) {
            String[] newMed = med.split("\\|");
            int doses = Integer.parseInt(newMed[1].replace("x", "").trim());

            this.medication.add(new Medicine(newMed[0].trim(), doses));
        }

        String[] allergiesJSON = Methods.getArrayData("main\\data.json","Allergies");
        for (String allergy : allergiesJSON) {
            this.allergies.add(allergy);
        }

        String[] mealPlanJSON = Methods.getArrayData("main\\data.json","Meal Plan");
        setBreakfast(mealPlanJSON[0].replace("breakfast: ", ""));
        setLunch(mealPlanJSON[1].replace("lunch: ", ""));
        setDinner(mealPlanJSON[2].replace("dinner: ", ""));
    }
}
