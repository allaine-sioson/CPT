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

    // public void isOkayForMe(String food) {
    //     String dietData = Methods.readFile("data").toLowerCase();
    //     String religionData = Methods.readFile(religion, "txt").toLowerCase();

    //     if (dietData.contains(food) || religionData.contains(food)) {
    //         if (dietData.contains(food)) {
    //             System.out.println(food + "is not allowed in a " + diet + " diet.");
    //         }

    //         if (religionData.contains(food)) {
    //             System.out.println(food +" is not allowed in " + religion + ".");
    //         }
    //     } else {
    //         System.out.println(food + "is allowed in both " + religion + " and " + diet + " diet.");
    //     }
    // }
    
}
