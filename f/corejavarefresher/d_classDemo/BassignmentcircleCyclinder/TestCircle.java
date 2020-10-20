package corejavarefresher.d_classDemo.BassignmentcircleCyclinder;

public class TestCircle {

	public static void main(String[] args) {
		Circle c1= new Circle (10);
		Circle c2 = new Circle();
	//	Circle c3 = new Circle();
		Circle c3 = c2;
		c2 = new Circle(12.5);
		Circle c4 = new Circle(4,"Green");
		//color of c4 is green
		//color of c2 is green
		//color of c1 is green
		System.out.println(c1.getArea());
		double c1area;
		c1area = c1.getArea();
	}
	

}
