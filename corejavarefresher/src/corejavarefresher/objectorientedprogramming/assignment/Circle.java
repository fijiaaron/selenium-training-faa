/* This java file is a the solution to Ciricle Assignment */

package corejavarefresher.objectorientedprogramming.assignment;

public class Circle {
	double radius;
	private static String color = "red";

	public Circle(double radius1) {
		radius = radius1;
	}

	public Circle() {
		radius = 1;
	}

	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;

	}

	public String getColor() {
		return color;
	}

}
