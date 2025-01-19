package application.unitTests;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.*;
import application.*;
import application.medicines.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Cream datatype Unit Tests
 */

public class CreamTest {
    @Test
    public void testNewMedicine() {
        // Arrange
        // Simulate user input (Hydrocortisone, 2x, Cream)
        String simulatedInput = "Hydrocortisone\n2\nCream";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Medicine.newMedicine(input);

        // Assert
        Cream expected = new Cream("Hydrocortisone", 2);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testToString() {
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
