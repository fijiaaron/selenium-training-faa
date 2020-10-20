/* Creating objects of Circle class */

package corejavarefresher.objectorientedprogramming.assignment;

public class TestCircle {

	public static void main(String[] args) {
		Circle c1 = new Circle(10);
		Circle c2 = new Circle();
		c2 = new Circle(12.5);
		Circle c4 = new Circle(4, "Green");
		System.out.println(c1.getArea());
	}

}
