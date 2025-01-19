package application.unitTests;

import java.util.*;
import org.junit.jupiter.api.*;
import application.*;
import application.medicines.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Mental Health datatype Unit Tests
 */

public class MentalHealthTest {
    @Test
    void testGetMedication() {
        // Arrange
        MentalHealth mentalHealth = new MentalHealth();
        mentalHealth.addMedication(new Pill("Lisdexamfetamine", 1));

        // Act
        ArrayList<Medicine> actual = mentalHealth.getMedication();
        
        // Assert
        ArrayList<Medicine> expected = new ArrayList<>();
        expected.add(new Pill("Lisdexamfetamine", 1));
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetReminders() {
        // Arrange
        MentalHealth mentalHealth = new MentalHealth();
        mentalHealth.addReminder("Finish CPTs");
        mentalHealth.addReminder("Study for exams");

        // Act
        ArrayList<String> actual = mentalHealth.getReminders();
        
        // Assert
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Finish CPTs");
        expected.add("Study for exams");
        Assertions.assertEquals(expected, actual);
    }
}