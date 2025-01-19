package application.unitTests;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.*;
import application.main.*;
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
        Medicine actual = Cream.newMedicine(input);

        // Assert
        Medicine expected = new Cream("Hydrocortisone", 2);
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
        String actual = Cream.newMedicine(input).toString();

        // Assert
        String expected = "\"Cream: Bioderm | 3x\"";
        Assertions.assertEquals(expected, actual);
    }
}
