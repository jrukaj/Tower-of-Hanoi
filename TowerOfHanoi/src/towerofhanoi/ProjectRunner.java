package towerofhanoi;

/**
 * Initializes the GUI and runs the project.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.26.19
 */
public class ProjectRunner {

    public static void main(String[] args) {
        int discs = 5;
        if (args.length == 1) {
            new GameWindow(new HanoiSolver(Integer.parseInt(args[0])));
        }
        else {
            new GameWindow(new HanoiSolver(discs));
        }
    }

}
