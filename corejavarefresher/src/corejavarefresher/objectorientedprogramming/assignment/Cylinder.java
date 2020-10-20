/*
 * This is the solution for the assignment given
 */

package corejavarefresher.objectorientedprogramming.assignment;

public class Cylinder extends Circle {
	/* Private instance variable of child class */
	private double height;

	public Cylinder() {
		super();
		height = 1.0;
	}

	public Cylinder(double radius, double height) {
		super(radius);
		this.height = height;
	}

	/* override the getArea() method inherited from superclass Circle */
	@Override
	public double getArea() {
		/* access super class getArea() */
		return 2 * Math.PI * getRadius() * height + 2 * super.getArea();
	}

	public double getVolume() {
		return super.getArea() * height; /* access super class getArea() */
	}

	/* override the inherited toString() method of super class Object */
	@Override
	public String toString() {
		return "Cylinder: radius = " + getRadius() + " height = " + height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}