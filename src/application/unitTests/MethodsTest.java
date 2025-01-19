package application.unitTests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.main.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Methods datatype Unit Tests
 */

public class MethodsTest {
    @BeforeEach void resetUser() {
        // just in case the reset user method in each test case fails
        User user = new User("John Doe", "Male", "Vegan", "Christian");
        user.resetUser();
    }

    @Test
    void testCheckForEmpty1() {
        // Arrange
        String[] array = {"Cheese"};
        // Act
        boolean actual = Methods.checkForEmpty(array);
        // Assert
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCheckForEmpty2() {
        // Arrange
        String[] array = {};
        // Act
        boolean actual = Methods.checkForEmpty(array);
        // Assert
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCheckForEmpty3() {
        // Arrange
        String[] array = {""};
        // Act
        boolean actual = Methods.checkForEmpty(array);
        // Assert
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetArrayData1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        user.setBreakfast("Vegan Pandesal");
        user.setLunch("Stir Fried Veggies");
        user.setDinner("Mushroom Soup");

        // Act
        String[] actual = Methods.getArrayData("main\\data.json", "Meal Plan");
        // Assert
        String[] expected = {"breakfast: Vegan Pandesal", "lunch: Stir Fried Veggies", "dinner: Mushroom Soup"};
        Assertions.assertArrayEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    void testGetArrayData2() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        user.addAllergy("Peanuts");
        user.addAllergy("Dairy");

        // Act
        String[] actual = Methods.getArrayData("main\\data.json", "Allergies");
        // Assert
        String[] expected = {"Peanuts", "Dairy"};
        Assertions.assertArrayEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    void testGetCurrentDate() {
        // Arrange
        // get the current local time
        LocalDate date = LocalDate.now();

        // format the date into MM / dd
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd");

        // Actual
        String actual = Methods.getCurrentDate();

        // Assert
        String expected = date.format(formatDate);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetStringData1() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        // Act
        String actual = Methods.getStringData("main\\data.json", "Name");
        // Assert
        String expected = "Allaine";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    void testGetStringData2() {
        // Arrange
        User user = new User("Allaine","Female","Vegetarian","Catholic");
        // Act
        String actual = Methods.getStringData("main\\data.json", "Religion");
        // Assert
        String expected = "Catholic";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    void testReadFile1() {
        // Arrange 
        String filename = "assets\\diets\\veganData.txt";
        // Act
        String actual = Methods.readFile(filename);
        // Assert
        String expected = "Beef, Pork, poultry, seafood, animal by-products such as dairy and bee products";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testReadFile2() {
        // Arrange 
        String filename = "assets\\religions\\muslimData.txt";
        // Act
        String actual = Methods.readFile(filename);
        // Assert
        String expected = "pork, non-halal";
        Assertions.assertEquals(expected, actual);
    }
}
