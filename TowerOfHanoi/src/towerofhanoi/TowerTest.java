package towerofhanoi;

import student.TestCase;

/**
 * Tests the Tower class, and all its methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.25.19
 */
public class TowerTest extends TestCase {

    private Tower tLeft;
    private Tower tRight;
    private Tower tMid;


    /**
     * Sets up the test fixture.
     */
    public void setUp() {
        tLeft = new Tower(Position.LEFT);
        tRight = new Tower(Position.RIGHT);
        tMid = new Tower(Position.MIDDLE);
    }


    /**
     * Tests the position method.
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tLeft.position());
        assertEquals(Position.RIGHT, tRight.position());
        assertEquals(Position.MIDDLE, tMid.position());
    }


    /**
     * Tests the push method.
     */
    public void testPush() {
        Disc big = new Disc(8);
        Disc med = new Disc(4);
        Disc small = new Disc(2);
        Disc nullDisc = null;

        assertEquals(0, tLeft.size());
        tLeft.push(med);
        assertEquals(1, tLeft.size());

        Exception ex = null;
        try {
            tLeft.push(big);
        }
        catch (IllegalStateException e) {
            ex = e;
        }
        assertNotNull(ex);

        Exception exception = null;
        try {
            tRight.push(nullDisc);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        tLeft.push(small);
        assertEquals(2, tLeft.size());
    }
}
