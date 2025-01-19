package application.unitTests;

import java.io.*;
import java.util.*;
import org.junit.jupiter.api.*;
import application.*;
import application.medicines.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Pill datatype Unit Tests
 */

public class PillTest {
    @Test
    public void testNewMedicine() {
        // Arrange
        // Simulate user input (FeraMAX, 1x, Pill)
        String simulatedInput = "FeraMAX\n1\nPill";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        Medicine actual = Pill.newMedicine(input);

        // Assert
        Medicine expected = new Pill("FeraMAX", 1);
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void testToString() {
        // Arrange
        // Simulate user input (Tylenol , 2x, Pill)
        String simulatedInput = "Tylenol\n2\nPill";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner input = new Scanner(inputStream);

        // Act
        String actual = Pill.newMedicine(input).toString();

        // Assert
        String expected = "\"Pill: Tylenol | 2x\"";
        Assertions.assertEquals(expected, actual);
    }
}
