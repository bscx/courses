/**
 * Maze contains different variations of mazes and it includes the maze-solving algorithm
 *
 * @date 2017-06-15
 * @author Boris Bischoff
 * @version 1.0
 */

public class Maze {

    private char[][] variation1 =
            {
                    {'#','#','#','#','#','#','#','#','#','#'},
                    {'#',' ',' ',' ',' ','#',' ',' ',' ','#'},
                    {'#','#','#','#',' ','#','#','#',' ','#'},
                    {'#',' ',' ',' ',' ','#',' ',' ',' ','#'},
                    {'#',' ','#','#','#','#',' ','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#','#','#','#','#','#',' ','#'},
                    {'#',' ',' ',' ','#',' ',' ',' ',' ','#'},
                    {'#','#','#',' ','#','#','#','#','#','#'}
            };

    private char[][] variation2 =
            {
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#','#','#',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#','#','#',' ','#','#','#',' ','#',' ','#','#','#','#','#','#',' ','#',' ','#','#','#','#','#','#','#',' ','#'},
                    {'#',' ','#','#','#',' ','#','#','#',' ','#',' ','#','#','#','#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ','#',' ',' ',' ','#',' ','#','#','#','#',' ','#','#','#','#','#','#',' ','#','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#',' ','#','#','#',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','#','#','#'},
                    {'#',' ',' ',' ',' ',' ','#',' ','#','#','#','#','#','#',' ','#','#','#','#','#','#','#','#','#',' ','#',' ',' ',' ','#'},
                    {'#',' ','#','#','#',' ',' ',' ','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ','#','#','#','#','#',' ','#','#',' ','#','#','#','#','#','#','#','#',' ','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ','#',' ',' ',' ','#',' ','#','#',' ','#',' ',' ',' ',' ',' ',' ','#',' ','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ',' ',' ','#',' ','#',' ','#','#',' ','#',' ','#','#','#','#','#','#',' ','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ','#','#',' ',' ',' ',' ','#','#',' ','#',' ','#',' ',' ',' ','#','#',' ','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ','#','#','#',' ','#','#','#','#',' ','#',' ','#',' ','#',' ','#','#',' ','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#',' ',' ',' ',' ','#','#',' ','#',' ','#',' ','#',' ','#'},
                    {'#',' ','#','#','#','#','#','#','#','#','#','#','#','#',' ','#','#','#','#','#','#','#',' ',' ',' ','#',' ','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ','#',' ','#','#','#','#','#','#','#','#','#','#','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#',' ','#',' ','#','#','#',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',' ','#'},
                    {'#',' ','#','#','#','#','#','#',' ','#',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#','#','#','#',' ','#','#','#','#','#',' ','#',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#',' ',' ','#',' ','#',' ',' ',' ',' ',' ','#',' ','#',' ','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#','#',' ',' ',' ','#','#','#','#','#',' ','#',' ','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#','#','#','#',' ','#',' ',' ',' ',' ',' ','#',' ','#','#',' ','#','#','#','#','#','#','#','#','#','#',' ','#'},
                    {'#',' ',' ',' ',' ','#',' ','#',' ','#','#','#','#','#',' ','#','#',' ','#',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#'},
                    {'#',' ','#','#',' ','#',' ','#',' ','#',' ',' ',' ',' ',' ','#','#',' ','#',' ','#','#','#','#','#','#',' ','#',' ','#'},
                    {'#',' ','#','#',' ','#',' ','#',' ','#',' ','#','#','#','#','#','#',' ','#',' ','#',' ','#','#','#','#',' ','#',' ','#'},
                    {'#',' ','#',' ',' ','#',' ','#',' ','#',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#',' ',' ',' ',' ',' ',' ','#',' ','#'},
                    {'#',' ','#','#','#','#',' ','#',' ','#',' ','#','#','#','#','#','#',' ','#',' ','#','#','#','#','#','#','#','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',' ','#'},
            };

    // sets the active variation
    private char[][] maze = variation2;

    // initialization of variables
    private int x;
    private int y;
    // defines how the wall looks like
    private char wall = '#';
    // defines how the discovered area is supposed to be marked
    private char way = '.';
    int countWay;
    // defines how the solved path looks like
    private char path = '°';
    int countPath;
    // dynamic initialization of maze size
    private int mazeHeight = maze.length;
    private int mazeWidth = maze[0].length;

    /**
     * startFromPoint sets the start point and kicks of the maze run
     * @param x
     * @param y
     */

    public void startFromPoint(int x, int y) {
            if (walk(x, y)) {
                maze[x][y] = 'S';
                System.out.println("Exit found and marked with an X.\n");
            }
            else {
                maze[x][y] = 'S';
                System.out.println("No way out!\n");
            }
    }

    /**
     * isWall checks if given tile of the maze is a wall
     * @param x
     * @param y
     * @return true for wall, false for way
     */

    public boolean isWall(int x, int y) {
        if(maze[x][y] == wall) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * isDiscovered marks the walked way as already discovered.
     * This prevents infinite recursions and subsequently stack overflows.
     * @param x
     * @param y
     * @return true, if this tile has already been discovered, false, if not
     */
    public boolean isDiscovered(int x, int y) {
        if(maze[x][y] == way) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * isExit checks if the given tile is an exit and if yes, marks it with an X.
     * @param x
     * @param y
     * @return true, if the tile is an exit, false, if not
     */
    public boolean isExit(int x, int y) {
        if ((x == 0 || x == mazeHeight-1 || y == 0 || y == mazeWidth-1) && maze[x][y] == ' ') {
            maze[x][y] = 'X';
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * walk walks through the maze and calls itself recursively
     * @param x
     * @param y
     * @return true, if a way out has been found, false, if not
     */
    public boolean walk(int x, int y) {
        if ((x >= 0 && x < mazeHeight) && (y >= 0 && y < mazeWidth)) {
            // checks if tile is a wall or already discovered
            if(isWall(x, y) || isDiscovered(x, y)) {
                return false;
            }
            else {
                // checks if tile is not an exit
               if(!isExit(x, y)) {
                   // marks the tile as already discovered
                    maze[x][y] = way;
                    countWay++;
                    // walks in all directions (north, east, south, west)
                    // this is where the backtracking starts
                    if (walk(x-1, y) || walk(x, y+1) || walk(x+1, y) || walk(x, y-1)) {
                        // if a tile is marked as part of the solution path it gets marked as path
                        maze[x][y] = path;
                        countPath++;
                        // we're on the solution path
                        return true;
                    }
                    // we're not on the solution path/have reached a dead end
                    // As this way won't be part of the solution, we can delete the isDiscovered flag.
                    maze[x][y] = ' ';
                    return false;
               }
               return true;
            }
        }
        else {
            return false;
        }
    }

    /**
     * overrides standard toString() method and prints the maze well-formatted.
     * @return formatted maze
     */
    @Override
    public String toString() {
        String drawMaze = "";

        for (int x = 0; x < mazeHeight; x++) {
            for (y = 0; y < mazeWidth; y++) {
                drawMaze += maze[x][y] + " ";
            }
            drawMaze += "\n";
        }

        drawMaze += "\n" + countWay + " steps have been walked, path is " + countPath + " steps long.";
        return drawMaze;
    }
}