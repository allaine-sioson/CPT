package application.main;

import java.util.*;
import org.json.simple.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * User datatype
 */

 /**
  * The User class represents the user's profile with information related to their nutrition, skincare, and mental health.
  */
public class User {
    private String name, gender;
    private HashMap<String,Object> hashmap;
    private JSONObject user;

    Skincare skincare;
    MentalHealth mentalHealth;
    Nutrition nutrition;

    /**
     * Constructor for User class
     * @param name the name of user
     * @param gender the gender of user
     * @param diet the diet of user
     * @param religion the religion of user
     */
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

    /**
     * sets the name of the user
     * @param name the new name of user
     */
    public void setName(String name) {
        this.name = name;
        updateUser();
    }

    /**
     * sets the gender of the user
     * @param gender the new gender of the user
     */
    public void setGender(String gender) {
        this.gender = gender;
        updateUser();
    }

    /**
     * sets the diet of the user
     * @param diet the new diet of the user
     */
    public void setDiet(String diet) {
        this.nutrition.setDiet(diet);
        updateUser();
    }

    /**
     * sets the religion of the user
     * @param religion the new diet of the user
     */
    public void setReligion(String religion) {
        this.nutrition.setReligion(religion);
        updateUser();
    }

    /**
     * sets the breakfast of the user's meal plan
     * @param breakfast the new breakfast of the user's meal plan
     */
    public void setBreakfast(String breakfast) {
        nutrition.setBreakfast(breakfast);
        updateUser();
    }

    /**
     * sets the lunch of the user's meal plan
     * @param lunch the new lunch of the user's meal plan
     */
    public void setLunch(String lunch) {
        nutrition.setLunch(lunch);
        updateUser();
    }

    /**
     * sets the dinner of the user's meal plan
     * @param dinner the new dinner of the user's meal plan
     */
    public void setDinner(String dinner) {
        nutrition.setDinner(dinner);
        updateUser();
    }

    /**
     * gets the current name of the user
     * @return the current name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * gets the current gender of the user
     * @return the current gender of the user
     */
    public String getGender() {
        return gender;
    }

    /**
     * gets the current diet of the user
     * @return the current diet of the user
     */
    public String getDiet() {
        return this.nutrition.getDiet();
    }

    /**
     * gets the current religion of the user
     * @return the current religion of the user
     */
    public String getReligion() {
        return this.nutrition.getReligion();
    }

    /**
     * gets the current meal plan of the user
     * @return the current meal plan of the user
     */
    public MealPlan getMealPlan() {
        return this.nutrition.getMealPlan();
    }

    /**
     * gets the current skincare routine of the user
     * @return the current skincare routine of the user
     */
    public ArrayList<String> getSkincareRoutine() {
        return this.skincare.getRoutine();
    }

    /**
     * gets the current skin concerns of the user
     * @return the current skin concerns of the user
     */
    public ArrayList<String> getSkinConcerns() {
        return this.skincare.getConcerns();
    }

    /**
     * adds a new step to the current skincare routine of the user
     * @param step the new step to be added
     */
    public void addToSkincareRoutine(String step) {
        this.skincare.addStepToRoutine(step);
        updateUser();
    }

    /**
     * adds a new concern to the list of skin concerns the user has
     * @param concern the new concern to be added
     */
    public void addToSkinConcerns(String concern) {
        this.skincare.addConcern(concern);
        updateUser();
    }

    /**
     * adds a new medicine to the Nutritional medications the user has
     * @param medication the new medicine to be added
     */
    public void addNutritionMedication(Medicine medication) {
        nutrition.addMedication(medication);
        updateUser();
    }

     /**
     * adds a new medicine to the Skincare medications the user has
     * @param medication the new medicine to be added
     */
    public void addSkincareMedication(Medicine medication) {
        skincare.addMedication(medication);
        updateUser();
    }

    /**
     * adds a new medicine to the Mental Health medications the user has
     * @param medication the new medicine to be added
     */
    public void addMentalHealthMedication(Medicine medication) {
        this.mentalHealth.addMedication(medication);
        updateUser();
    }

    /**
     * returns whether or not the food is okay for the user
     * @param input scanner to allow user input
     * @param food food to be checked
     * @return true if food is okay, false if food is not
     */
    public boolean isOkayForMe(Scanner input, String food) {
        return nutrition.isOkayForMe(input, food);
    } 

    /**
     * gets the daily challenge
     * @return the daily challenge
     */
    public String getDailyChallenge() {
        return this.mentalHealth.getDailyChallenge();
    }

    /**
     * gets the previous challenges and allows the user to view them
     * @param input scanner to allow user input
     */
    public void viewPreviousChallenges(Scanner input) {
        this.mentalHealth.viewPreviousChallenges(input);
    }

    /**
     * adds a new reminder to the list of reminders the user has
     * @param reminder the reminder to be added
     */
    public void addMentalHealthReminder(String reminder) {
        this.mentalHealth.addReminder(reminder);
        updateUser();
    }

    /**
     * gets the user's reminders
     * @return the reminders of the user
     */
    public ArrayList<String> getReminders() {
        return this.mentalHealth.getReminders();
    }

    /**
     * gets the user's allergies
     * @return the user's allergies
     */
    public ArrayList<String> getAllergies() {
        return this.nutrition.getAllergies();
    }

    /**
     * adds a new allergy to the list of allergies the user has
     * @param allergy the new allergy to be added
     */
    public void addAllergy(String allergy) {
        this.nutrition.addAllergy(allergy);
        updateUser();
    }

    /**
     * resets the user's allergies
     */
    public void resetAllergies() {
        this.nutrition.resetAllergies();
        updateUser();
    }

    /**
     * resets the user's nutritional information
     */
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

    /**
     * resets the user's skincare routine
     */
    public void resetSkincareRoutine() {
        this.skincare.resetRoutine();
        updateUser();
    }

    /**
     * resets the user's skin concerns
     */
    public void resetSkinConcerns() {
        this.skincare.resetConcerns();
        updateUser();
    }

    /**
     * resets the user's skincare information
     */
    public void resetSkincare() {
        resetSkinConcerns();
        resetSkincareRoutine();
        this.skincare.resetMedication();

        updateUser();
    }

    /**
     * resets the user's reminders
     */
    public void resetReminders() {
        this.mentalHealth.resetReminders();
        updateUser();
    }

    /**
     * resets the user's mental health information
     */
    public void resetMentalHealth() {
        this.mentalHealth.resetReminders();
        this.mentalHealth.resetMedication();
        updateUser();
    }

    /**
     * resets all of the user's information
     */
    public void resetUser() {
        this.name = "";
        this.gender = "";
        resetNutrition();
        resetSkincare();
        resetMentalHealth();
        updateUser();
    }
    
    /**
     * updates the user's information in the data.json file
     */
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

        Methods.updateData("main\\data.json", this.user);
    }

    /**
     * returns a string representation of the user class
     */
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