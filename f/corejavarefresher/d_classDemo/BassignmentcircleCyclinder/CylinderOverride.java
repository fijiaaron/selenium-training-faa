package corejavarefresher.d_classDemo.BassignmentcircleCyclinder;


public class CylinderOverride extends Circle {
	private double height;   // Private member variable
	   
	   public CylinderOverride() {      // constructor 1
	      super();              // invoke superclass' constructor Circle()
	      height = 1.0;
	   }
	   public CylinderOverride(double radius, double height) {  // Constructor 2
	      super(radius);        // invoke superclass' constructor Circle(radius)
	      this.height = height;
	   }
	   
	
	   // override the getArea() method inherited from superclass Circle
	   @Override
	   public double getArea() {
	      return 2*Math.PI*getRadius()*height + 2*super.getArea();
	   }
	   // need to change the getVolume() as well
	   public double getVolume() {
	      return super.getArea()*height;   // use superclass' getArea()
	   }
	   // override the inherited toString()
	   @Override
	   public String toString() {
	      return "Cylinder: radius = " + getRadius() + " height = " + height;   
	   }
	}