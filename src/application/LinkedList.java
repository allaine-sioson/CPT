package application;

/**
 * author: Allaine
 * date: 18/01/2025
 * LinkedList datatype
 */

import javax.naming.OperationNotSupportedException;

public class LinkedList <T> {
    // instance vars
    private Node<T> head;

    public LinkedList() {
        this.head = null; // null can only mean EMPTY
    }

    /**
     * Return whether or not our list is empty
     * @return true when list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Add some data to the beginning of the list
     * @param data The data to add
     */
    public void prepend(T data) {
        Node<T> node = new Node<>(data);

        // Step 0: Make the "next" of this node point to the current list
        if (isEmpty()) {
            this.head = node;
            return;
        }
        // Step 1: Make the next of this node point to the current list
        node.next = this.head;
        // Step 2: Make node the "head" of the list
        this.head = node;
    }

    /**
     * Add some data to the end of the list
     * @param data The data to add
     */
    public void append(T data) {
        Node<T> node = new Node<>(data);

        // Step 0: Make the "next" of this node point to the current list
        if (isEmpty()) {
            this.head = node;
            return;
        }

        // Step 1: Find the end of the list
        // 1a: Save the current state of head
        Node<T> current = this.head;
        // 1b: Find the node that has a "next" of "null"
        while (current.next != null) {
            // This traverses the list down to the end
            current = current.next;
        }
        // We know for sure that current's .next value HAS to be NULL
        current.next = node;
    }

    /**
     * Gets the first element of the list
     * @return the first element of the list
     * @throws OperationNotSupportedException if list is empty
     */
    public T getFirst() throws OperationNotSupportedException {
        // Step 0: Make the "next" of this node point to the current list
        if (isEmpty()) {
            // Throw an exception! (This means that this operation will cause an error)
            throw new OperationNotSupportedException("Cannot get first element of empty list.");
        }

        // We are safe to grab the data from the head of our list
        return this.head.data;
    }

    /**
     * Removes the first element of the list
     */
    public void removeFirst() {
        // Step 0: Is the list empty?
        if (isEmpty()) {
            return; // nothing
        }

        // Remove the first element by setting the "head" of the list to point to the "next" element
        this.head = this.head.next;
    }

    /**
     * Gets the size of the Linked List
     * @return the size of the Linked List
     */
    public int size() {
        // Step 0: Is the list empty?
        if (isEmpty()) {
            return 0; 
        }

        // Traverse 1: Set up current and counter
        Node<T> current = this.head;
        int size = 0;

        // Traverse 2: Loop while current (or current.next) is not null
        while (current.next != null) {
            // Traverse 3: Add to the counter
            size++;
            // Traverse 4: Go to next node
            current = current.next;
        }
        // return the size (add one to include the last node)
        return size + 1;
    }


    /**
     * Return a string representation of our Linked List
     */
    public String toString() {
        // Step 0: Make the "next" of this node point to the current list
        if (isEmpty()) {
            return "[]";
        }
        // Traverse the list, adding an element to our string at every node
        StringBuilder repr = new StringBuilder();
        repr.append("[ ");

        // Traverse 1: Set up current
        Node<T> current = this.head;

        // Traverse 2: Loop while current (or current.next) is not null
        while (current.next != null) {
            // Traverse 3: Do the thing
            repr.append(current.data);
            repr.append(" -> ");

            // Traverse 4: Go to next node
            current = current.next;
        }
        // this adds the last elem.
        repr.append(current.data);
        // finish the repr
        repr.append(" ]");
        
        return repr.toString();
    }

    /**
     * A node class to make possible a "Singly-Linked-List"
     */
    private class Node <U> {
        // create priv. instance vars
        private U data;
        private Node<U> next;

        // create node constructor
        public Node(U data) {
            this.data = data;
        }
        
    }
}
