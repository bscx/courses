package model;

/**
 * This class represents a ellipse.
 * A ellipse is a shape with two different radiuses.
 * @author Gert Veltink, updated Agathe Merceron
 *
 */

public class MEllipse extends MShape {

    private double radiusA;
    private double radiusB;

    /**
     * Constructs an ellipse with the given origin and the two given radiuses
     *
     * @param x
     *            the x-coordinate of the shape's origin
     * @param y
     *            the y-coordinate of the shape's origin
     * @param radiusA
     *            Radius A of this ellipse
     * @param radiusB
     *            Radius B of this ellipse
     *
     */
    public MEllipse(double x, double y, double radiusA, double radiusB) {
        super(x, y);
        this.radiusA = radiusA;
        this.radiusB = radiusB;
    }

    public double getRadiusA(){
        return radiusA;
    }

    public double getRadiusB() {
        return radiusB;
    }

    /**
     * calculate the area of an ellipse
     *
     * @return the area of the ellipse
     */
    @Override
    public double area() {
        return (Math.PI * (this.radiusA * this.radiusB));
    }

    /**
     * calculate the circumference of an ellipse
     *
     * @return the circumference of the ellipse
     */
    @Override
    public double circumference() {
        return (Math.PI * Math.sqrt(2 * (Math.pow(this.radiusA, 2)+ Math.pow(this.radiusB,2))));
    }

    /**
     * constructs a textual representation of this ellipse
     *
     * @return the current object in a textual representation
     */
    @Override
    public String toString() {
        return "Ellipse with origin: " + origin() +
                " and radiuses: " + this.radiusA +", " + this.radiusB;
    }

}