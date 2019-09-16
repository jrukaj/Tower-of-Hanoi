package towerofhanoi;

import student.TestCase;

/**
 * Tests the HanoiSolver class and all its methods.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.26.2019
 */
public class HanoiSolverTest extends TestCase {

    private HanoiSolver game;


    /**
     * Sets up the test fixture.
     */
    public void setUp() {
        game = new HanoiSolver(3);
    }


    /**
     * Tests the discs method.
     */
    public void testDiscs() {
        assertEquals(3, game.discs());
    }


    /**
     * Tests the getTower method.
     */
    public void testGetTower() {
        assertEquals(Position.LEFT, game.getTower(Position.LEFT).position());
        assertNotNull(game.getTower(Position.LEFT));
        assertEquals(Tower.class, game.getTower(Position.LEFT).getClass());

        assertEquals(Position.RIGHT, game.getTower(Position.RIGHT).position());
        assertNotNull(game.getTower(Position.RIGHT));
        assertEquals(Tower.class, game.getTower(Position.RIGHT).getClass());

        assertEquals(Position.MIDDLE, game.getTower(Position.MIDDLE)
            .position());
        assertNotNull(game.getTower(Position.MIDDLE));
        assertEquals(Tower.class, game.getTower(Position.MIDDLE).getClass());

        assertEquals(Position.LEFT, game.getTower(Position.OTHER).position());
        assertNotNull(game.getTower(Position.LEFT));
        assertEquals(Tower.class, game.getTower(Position.OTHER).getClass());
    }


    /**
     * Tests the solve method.
     */
    public void testSolve() {
        Tower left = game.getTower(Position.LEFT);
        Tower right = game.getTower(Position.RIGHT);
        Tower mid = game.getTower(Position.MIDDLE);

        left.push(new Disc(5));
        left.push(new Disc(3));
        left.push(new Disc(1));

        game.solve();
        assertEquals(0, left.size());
        assertEquals(0, mid.size());
        assertEquals(3, right.size());
    }


    /**
     * Tests the toString method.
     */
    public void testToString() {
        Tower left = game.getTower(Position.LEFT);
        Tower right = game.getTower(Position.RIGHT);
        Tower mid = game.getTower(Position.MIDDLE);

        left.push(new Disc(5));
        mid.push(new Disc(3));
        right.push(new Disc(2));

        assertEquals("[5][3][2]", game.toString());

        left.push(new Disc(3));
        mid.push(new Disc(2));
        right.push(new Disc(1));

        assertEquals("[3, 5][2, 3][1, 2]", game.toString());
    }

}
