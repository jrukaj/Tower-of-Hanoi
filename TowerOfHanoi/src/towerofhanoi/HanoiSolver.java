package towerofhanoi;

import java.util.Observable;

/**
 * Solves the tower of hanoi puzzle.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.26.19
 */
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower right;
    private Tower middle;
    private int numDiscs;


    /**
     * Instantiates the constructor.
     * 
     * @param numDiscs
     *            The number of discs
     */
    public HanoiSolver(int numDiscs) {
        this.numDiscs = numDiscs;
        // Create the new Towers, assigning them to either left
        // right or middle
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }


    /**
     * Returns the number of discs.
     * 
     * @return int number of discs
     */
    public int discs() {
        return numDiscs;
    }


    /**
     * Gets the Tower at a given position.
     * 
     * @param pos
     *            The position given.
     * @return tower at the given position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return left;
        }
    }


    /**
     * Returns the left, middle, and right toString's appended.
     * 
     * @return string representation of the 3 Towers
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        // Append the left, middle, and right's toString values
        str.append(left.toString());
        str.append(middle.toString());
        str.append(right.toString());
        return str.toString();
    }


    /**
     * Moves a disc from a source Tower, and pushes it onto a
     * destination tower.
     * 
     * @param source
     *            The Tower the disc is popped from
     * @param destination
     *            The Tower the disc is being pushed to
     */
    private void move(Tower source, Tower destination) {
        Disc toMove = source.pop();
        destination.push(toMove);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Solves the given Towers.
     * 
     * @param currentDiscs
     *            The current amount of discs
     * @param startPole
     *            The Tower to begin at
     * @param tempPole
     *            The Tower used to reach the endPole
     * @param endPole
     *            The Tower to end at
     */
    private void solveTowers(
        int currentDiscs,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDiscs == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDiscs - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDiscs - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Solves the puzzle.
     */
    public void solve() {
        solveTowers(numDiscs, left, middle, right);
    }
}
