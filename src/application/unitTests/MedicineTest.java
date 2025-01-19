package application.unitTests;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.*;
import application.main.Medicine;
import application.medicines.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Medicine datatype Unit Tests
 */

 /**
  * Unit tests for the Medicine class
  */
public class MedicineTest {
    @Test
    void testNewMedicine1() {
        // Arrange
        // Simulate user input (Paracetamol, 3x, Syrup)
        String simulatedInput = "Paracetamol\n3\nSyrup";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Medicine.newMedicine(input);

        // Assert
        Medicine expected = new Syrup("Paracetamol", 3);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testNewMedicine2() {
        // Arrange
        // Simulate user input (FeraMAX, 1x, Pill)
        String simulatedInput = "FeraMAX\n1\nPill";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Medicine.newMedicine(input);

        // Assert
        Medicine expected = new Pill("FeraMAX", 1);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testNewMedicine3() {
        // Arrange
        // Simulate user input (Hydrocortisone, 2x, Cream)
        String simulatedInput = "Hydrocortisone\n2\nCream";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Cream.newMedicine(input);

        // Assert
        Cream expected = new Cream("Hydrocortisone", 2);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testNewMedicine4() {
        // Arrange
        // Simulate user input (Salicylic Acid, 2x, Serum)
        String simulatedInput = "Salicylic Acid\n2\nSerum";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Medicine.newMedicine(input);

        // Assert
        Medicine expected = new Serum("Salicylic Acid", 2);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testToString1() {
        // Arrange
        // Simulate user input (Tylenol , 2x, Pill)
        String simulatedInput = "Tylenol\n2\nPill";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        String actual = Medicine.newMedicine(input).toString();

        // Assert
        String expected = "\"Pill: Tylenol | 2x\"";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToString2() {
        // Arrange
        // Simulate user input (Bioderm, 3x, Cream)
        String simulatedInput = "Bioderm\n3\nCream";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        String actual = Medicine.newMedicine(input).toString();

        // Assert
        String expected = "\"Cream: Bioderm | 3x\"";
        Assertions.assertEquals(expected, actual);
    }
}
