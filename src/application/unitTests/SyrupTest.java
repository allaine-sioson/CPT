package application.unitTests;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.*;
import application.medicines.*;
import application.main.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Syrup datatype Unit Tests
 */

 /**
  * Unit tests for the Syrup class
  */
public class SyrupTest {
    @Test
    public void testNewMedicine() {
        // Arrange
        // Simulate user input (Paracetamol, 3x, Syrup)
        String simulatedInput = "Paracetamol\n3\nSyrup";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Syrup.newMedicine(input);

        // Assert
        Medicine expected = new Syrup("Paracetamol", 3);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testToString() {
        // Arrange
        // Simulate user input (Antihistamine, 2x, Syrup)
        String simulatedInput = "Antihistamine\n2\nSyrup";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        String actual = Syrup.newMedicine(input).toString();

        // Assert
        String expected = "\"Syrup: Antihistamine | 2x\"";
        Assertions.assertEquals(expected, actual);
    }
}
