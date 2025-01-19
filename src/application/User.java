package application;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * User datatype
 */

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

    public void setBreakfast(String breakfast) {
        nutrition.setBreakfast(breakfast);
        updateUser();
    }

    public void setLunch(String lunch) {
        nutrition.setLunch(lunch);
        updateUser();
    }

    public void setDinner(String dinner) {
        nutrition.setDinner(dinner);
        updateUser();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDiet() {
        return this.nutrition.getDiet();
    }

    public String getReligion() {
        return this.nutrition.getReligion();
    }

    public MealPlan getMealPlan() {
        return this.nutrition.getMealPlan();
    }

    public ArrayList<String> getSkincareRoutine() {
        return this.skincare.getRoutine();
    }

    public ArrayList<String> getSkinConcerns() {
        return this.skincare.getConcerns();
    }

    public void addToSkincareRoutine(String step) {
        this.skincare.addStepToRoutine(step);
        updateUser();
    }

    public void addToSkinConcerns(String concern) {
        this.skincare.addConcern(concern);
        updateUser();
    }

    public void addNutritionMedication(Medicine medication) {
        nutrition.addMedication(medication);
        updateUser();
    }

    public void addSkincareMedication(Medicine medication) {
        skincare.addMedication(medication);
        updateUser();
    }

    public boolean isOkayForMe(Scanner input, String food) {
        return nutrition.isOkayForMe(input, food);
    } 

    public String getDailyChallenge() {
        return this.mentalHealth.getDailyChallenge();
    }

    public void viewPreviousChallenges(Scanner input) {
        this.mentalHealth.viewPreviousChallenges(input);
    }

    public void addMentalHealthMedication(Medicine medication) {
        this.mentalHealth.addMedication(medication);
        updateUser();
    }

    public void addMentalHealthReminder(String reminder) {
        this.mentalHealth.addReminder(reminder);
        updateUser();
    }

    public ArrayList<String> getMentalHealthReminders() {
        return this.mentalHealth.getReminders();
    }

    public ArrayList<String> getAllergies() {
        return this.nutrition.getAllergies();
    }

    public void addAllergy(String allergy) {
        this.nutrition.addAllergy(allergy);
        updateUser();
    }

    public void resetAllergies() {
        this.nutrition.resetAllergies();
        updateUser();
    }

    public void resetNutrition() {
        this.nutrition.setBreakfast("");
        this.nutrition.setLunch("");
        this.nutrition.setDinner("");

        this.nutrition.resetAllergies();
        this.nutrition.resetMedication();
        this.nutrition.setDiet("");
        this.nutrition.setReligion("");
        updateUser();
    }

    public void resetSkincareRoutine() {
        this.skincare.resetRoutine();
        updateUser();
    }

    public void resetSkinConcerns() {
        this.skincare.resetConcerns();
        updateUser();
    }

    public void resetSkincare() {
        resetSkinConcerns();
        resetSkincareRoutine();
        this.skincare.resetMedication();

        updateUser();
    }

    public void resetMentalHealthReminders() {
        this.mentalHealth.resetReminders();
        updateUser();
    }

    public void resetMentalHealth() {
        this.mentalHealth.resetReminders();
        this.mentalHealth.resetMedication();
        updateUser();
    }

    public void resetUser() {
        this.name = "";
        this.gender = "";
        resetNutrition();
        resetSkincare();
        resetMentalHealth();
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
        user.put("Nutrition Medication", this.nutrition.getMedication());
        user.put("Skincare Medication", this.skincare.getMedication());
        user.put("Skin Concerns", this.skincare.getConcerns());
        user.put("Skincare Routine", this.skincare.getRoutine());
        user.put("Mental Health Medication", this.mentalHealth.getMedication());
        user.put("Reminders", this.mentalHealth.getReminders());

        Methods.updateData("data.json", this.user);
    }

    @Override
    public String toString() {
        return "Name: " + name +
        "\nGender: " + this.gender + 
        "\nDiet: " + this.nutrition.getDiet() + 
        "\nReligion: " + this.nutrition.getReligion() + 
        "\nMeal Plan: " + this.nutrition.getMealPlan() + 
        "\nAllergies: " + this.nutrition.getAllergies() + 
        "\nNutrition Medication: " + this.nutrition.getMedication() +
        "\nSkincare Medication: " + this.skincare.getMedication() + 
        "\nSkin Concerns: " + this.skincare.getConcerns() + 
        "\nSkincare Routine: " + this.skincare.getRoutine() + 
        "\nMental Health Medication: " + this.mentalHealth.getMedication() +
        "\nReminders: " + this.mentalHealth.getReminders();
    }
}