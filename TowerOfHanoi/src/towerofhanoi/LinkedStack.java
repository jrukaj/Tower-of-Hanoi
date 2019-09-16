package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * Defines and creates the methods in the linked stack.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.25.19
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> {

    private StackNode<T> topNode;
    private int size;


    /**
     * Creates the private node inner class (gross), to be used to
     * hold items and values in the stack.
     */
    private static class StackNode<T> {
        private StackNode<T> next;
        private T data;


        /**
         * Creates a new node with the given data,
         * and sets its next node upon creation.
         * 
         * @param data
         *            The data to be stored
         * @param next
         *            The next node
         */
        public StackNode(T data, StackNode<T> next) {
            // Set data and next fields of the node
            this.data = data;
            this.next = next;
        }


        /**
         * Gets the data stored in the node.
         * 
         * @return T data in the node
         */
        public T getData() {
            return data;
        }

    }


    /**
     * Initializes the LinkedStack.
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * Clears the linked stack.
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }


    /**
     * Returns true if the stack is empty.
     * 
     * @return true if the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the item at the top of the stack.
     * 
     * @return T value of the data from the top item
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }


    /**
     * Pops the top item off the stack, returning its value.
     * 
     * @return T value of the item at the top of the stack
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Store data from topNode
        T data = topNode.getData();
        // make topNode reference its next node
        topNode = topNode.next;
        // Decrement size
        size--;
        return data;
    }


    /**
     * Adds an item to the top of the stack.
     * 
     * @param anEntry
     *            The item to be added
     */
    @Override
    public void push(T anEntry) {
        StackNode<T> newNode = new StackNode<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }


    /**
     * Returns the size of the stack.
     * 
     * @return the size of the stack
     */
    public int size() {
        // *Elite one-liner*: not for the faint of heart
        return size;
    }


    /**
     * Represents the stack as a string, and returns that string.
     * 
     * @return string representing the contents of the stack
     */
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if (!isEmpty()) {
            StackNode<T> current = topNode;
            while (current != null) {
                // Store the data of the current node
                T data = current.getData();
                // Add the data to the string
                str.append(String.valueOf(data));
                if (current.next != null) {
                    // Adds a comma if there is more data
                    str.append(", ");
                }
                current = current.next;
            }
        }
        str.append("]");
        return str.toString();
    }

}
