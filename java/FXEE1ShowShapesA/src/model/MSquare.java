package model;

/**
 * represents a square.
 * A square is a shape with the same length for both width and length
 * @author Gert Veltink, updated Agathe Merceron
 *
 */

public class MSquare extends MShape {

    private double xDelta;

    /**
     * constructs a square object
     *
     * @param xOrigin
     *            the x-coordinate of the shape's origin
     * @param yOrigin
     *            the y-coordinate of the shape's origin
     * @param xDelta
     *            half of the length
     *
     */

    public MSquare(double xOrigin, double yOrigin, double xDelta) {
        super(xOrigin, yOrigin);
        this.xDelta = xDelta;
    }

    /**
     * returns half the length of the square
     * @return half the length
     */

    public double getXDelta() {
        return xDelta;
    }

    /**
     * calculate the area of this square
     *
     * @return the area of the square
     */
    @Override
    public double area() {
        return (4*this.xDelta);
    }

    /**
     * calculate the circumference of this square
     *
     * @return the circumference of the square
     */
    @Override
    public double circumference() {
        return (8*this.xDelta);
    }

    /**
     * constructs a textual representation of the object.
     *
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
        return "Square with origin: " + origin() +
                ", xDelta: " + this.xDelta;
    }

}