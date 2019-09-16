package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Tests the LinkedStack class and all its methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.25.19
 */
public class LinkedStackTest extends TestCase {

    private LinkedStack<String> stack;


    /**
     * Sets up the test fixture.
     */
    public void setUp() {
        stack = new LinkedStack<String>();
    }


    /**
     * Tests the clear method.
     */
    public void testClear() {
        assertEquals(0, stack.size());

        stack.push("1");
        assertEquals(1, stack.size());

        stack.push("2");
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }


    /**
     * Tests the isEmpty method.
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("Not anymore!");
        assertFalse(stack.isEmpty());
    }


    /**
     * Tests the peek method.
     */
    public void testPeek() {
        Exception ex = null;
        try {
            stack.peek();
        }
        catch (EmptyStackException e) {
            ex = e;
        }
        assertNotNull(ex);

        stack.push("Pushed!");
        assertEquals("Pushed!", stack.peek());
    }


    /**
     * Tests the pop method.
     */
    public void testPop() {
        Exception ex = null;
        try {
            stack.pop();
        }
        catch (EmptyStackException e) {
            ex = e;
        }
        assertNotNull(ex);

        stack.push("3");
        stack.push("2");
        stack.push("1");

        assertEquals(3, stack.size());
        assertEquals("1", stack.pop());

        assertEquals(2, stack.size());
        assertEquals("2", stack.pop());

        assertEquals(1, stack.size());
        assertEquals("3", stack.pop());
        assertEquals(0, stack.size());
    }


    /**
     * Tests the push method.
     */
    public void testPush() {
        assertEquals(0, stack.size());

        stack.push("1");
        assertEquals(1, stack.size());
        assertEquals("1", stack.pop());
        assertEquals(0, stack.size());
    }


    /**
     * Tests the size method.
     */
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push("a");
        assertEquals(1, stack.size());

        stack.push("b");
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
    }
    

    /**
     * Tests the toString method.
     */
    public void testToString() {
        assertEquals("[]", stack.toString());

        stack.push("a");
        assertEquals("[a]", stack.toString());

        stack.push("b");
        stack.push("c");
        assertEquals("[c, b, a]", stack.toString());
    }

}
