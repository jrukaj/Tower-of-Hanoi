package towerofhanoi;

import java.awt.Color;
import CS2114.Shape;
import student.TestableRandom;

/**
 * Creates the Disc class, which is to be used in a stack.
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.25.19
 */
public class Disc extends Shape implements Comparable<Disc> {

    /**
     * Sets up the disc(int) constructor.
     * @param width  The width of the disc
     */
    public Disc(int width) {
        super(0, 0, width, 15);
        // Create a new random number generator
        TestableRandom gen = new TestableRandom();
        // Use the generator to create a random color
        Color color = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(
            256));
        setBackgroundColor(color);
    }


    /**
     * Compares the size of the disc to another.
     * 
     * @param otherDisc
     *            The disc being compared
     * @return int representing their size equality
     */
    @Override
    public int compareTo(Disc otherDisc) {
        if (otherDisc == null) {
            throw new IllegalArgumentException(
                "The disc being compared is null!");
        }
        // Compare widths
        // + result: this disc is larger than otherDisc
        // - result: otherDisc is larger than this disc
        // 0 result: the discs are the same size
        return getWidth() - otherDisc.getWidth();
    }


    /**
     * Returns the width of the given disc as a string.
     * 
     * @return String representing the width of the disc
     */
    public String toString() {
        return String.valueOf(getWidth());
    }


    /**
     * Returns true if the two objects are equal.
     * 
     * @param obj
     *            The object being compared
     * @return boolean representing if they are equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (getClass() == obj.getClass()) {
            // Force cast the object parameter to a disc
            Disc otherDisc = (Disc)obj;
            return getWidth() == otherDisc.getWidth();
        }
        else {
            return false;
        }
    }
}
