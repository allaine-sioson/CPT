package application;

import java.io.*;
import java.util.*;

public class Nutrition {
    private ArrayList<String> allergies;
    private String[] mealPlan;
    private String diet, religion;

    public Nutrition(ArrayList<String> allergies, String[] mealPlan, String diet, String religion) {
        this.allergies = allergies;
        this.mealPlan = mealPlan;
        this.diet = diet;
        this.religion = religion;
    }

    public Nutrition(String diet) {
        this.diet = diet;
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }

    public void setMealPlan(String[] mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void setDiet(String diet) {
        this.diet = diet;
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
