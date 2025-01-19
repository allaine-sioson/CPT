package application.unitTests;

import java.io.*;
import java.util.*;
import org.junit.jupiter.api.*;
import application.main.*;
import application.medicines.*;


/**
 * @author: Allaine
 * @date: 18/01/2025
 * Nutrition datatype Unit Tests
 */

public class NutritionTest {
    @Test
    void testGetAllergies1() {
        // Arrange
        Nutrition nutrition = new Nutrition("Vegan", "Muslim");
        nutrition.addAllergy("Peanuts");
        // Act
        ArrayList<String> actual = nutrition.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Peanuts");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetAllergies2() {
        // Arrange
        Nutrition nutrition = new Nutrition("Pescatarian", "Catholic");
        // Act
        ArrayList<String> actual = nutrition.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetDiet1() {
        // Arrange
        Nutrition nutrition = new Nutrition("Vegan", "Muslim");
        // Act
        String actual = nutrition.getDiet();
        // Assert
        String expected = "Vegan";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetDiet2() {
        // Arrange
        Nutrition nutrition = new Nutrition("Normal", "Christian");
        // Act
        String actual = nutrition.getDiet();
        // Assert
        String expected = "Normal";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMealPlan1() {
        // Arrange
        Nutrition nutrition = new Nutrition("Normal", "Christian");
        nutrition.setBreakfast("Pancakes");
        nutrition.setLunch("Bulalo");
        nutrition.setDinner("Shawarma");
        // Act
        MealPlan actual = nutrition.getMealPlan();
        // Assert
        MealPlan expected = new MealPlan();
        expected.setBreakfast("Pancakes");
        expected.setLunch("Bulalo");
        expected.setDinner("Shawarma");
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetMealPlan2() {
        // Arrange
        Nutrition nutrition = new Nutrition("Normal", "Christian");
        // Act
        MealPlan actual = nutrition.getMealPlan();
        // Assert
        MealPlan expected = new MealPlan();
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetMedication() {
        // Arrange
        Nutrition nutrition = new Nutrition("Normal", "Christian");
        nutrition.addMedication(new Pill("FeraMAX", 1));

        // Act
        ArrayList<Medicine> actual = nutrition.getMedication();
        
        // Assert
        ArrayList<Medicine> expected = new ArrayList<>();
        expected.add(new Pill("FeraMAX", 1));
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetReligion1() {
        // Arrange
        Nutrition nutrition = new Nutrition("Vegan", "Muslim");
        // Act
        String actual = nutrition.getReligion();
        // Assert
        String expected = "Muslim";
        Assertions.assertEquals(expected, actual);  
    }

    @Test
    void testGetReligion2() {
        // Arrange
        Nutrition nutrition = new Nutrition("Normal", "Christian");
        // Act
        String actual = nutrition.getReligion();
        // Assert
        String expected = "Christian";
        Assertions.assertEquals(expected, actual);  
    }

    @Test
    void testIsOkayForMe1() {
        // Arrange
        Nutrition nutrition = new Nutrition("Vegan", "Muslim");
     
        // Simulate user input (saying no to every question besides the one asking if it contains beef) 
        String simulatedInput = "y\nn\nn\nn\nn\nn";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        boolean actual = nutrition.isOkayForMe(input, "Steak");

        // Assert
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIsOkayForMe2() {
        // Arrange
        Nutrition nutrition = new Nutrition("Vegan", "Muslim");
        nutrition.addAllergy("Peanuts");
     
        // Simulate user input (saying no to every question besides the one asking if it contains peanuts) 
        String simulatedInput = "y\nn\nn\nn\nn\nn\nn";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        boolean actual = nutrition.isOkayForMe(input, "Peanuts");

        // Assert
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIsOkayForMe3() {
        // Arrange
        Nutrition nutrition = new Nutrition("Vegan", "Christian");
        nutrition.addAllergy("Peanuts");
     
        // Simulate user input (saying no to every question) 
        String simulatedInput = "n\nn\nn\nn\nn\nn\nn";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        boolean actual = nutrition.isOkayForMe(input, "Spinach");

        // Assert
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
}