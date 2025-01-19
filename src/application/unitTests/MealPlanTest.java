package application.unitTests;

import org.junit.jupiter.api.*;
import application.main.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Meal Plan datatype Unit Tests
 */

 /**
  * Unit tests for the MealPlan class
  */
public class MealPlanTest {
    @Test
    void testToString1() {
       // Arrange
       MealPlan mealPlan = new MealPlan();
       mealPlan.setBreakfast("pancakes");
       mealPlan.setLunch("pesto pizza");
       mealPlan.setDinner("mushroom pasta");

       // Act
       String actual = mealPlan.toString();

       // Assert
       String expected = "[\"breakfast: pancakes\", \"lunch: pesto pizza\", \"dinner: mushroom pasta\"]";
       Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToString2() {
       // Arrange
       MealPlan mealPlan = new MealPlan();
       mealPlan.setBreakfast("grilled cheese sandwich");
       mealPlan.setLunch("salad");
       mealPlan.setDinner("dumplings");
       mealPlan.setDinner("ramen");

       // Act
       String actual = mealPlan.toString();

       // Assert
       String expected = "[\"breakfast: grilled cheese sandwich\", \"lunch: salad\", \"dinner: ramen\"]";
       Assertions.assertEquals(expected, actual);
    }
}