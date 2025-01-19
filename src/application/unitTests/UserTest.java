package application.unitTests;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * User datatype Unit Tests
 */

import org.junit.jupiter.api.*;
import application.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

public class UserTest {
    @Test
    public void testAddAllergy1() {
        // Arrange
        User user = new User("John Doe", "Male", "Carnivore", "Christian");
        // Act
        user.addAllergy("Peanuts");
        ArrayList<String> actual = user.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Peanuts");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    public void testAddAllergy2() {
        // Arrange
        User user = new User("Jane Doe", "Female", "Vegan", "Atheist");
        // Act
        user.addAllergy("Cheese");
        user.addAllergy("Chicken");
        ArrayList<String> actual = user.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Cheese");
        expected.add("Chicken");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }
    
    @Test
    void testGetAllergies1() {
        // Arrange
        User user = new User("Allaine", "Female", "Vegetarian", "Catholic");
        user.addAllergy("Peanuts");
        // Act
        ArrayList<String> actual = user.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Peanuts");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetAllergies2() {
        // Arrange
        User user = new User("Allen", "Male", "Pescatarian", "Christian");
        user.addAllergy("Honey");
        user.addAllergy("Milk");
        // Act
        ArrayList<String> actual = user.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Honey");
        expected.add("Milk");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetDailyChallenge() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        // Act
        String actual = user.getDailyChallenge();
        // Assert
        String expected = user.getDailyChallenge();
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetDiet1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        // Act
        String actual = user.getDiet();
        // Assert
        String expected = "Vegetarian";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetDiet2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        // Act
        String actual = user.getDiet();
        // Assert
        String expected = "Pescatarian";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetGender1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        // Act
        String actual = user.getGender();
        // Assert
        String expected = "Female";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetGender2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        // Act
        String actual = user.getGender();
        // Assert
        String expected = "Male";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetMealPlan1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        user.setBreakfast("Vegan Pandesal");
        user.setLunch("Stir Fried Veggies");
        user.setDinner("Mushroom Soup");
        // Act
        MealPlan actual = user.getMealPlan();
        // Assert
        MealPlan expected = new MealPlan();
        expected.setBreakfast("Vegan Pandesal");
        expected.setLunch("Stir Fried Veggies");
        expected.setDinner("Mushroom Soup");
        Assertions.assertEquals(expected.toString(), actual.toString());
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetMealPlan2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        user.setBreakfast("Whole Wheat Bread");
        user.setLunch("Seafood Boil");
        user.setDinner("Siningang na Isda"); // Fish Sinigang
        // Act
        MealPlan actual = user.getMealPlan();
        // Assert
        MealPlan expected = new MealPlan();
        expected.setBreakfast("Whole Wheat Bread");
        expected.setLunch("Seafood Boil");
        expected.setDinner("Siningang na Isda");
        Assertions.assertEquals(expected.toString(), actual.toString());
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetMentalHealthReminders1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        user.addMentalHealthReminder("Take a walk");
        user.addMentalHealthReminder("Drink water");
        // Act
        ArrayList<String> actual = user.getMentalHealthReminders();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Take a walk");
        expected.add("Drink water");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetMentalHealthReminders2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        user.addMentalHealthReminder("Meditate");
        user.addMentalHealthReminder("Journal");
        user.addMentalHealthReminder("Exercise");
        user.addMentalHealthReminder("Sleep early");
        // Act
        ArrayList<String> actual = user.getMentalHealthReminders();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Meditate");
        expected.add("Journal");
        expected.add("Exercise");
        expected.add("Sleep early");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetName1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        // Act
        String actual = user.getName();
        // Assert
        String expected = "Allaine";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetName2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        // Act
        String actual = user.getName();
        // Assert
        String expected = "Allen";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetReligion1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        // Act
        String actual = user.getReligion();
        // Assert
        String expected = "Catholic";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetReligion2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        // Act
        String actual = user.getReligion();
        // Assert
        String expected = "Christian";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetSkinConcerns1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        user.addToSkinConcerns("Acne");
        user.addToSkinConcerns("Dry skin");
        // Act
        ArrayList<String> actual = user.getSkinConcerns();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Acne");
        expected.add("Dry skin");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetSkinConcerns2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        user.addToSkinConcerns("Oily skin");
        user.addToSkinConcerns("Wrinkles");
        user.addToSkinConcerns("Dark spots");
        // Act
        ArrayList<String> actual = user.getSkinConcerns();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Oily skin");
        expected.add("Wrinkles");
        expected.add("Dark spots");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetSkincareRoutine1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        user.addToSkincareRoutine("Cleanse");
        user.addToSkincareRoutine("Tone");
        // Act
        ArrayList<String> actual = user.getSkincareRoutine();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("1. Cleanse");
        expected.add("2. Tone");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testGetSkincareRoutine2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        user.addToSkincareRoutine("Exfoliate");
        user.addToSkincareRoutine("Moisturize");
        user.addToSkincareRoutine("Sunscreen");
        // Act
        ArrayList<String> actual = user.getSkincareRoutine();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("1. Exfoliate");
        expected.add("2. Moisturize");
        expected.add("3. Sunscreen");
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testIsOkayForMe1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        user.addAllergy("Peanuts");

        // Simulate user input (saying no to every question besides the one asking if it contains peanuts)
        String simulatedInput = "n\nn\nn\nn\nn\nn\nn\ny";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        boolean actual = user.isOkayForMe(input, "Peanuts");

        // Assert
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testIsOkayForMe2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
     
        // Simulate user input (saying no to every question besides the one asking if it contains pork) 
        String simulatedInput = "n\ny\nn\nn\nn\nn\nn";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        boolean actual = user.isOkayForMe(input, "Pork Adobo");

        // Assert
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testIsOkayForMe3() {
        // Arrange
        User user = new User("Andy","Male","Normal","Christian");
     
        // Simulate user input (saying no to every question besides the one asking if it contains beef) 
        String simulatedInput = "y\nn\nn\nn\nn\nn\nn";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        boolean actual = user.isOkayForMe(input, "Steak");

        // Assert
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testToString1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");

        // Act
        String actual = user.toString();

        // Assert
        String expected = "Name: Allaine" + 
        "\nGender: Female" + 
        "\nDiet: Vegetarian" + 
        "\nReligion: Catholic" + 
        "\nMeal Plan: [\"breakfast: \", \"lunch: \", \"dinner: \"]" + 
        "\nAllergies: []" + 
        "\nNutrition Medication: []" +
        "\nSkincare Medication: []" + 
        "\nSkin Concerns: []" + 
        "\nSkincare Routine: []" +
        "\nMental Health Medication: []" +
        "\nReminders: []";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }

    @Test
    void testToString2() {
        // Arrange
        User user = new User("Allen","Male","Pescatarian","Christian");
        user.setBreakfast("Whole Wheat Bread");
        user.setLunch("Seafood Boil");
        user.setDinner("Sinigang na Isda"); // Fish Sinigang

        user.addAllergy("Cheese");
        user.addAllergy("Chicken");

        user.addToSkincareRoutine("Wash Face");
        user.addToSkincareRoutine("Apply Toner");
        user.addToSkincareRoutine("Moisturize");

        user.addMentalHealthReminder("Meditate");
        user.addMentalHealthReminder("Journal");
        user.addMentalHealthReminder("Exercise");
        user.addMentalHealthReminder("Sleep early");
        // Act
        String actual = user.toString();

        // Assert
        String expected = "Name: Allen" + 
        "\nGender: Male" + 
        "\nDiet: Pescatarian" + 
        "\nReligion: Christian" + 
        "\nMeal Plan: [\"breakfast: Whole Wheat Bread\", \"lunch: Seafood Boil\", \"dinner: Sinigang na Isda\"]" + 
        "\nAllergies: [Cheese, Chicken]" + 
        "\nNutrition Medication: []" +
        "\nSkincare Medication: []" + 
        "\nSkin Concerns: []" + 
        "\nSkincare Routine: [1. Wash Face, 2. Apply Toner, 3. Moisturize]" +
        "\nMental Health Medication: []" +
        "\nReminders: [Meditate, Journal, Exercise, Sleep early]";
        Assertions.assertEquals(expected, actual);
        // reset user info for next test
        user.resetUser();
    }
}
