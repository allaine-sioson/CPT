package application.unitTests;

import application.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Queue datatype Unit Tests
 */

public class QueueTest {
    @Test
    void testDequeue1() {
        // Arrange
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Act
        int actual = queue.dequeue();

        // Assert
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testDequeue2() {
        // Arrange
        Queue<Character> queue = new Queue<Character>();
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        queue.enqueue('D');

        // Act
        int actual = queue.dequeue();

        // Assert
        int expected = 'A';
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIsEmpty1() {
        // Arrange
        Queue<Double> queue = new Queue<Double>();
        queue.enqueue(5.0);
        // Act
        boolean actual = queue.isEmpty();

        // Assert
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIsEmpty2() {
        // Arrange
        Queue<Double> queue = new Queue<Double>();

        // Act
        boolean actual = queue.isEmpty();

        // Assert
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPeek1() {
        // Arrange
        Queue<String> queue = new Queue<String>();
        queue.enqueue("First Class");
        queue.enqueue("Business Class");
        queue.enqueue("Premium Economy");
        queue.enqueue("Economy Class");

        // Act
        String actual = queue.peek();

        // Assert
        String expected = "First Class";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPeek2() {
        // Arrange
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Order 1: Latte");
        queue.enqueue("Order 2: Caramel Macchiato");
        queue.enqueue("Order 3: Cappuccino");
        queue.enqueue("Order 4: Vanilla Ice Cream");
        queue.enqueue("Order 5: Black Coffee");
        queue.enqueue("Order 6: Black Tea w/ Lemon");
        queue.enqueue("Order 7: Green Tea");

        // Act
        String actual = queue.peek();

        // Assert
        String expected = "Order 1: Latte";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToString1() {
        // Arrange
        Queue<String> queue = new Queue<String>();
        queue.enqueue("First Class");
        queue.enqueue("Business Class");
        queue.enqueue("Premium Economy");
        queue.enqueue("Economy Class");

        // Act
        String actual = queue.toString();

        // Assert
        String expected = "[ First Class -> Business Class -> Premium Economy -> Economy Class ]";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testToString2() {
        // Arrange
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Order 1: Latte");
        queue.enqueue("Order 2: Caramel Macchiato");
        queue.enqueue("Order 3: Cappuccino");
        queue.enqueue("Order 4: Vanilla Ice Cream");
        queue.enqueue("Order 5: Black Coffee");
        queue.enqueue("Order 6: Black Tea w/ Lemon");
        queue.enqueue("Order 7: Green Tea");

        // Act
        String actual = queue.toString();

        // Assert
        String expected = "[ Order 1: Latte -> Order 2: Caramel Macchiato -> Order 3: Cappuccino -> Order 4: Vanilla Ice Cream -> Order 5: Black Coffee -> Order 6: Black Tea w/ Lemon -> Order 7: Green Tea ]";
        Assertions.assertEquals(expected, actual);
    }
}
