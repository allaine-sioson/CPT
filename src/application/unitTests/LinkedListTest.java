package application.unitTests;

import application.*;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * LinkedList datatype Unit Tests
 */

public class LinkedListTest {
    @Test
    public void testGetFirst1() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        list.append("First");
        list.append("Second");
        list.append("Third");
        // Act
        String actual = null;
        try {
            actual = list.getFirst();
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        // Assert
        String expected = "First";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetFirst2() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        list.prepend("Back");
        list.prepend("Middle");
        list.prepend("Front");
        // Act
        String actual = null;
        try {
            actual = list.getFirst();
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
        // Assert
        String expected = "Front";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty1() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        // Act
        boolean actual = list.isEmpty();
        // Assert
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty2() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        list.append("Banana");
        // Act
        boolean actual = list.isEmpty();
        // Assert
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSize1() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        list.append("Banana");
        list.append("Apple");
        list.append("Orange");
        // Act
        int actual = list.size();
        // Assert
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSize2() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        list.prepend("Brie");
        list.prepend("Cheddar");
        list.prepend("Gouda");
        list.prepend("Mozzarella");
        list.prepend("Parmesan");
        list.prepend("Swiss");
        list.prepend("Feta");
        list.prepend("Blue Cheese");
        list.prepend("Cottage Cheese");
        list.prepend("Cream Cheese");
        list.prepend("Ricotta");
        list.prepend("Camembert");
        // Act
        int actual = list.size();
        // Assert
        int expected = 12;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToString1() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        list.append("Banana");
        list.append("Apple");
        list.append("Orange");
        // Act
        String actual = list.toString();
        // Assert
        String expected = "[ Banana -> Apple -> Orange ]";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testToString2() {
        // Arrange
        LinkedList<String> list = new LinkedList<String>();
        list.prepend("Brie");
        list.prepend("Cheddar");
        list.prepend("Gouda");
        list.prepend("Mozzarella");
        list.prepend("Parmesan");
        list.prepend("Swiss");
        list.prepend("Feta");
        list.prepend("Blue Cheese");
        list.prepend("Cottage Cheese");
        list.prepend("Cream Cheese");
        list.prepend("Ricotta");
        list.prepend("Camembert");
        // Act
        String actual = list.toString();
        // Assert
        String expected = "[ Camembert -> Ricotta -> Cream Cheese -> Cottage Cheese -> Blue Cheese -> Feta -> Swiss -> Parmesan -> Mozzarella -> Gouda -> Cheddar -> Brie ]";
        Assertions.assertEquals(expected, actual);
    }

}
