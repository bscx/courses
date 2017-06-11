package model;

/**
 * a fabric for Shape-Objects.
 * @author Agathe Merceron
 */

import java.util.Arrays;

public class MAllShapes {

    /**
     * construct a number of Rectangle and Circle objects,
     * stores them in an array and returns it
     * @return an array filled with Rectangle or Circle objects
     */

    public static MShape[] getDefaultShapes(){
        MShape[] allshapes= new MShape[4];
        allshapes[0] = new MRectangle( 50, 150, 10, 40);
        allshapes[1] = new MCircle( 80, 80, 10);
        allshapes[2] = new MCircle( 200, 100, 50);
        allshapes[3] = new MEllipse( 300, 150, 40, 10);

        return allshapes;
    }

    public static void main(String[] args) {
        MShape[] mix =  MAllShapes.getDefaultShapes();
        System.out.println(Arrays.deepToString(mix));
    }

}