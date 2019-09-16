package towerofhanoi;

/**
 * Represent the towers on which the discs are stored as stacks.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.25.19
 */
public class Tower extends LinkedStack<Disc> {

    private Position position;


    /**
     * Initializes the Tower constructor, taking a position argument
     * in as a parameter.
     * 
     * @param position
     *            The position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * Returns the position of the tower.
     * 
     * @return the position of the tower
     */
    public Position position() {
        return position;
    }


    /**
     * Pushes the disc onto the tower, if it is a valid move.
     * 
     * @param disc
     *            The disc to be pushed
     * @Override
     */
    public void push(Disc disc) {
        if (disc == null) {
            throw new IllegalArgumentException();
        }
        // If the tower is empty or the given disc is smaller
        // than the one on the tower, add the disc
        if (isEmpty() || disc.compareTo(peek()) < 0) {
            super.push(disc);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
