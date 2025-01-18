package application.unitTests;

/**
 * author: Allaine
 * date: 15/01/2025
 * Main Class Test File
 */

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
        User user = new User("Allaine", "Female", "Vegan", "Christian");
        // Act
        Main.changeUserInfo(input, user);
        String actual = user.getName();
        // Assert
        String expected = "John Doe";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();
    }

    @Test
    public void testChangeUserInfo2() {
        // Arrange
        // Simulate user input (choosing option 3 to change diet)
        String simulatedInput = "3\nPescatarian\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);
        User user = new User("Allen", "Male", "Keto", "Catholic");
        // Act
        Main.changeUserInfo(input, user);
        String actual = user.getDiet();
        // Assert
        String expected = "Pescatarian";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();
    }

    @Test
    public void testDisplayMainMenu1() {
        // Arrange
        // Simulate user input (choosing option 4)
        String simulatedInput = "4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        String actual = Main.displayMainMenu(input);
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

        // Act
        String actual = Main.displayMainMenu(input);
        // Assert
        String expected = "2";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayProfileMenu1() {
        // Arrange
        // Simulate user input (choosing option 2, choose option 1 to change name, then going back to main menu)
        String simulatedInput = "2\n1\nArwin\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Alex", "Male", "Vegetarian", "Christian");

        // Act
        String actual = Main.displayProfileMenu(input, user);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();
    }

    @Test
    public void testDisplayProfileMenu2() {
        // Arrange
        // Simulate user input (choosing option 3)
        String simulatedInput = "3";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Lani", "Female", "High Protein", "Catholic");

        // Act
        String actual = Main.displayProfileMenu(input, user);
        // Assert
        String expected = "Q";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();
    }

    @Test
    public void testDisplayMentalHealthMenu1() {
        // Arrange
        // Simulate user input (choosing option 1 then leaving menu)
        String simulatedInput = "1\n5";

        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Tarkan", "Male", "Normal", "Agnostic");

        // Act
        String actual = Main.displayMentalHealthMenu(input, user);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();
    }

    @Test
    public void testDisplayMentalHealthMenu2() {
        // Arrange
        // Simulate user input (choosing option 2, viewing a few previous challenges, then leaving menu)
        String simulatedInput = "2\ny\ny\ny\nn\n5";

        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Larry", "Male", "Pescatarian", "Agnostic");

        // Act
        String actual = Main.displayMentalHealthMenu(input, user);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();
    }

    @Test
    public void testDisplayNutritionMenu1() {
        // Arrange
        // Simulate user input (choosing option 2, adding iron deficiency pill, then leaving menu)
        String simulatedInput = "2\nIron Deficiency\n1\npill\n5";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Molly", "Female", "Normal", "Christian");

        // Act
        String actual = Main.displayNutritionMenu(input, user);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();       
    }

    @Test
    public void testDisplayNutritionMenu2() {
        // Arrange
        // Simulate user input (choosing option 3, checking if bacon is okay, then leaving menu)
        String simulatedInput = "3\nBacon\nn\ny\nn\nn\nn\nn\nn\n5";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Philip", "Male", "Normal", "Christian");

        // Act
        String actual = Main.displayNutritionMenu(input, user);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser();       
    }


    @Test
    public void testDisplaySkincareMenu1() {
        // Arrange
        // Simulate user input (choose option 1, adding a step to the routine, then leave menu)
        String simulatedInput = "1\n2\nUse Cleanser.\n4\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Nina", "Female", "Normal", "Muslim");

        // Act
        String actual = Main.displaySkincareMenu(input, user);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testDisplaySkincareMenu2() {
        // Arrange
        // Simulate user input (choose option 3, list down a skin concern, then leave menu)
        String simulatedInput = "3\n2\nDry Skin\n4\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Coco", "Male", "Normal", "Jewish");

        // Act
        String actual = Main.displaySkincareMenu(input, user);
        // Assert
        String expected = "";
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditAllergies1() {
        // Arrange
        // Simulate user input (adding a few allergies)
        String simulatedInput = "2\nPeanuts\n2\nDairy\n2\nEggs\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Sukaina", "Female", "Normal", "Muslim");

        // Act
        Main.editAllergies(input, user);
        ArrayList<String> actual = user.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Peanuts");
        expected.add("Dairy");
        expected.add("Eggs");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditAllergies2() {
        // Arrange
        // Simulate user input (adding a few allergies)
        String simulatedInput = "2\nPoultry\n2\nTomato\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Rei", "Female", "Normal", "Muslim");

        // Act
        Main.editAllergies(input, user);
        ArrayList<String> actual = user.getAllergies();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Poultry");
        expected.add("Tomato");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditMealPlan1() {
        // Arrange
        // Simulate user input (adding a few meals)
        String simulatedInput = "2\nOatmeal\n3\nSalad\n4\nChicken\n5";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Vix", "Female", "Normal", "Agnostic");

        // Act
        Main.editMealPlan(input, user);
        MealPlan actual = user.getMealPlan();

        // Assert
        MealPlan expected = new MealPlan();
        expected.setBreakfast("Oatmeal");
        expected.setLunch("Salad");
        expected.setDinner("Chicken");
        Assertions.assertEquals(expected.toString(), actual.toString());
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditMealPlan2() {
        // Arrange
        // Simulate user input (adding a few meals)
        String simulatedInput = "2\nCereal\n3\nSandwich\n4\nPasta\n5";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Rami", "Male", "Normal", "Muslim");

        // Act
        Main.editMealPlan(input, user);
        MealPlan actual = user.getMealPlan();

        // Assert
        MealPlan expected = new MealPlan();
        expected.setBreakfast("Cereal");
        expected.setLunch("Sandwich");
        expected.setDinner("Pasta");
        Assertions.assertEquals(expected.toString(), actual.toString());
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditReminders1() {
        // Arrange
        // Simulate user input (adding a few reminders)
        String simulatedInput = "2\nTake a walk\n2\nDrink water\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Kaviya", "Female", "Normal", "Hindu");

        // Act
        Main.editReminders(input, user);
        ArrayList<String> actual = user.getMentalHealthReminders();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Take a walk");
        expected.add("Drink water");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditReminders2() {
        // Arrange
        // Simulate user input (adding a few reminders)
        String simulatedInput =  "2\nGo to bed early\n2\nDo CPTs\n2\nGo to school\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Clark B", "Male", "Normal", "Christian");

        // Act
        Main.editReminders(input, user);
        ArrayList<String> actual = user.getMentalHealthReminders();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Go to bed early");
        expected.add("Do CPTs");
        expected.add("Go to school");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditSkinConcerns1() {
        // Arrange
        // Simulate user input (adding a few skin concerns)
        String simulatedInput = "2\nDry Skin\n2\nAcne\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Rando", "Male", "Vegan", "Atheist");

        // Act
        Main.editSkinConcerns(input, user);
        ArrayList<String> actual = user.getSkinConcerns();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Dry Skin");
        expected.add("Acne");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditSkinConcerns2() {
        // Arrange
        // Simulate user input (adding a few skin concerns)
        String simulatedInput = "2\nOily Skin\n2\nBlackheads\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Nick", "Male", "Vegan", "Agnostic");

        // Act
        Main.editSkinConcerns(input, user);
        ArrayList<String> actual = user.getSkinConcerns();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Oily Skin");
        expected.add("Blackheads");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }

    @Test
    public void testEditSkincareRoutine1() {
        // Arrange
        // Simulate user input (adding a few skincare routine steps)
        String simulatedInput = "2\nUse Cleanser\n2\nApply Toner\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Fritz", "Male", "Pescatarian", "Christian");

        // Act
        Main.editSkincareRoutine(input, user);
        ArrayList<String> actual = user.getSkincareRoutine();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("1. Use Cleanser");
        expected.add("2. Apply Toner");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }
    @Test
    public void testEditSkincareRoutine2() {
        // Arrange
        // Simulate user input (adding a few skincare routine steps)
        String simulatedInput = "2\nUse Cleanser\n2\nApply Toner\n2\nApply Serum\n2\nApply Moisturizer\n4";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        User user = new User("Jena", "Female", "Normal", "Christian");

        // Act
        Main.editSkincareRoutine(input, user);
        ArrayList<String> actual = user.getSkincareRoutine();
        // Assert
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("1. Use Cleanser");
        expected.add("2. Apply Toner");
        expected.add("3. Apply Serum");
        expected.add("4. Apply Moisturizer");
        Assertions.assertEquals(expected, actual);
        // Reset user info for the next test case
        user.resetUser(); 
    }
}
