package application.unitTests;

import java.io.*;
import java.util.*;
import org.junit.jupiter.api.*;
import application.*;

public class MainTest {
    @Test
    public void testChangeUserInfo1() {
        // Arrange
        // Simulate user input (choosing option 1 to change name)
        String simulatedInput = "1\nJohn Doe\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String name = "Allaine";
        String gender = "Female";
        String diet = "Vegan";
        String religion = "Christian";

        User user = new User(name, gender, diet, religion);
        // Act
        Main.changeUserInfo(input, user, name, gender, diet, religion);
        String actual = user.getName();
        // Assert
        String expected = "John Doe";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testChangeUserInfo2() {
        // Arrange
        // Simulate user input (choosing option 3 to change diet)
        String simulatedInput = "3\nPescatarian\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String name = "Allen";
        String gender = "Male";
        String diet = "Keto";
        String religion = "Muslim";

        User user = new User(name, gender, diet, religion);
        // Act
        Main.changeUserInfo(input, user, name, gender, diet, religion);
        String actual = user.getDiet();
        // Assert
        String expected = "Pescatarian";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayMainMenu1() {
        // Arrange
        // Simulate user input (choosing option 4)
        String simulatedInput = "4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String name = "Tarkan";
        String gender = "Male";
        String diet = "Normal";
        String religion = "Agnostic";

        // Act
        String actual = Main.displayMainMenu(input, name, gender, diet, religion);
        // Assert
        String expected = "4";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayMainMenu2() {
        // Arrange
        // Simulate user input (choosing option 2)
        String simulatedInput = "2";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String name = "Larry";
        String gender = "Male";
        String diet = "Pescatarian";
        String religion = "Agnostic";

        // Act
        String actual = Main.displayMainMenu(input, name, gender, diet, religion);
        // Assert
        String expected = "2";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayProfileMenu1() {
        // Arrange
        // Simulate user input (choosing option 1 then going back to main menu)
        String simulatedInput = "1\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String name = "Carl";
        String gender = "Male";
        String diet = "Normal";
        String religion = "Christian";

        User user = new User(name, gender, diet, religion);

        // Act
        String actual = Main.displayProfileMenu(input, user, name, gender, diet, religion);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayProfileMenu2() {
        // Arrange
        // Simulate user input (choosing option 2, choose option 1 to change name, then going back to main menu)
        String simulatedInput = "2\n1\nArwin\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String name = "Alex";
        String gender = "Male";
        String diet = "Vegetarian";
        String religion = "Christian";

        User user = new User(name, gender, diet, religion);

        // Act
        String actual = Main.displayProfileMenu(input, user, name, gender, diet, religion);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayProfileMenu3() {
        // Arrange
        // Simulate user input (choosing option 3)
        String simulatedInput = "3";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String name = "Lani";
        String gender = "Female";
        String diet = "High Protein";
        String religion = "Catholic";

        User user = new User(name, gender, diet, religion);

        // Act
        String actual = Main.displayProfileMenu(input, user, name, gender, diet, religion);
        // Assert
        String expected = "Q";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayProfileMenuResults1() {
        // Arrange
        Scanner input = new Scanner(System.in);
        // choose option 3
        String choice = "3";

        String name = "Aliyah";
        String gender = "Female";
        String diet = "Normal";
        String religion = "Muslim";

        User user = new User(name, gender, diet, religion);

        // Act
        String actual = Main.displayProfileMenuResults(input, choice, user, name, gender, diet, religion);
        // Assert
        String expected = "Q";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayProfileMenuResults2() {
        // Arrange
        // Simulate changing name, displaying info and going back
        String simulatedInput = "1\nJacob\n1\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        String choice = "2";

        String name = "Jake";
        String gender = "Male";
        String diet = "Normal";
        String religion = "Jewish";

        User user = new User(name, gender, diet, religion);

        // Act
        String actual = Main.displayProfileMenuResults(input, choice, user, name, gender, diet, religion);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
    }
}
