package application.unitTests;

import org.junit.jupiter.api.*;
import java.util.*;
import application.medicines.*;
import application.*;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Skincare datatype Unit Tests
 */

public class SkincareTest {
    @Test
    void testGetConcerns1() {
        // Arrange
        Skincare skincare = new Skincare();
        skincare.addConcern("Dryness");
        skincare.addConcern("Acne");

        // Act
        ArrayList<String> actual = skincare.getConcerns();
        
        // Assert
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Dryness");
        expected.add("Acne");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetConcerns2() {
        // Arrange
        Skincare skincare = new Skincare();
        skincare.addConcern("Wrinkles");
        skincare.addConcern("Dark Spots");
        skincare.addConcern("Whiteheads");

        // Act
        ArrayList<String> actual = skincare.getConcerns();
        
        // Assert
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Wrinkles");
        expected.add("Dark Spots");
        expected.add("Whiteheads");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetMedication1() {
        // Arrange
        Skincare skincare = new Skincare();
        skincare.addMedication(new Serum("Niacinamide", 2));
        skincare.addMedication(new Cream("Hydrocortisone", 1));

        // Act
        ArrayList<Medicine> actual = skincare.getMedication();
        
        // Assert
        ArrayList<Medicine> expected = new ArrayList<>();
        expected.add(new Serum("Niacinamide", 2));
        expected.add(new Cream("Hydrocortisone", 1));
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetMedication2() {
        // Arrange
        Skincare skincare = new Skincare();
        skincare.addMedication(new Serum("Salicylic Acid", 2));

        // Act
        ArrayList<Medicine> actual = skincare.getMedication();
        
        // Assert
        ArrayList<Medicine> expected = new ArrayList<>();
        expected.add(new Serum("Salicylic Acid", 2));
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testGetRoutine1() {
        // Arrange
        Skincare skincare = new Skincare();
        skincare.addStepToRoutine("Wash Face");
        skincare.addStepToRoutine("Apply Toner");
        skincare.addStepToRoutine("Apply Serums");
        skincare.addStepToRoutine("Moisturize");

        // Act
        ArrayList<String> actual = skincare.getRoutine();
        
        // Assert
        ArrayList<String> expected = new ArrayList<>();
        expected.add("1. Wash Face");
        expected.add("2. Apply Toner");
        expected.add("3. Apply Serums");
        expected.add("4. Moisturize");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetRoutine2() {
        // Arrange
        Skincare skincare = new Skincare();
        skincare.addStepToRoutine("Wash Face");
        skincare.addStepToRoutine("Apply Bioderm");
        skincare.addStepToRoutine("Apply Lip mask");
        skincare.addStepToRoutine("Moisturize");
        skincare.addStepToRoutine("Apply Sunscreen");

        // Act
        ArrayList<String> actual = skincare.getRoutine();
        
        // Assert
        ArrayList<String> expected = new ArrayList<>();
        expected.add("1. Wash Face");
        expected.add("2. Apply Bioderm");
        expected.add("3. Apply Lip mask");
        expected.add("4. Moisturize");
        expected.add("5. Apply Sunscreen");
        Assertions.assertEquals(expected, actual);
    }
}