package application.unitTests;

import java.io.*;
import java.util.*;
import org.junit.jupiter.api.*;

import application.main.*;
import application.medicines.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Serum datatype Unit Tests
 */

 /**
  * Unit tests for the Serum class
  */
public class SerumTest {
    @Test
    public void testNewMedicine() {
        // Arrange
        // Simulate user input (Salicylic Acid, 2x, Serum)
        String simulatedInput = "Salicylic Acid\n2\nSerum";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Serum.newMedicine(input);

        // Assert
        Medicine expected = new Serum("Salicylic Acid", 2);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testToString() {
        // Arrange
        // Simulate user input (Niacinamide , 1x, Serum)
        String simulatedInput = "Niacinamide\n1\nSerum";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        String actual = Serum.newMedicine(input).toString();

        // Assert
        String expected = "\"Serum: Niacinamide | 1x\"";
        Assertions.assertEquals(expected, actual);
    }
}
