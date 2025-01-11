package application;

import java.util.*;

import org.json.simple.*;

public class User {
    private String name, gender;
    private HashMap<String,Object> hashmap;
    private JSONObject user;

    Skincare skincare;
    MentalHealth mentalHealth;
    Nutrition nutrition;

    public User(String name, String gender, String diet, String religion) {
        this.name = name;
        this.gender = gender;

        this.hashmap = new HashMap<String,Object>();
        this.user = new JSONObject(hashmap);

        this.nutrition = new Nutrition(diet, religion);
        this.skincare = new Skincare();
        this.mentalHealth = new MentalHealth();

        updateUser();
    }

    public void setName(String name) {
        this.name = name;
        updateUser();
    }

    public void setGender(String gender) {
        this.gender = gender;
        updateUser();
    }

    public void setDiet(String diet) {
        this.nutrition.setDiet(diet);
        updateUser();
    }

    public void setReligion(String religion) {
        this.nutrition.setReligion(religion);
        updateUser();
    }
    
    @SuppressWarnings("unchecked")
    public void updateUser() {
        user.put("Name", this.name);
        user.put("Gender", this.gender);
        user.put("Diet", this.nutrition.getDiet());
        user.put("Religion", this.nutrition.getReligion());
        user.put("Meal Plan", this.nutrition.getMealPlan());
        user.put("Allergies", this.nutrition.getAllergies());
        user.put("Skincare Medication", this.skincare.getMedication());
        user.put("Skin Concerns", this.skincare.getConcerns());
        user.put("Skincare Routine", this.skincare.getRoutine());
        user.put("Mental Health Medication", this.mentalHealth.getMedication());

        Methods.updateData("data.json", this.user);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nGender: " + this.gender + "\nDiet: " + this.nutrition.getDiet() + "\nReligion: " + this.nutrition.getReligion() + "\nMeal Plan: " + this.nutrition.getMealPlan() + "\nAllergies: " + this.nutrition.getAllergies() + "\nSkincare Medication: " + this.skincare.getMedication() + "\nSkin Concerns: " + this.skincare.getConcerns() + "\nSkincare Routine: " + this.skincare.getRoutine() + "\nMental Health Medication: " + this.mentalHealth.getMedication();
    }

    
}
