/**
 * SolveMaze
 * Starter program for the maze-solving algorithm.
 *
 * @date 2017-06-15
 * @author Boris Bischoff
 * @version 1.0
 */

public class SolveMaze {

    /**
     * intoTheMaze creates an object of the Maze class and calls its method startFromPoint
     */

    public static void intoTheMaze() {
        // creates a new object
        Maze maze = new Maze();
        // calls object's method startFromPoint with an arbitrary start point
        maze.startFromPoint(1,1);
        // prints the solved maze afterwards
        System.out.println(maze);
    }

    public static void main(String[] args) {
        intoTheMaze();
    }

}