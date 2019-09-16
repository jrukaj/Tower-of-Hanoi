package towerofhanoi;

import student.TestCase;

/**
 * Tests the Disc class and all of its methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.25.19
 */
public class DiscTest extends TestCase {

    private Disc disc;


    /**
     * Sets up the test fixture.
     */
    public void setUp() {
        disc = new Disc(3);
    }


    /**
     * Tests the compareTo method.
     */
    public void testCompareTo() {
        Disc nullDisc = null;
        Disc bigger = new Disc(5);
        Disc smaller = new Disc(1);

        Exception ex = null;
        try {
            disc.compareTo(nullDisc);
        }
        catch (IllegalArgumentException e) {
            ex = e;
        }
        assertNotNull(ex);
        assertEquals(-2, disc.compareTo(bigger));
        assertEquals(2, disc.compareTo(smaller));
    }


    /**
     * Tests the toString method.
     */
    public void testToString() {
        Disc newDisc = new Disc(10);

        assertEquals("3", disc.toString());
        assertEquals("10", newDisc.toString());
    }


    /**
     * Tests the equals method.
     */
    public void testEquals() {
        Disc nullDisc = null;
        LinkedStack<String> stack = new LinkedStack<String>();
        Disc same = disc;
        Disc notSame = new Disc(4);
        Disc isSame = new Disc(3);

        assertFalse(disc.equals(nullDisc));
        assertFalse(disc.equals(stack));
        assertTrue(disc.equals(same));
        assertFalse(disc.equals(notSame));
        assertTrue(disc.equals(isSame));
    }

}
