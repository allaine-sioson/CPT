package application;
import javax.naming.OperationNotSupportedException;

/**
 * @author: Allaine
 * @date: 18/01/2025
 * Queue datatype
 */

public class Queue<T> {
    // composition
    private LinkedList<T> queue;

    /**
     * Default constructor for Queue
     */
    public Queue() {
        this.queue = new LinkedList<T>();
    }

    /**
     * Adds data to the back of the list
     * @param data data to be added
     */
    public void enqueue(T data) {
        this.queue.append(data);
    }

    /**
     * removes and returns the front of the list
     * @return first element of the list / queue
     */
    public T dequeue() {
        T firstElement = null;
        try {
            firstElement = this.queue.getFirst();
        } catch (OperationNotSupportedException e) {
            System.out.println(e);
        }

        this.queue.removeFirst();
        return firstElement;
    }

    /**
     * returns the front of the list
     * @return first element of the list / queue
     */
    public T peek() {
        T firstElement = null;
        try {
            firstElement = this.queue.getFirst();
        } catch (OperationNotSupportedException e) {
            System.out.println(e);
        }
        return firstElement;
    }
    
    /**
     * Checks if queue is empty
     * @return true when list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    /**
     * Return a string representation of our queue
     */
    @Override
    public String toString() {
        return this.queue.toString();
    }
}