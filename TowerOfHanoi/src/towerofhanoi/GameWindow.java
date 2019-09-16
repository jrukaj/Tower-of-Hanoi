package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

public class GameWindow implements Observer {

    private Window window;
    private Shape left;
    private Shape right;
    private Shape middle;
    private HanoiSolver game;
    public static final int DISC_GAP = 1;
    public static final int DISC_HEIGHT = 15;


    /**
     * Initializes shape objects and the game window.
     * 
     * @param game
     *            A HanoiSolver object
     */
    public GameWindow(HanoiSolver game) {
        // Initialize HanoiSolver object
        this.game = game;
        // Allow this to reference the game
        game.addObserver(this);
        window = new Window("Tower of Hanoi!");
        int width = window.getWidth() / 6;
        int height = 75;

        left = new Shape(2 * width, height, 5, 150, Color.BLUE);
        right = new Shape(4 * width, height, 5, 150, Color.BLUE);
        middle = new Shape(3 * width, height, 5, 150, Color.BLUE);
        Shape floor = new Shape(width * 2, height + left.getHeight(), 205, 10,
            Color.GRAY);
        window.addShape(floor);

        // Add a new disc to the left tower, from biggest to smallest
        for (int i = game.discs(); i > 0; i--) {
            Disc newDisc = new Disc(15 * i);
            window.addShape(newDisc);
            game.getTower(Position.LEFT).push(newDisc);
            moveDisc(Position.LEFT);
        }

        window.addShape(left);
        window.addShape(right);
        window.addShape(middle);

        // Create solve button, and use clickedSolve for its on click.
        Button solve = new Button("Solve");
        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.SOUTH);

    }


    /**
     * Called when the game's move method calls notifyObservers.
     * 
     * @param o
     *            Observable
     * @param arg
     *            Position passed to notifyObservers
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position pos = (Position)arg;
            moveDisc(pos);
        }
        sleep();
    }


    /**
     * Pauses between disc movements.
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * Solves the game, updating the display as the
     * backend changes.
     * 
     * @param button
     *            The button passed through
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * Updates the movement of discs on the display.
     * 
     * @param position
     *            The position to be moved to
     */
    public void moveDisc(Position position) {
        // Get current disc and create currentPole
        Disc currentDisc = game.getTower(position).peek();
        Shape currentPole;
        // Compares the position to the enumerator, setting
        // currentPole equal to the corresponding tower
        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        else {
            currentPole = left;
        }
        // Set the x and y coordinates for the disc, taking into account
        // the size of the stack, height of the discs, and gap.
        int x = currentPole.getX() - (currentDisc.getWidth() - 5) / 2;
        int y = (currentPole.getY() + currentPole.getHeight())  - game.getTower(position).size()  * (DISC_HEIGHT + DISC_GAP);
        currentDisc.moveTo(x, y);
    }
}
