package corejavarefresher.d_classDemo.Cstatic;


public class UseBicycleStatic {
	
	public static void main(String[] args) {
		BicycleStatic bs,bs1,bs2;
		bs = new BicycleStatic(3,2,4);//0,0 -> 1, 1
		System.out.println("No.ofbicycles after bs - " + BicycleStatic.getNumberOfBicycles());
		System.out.println("ID of firstBicycle after bs - " + bs.getID());
		bs1 = new BicycleStatic(2,5,7);//0,1 -> 2, 2
		System.out.println("No.ofbicycles after bs1 - of bs - " + bs.getNumberOfBicycles());
		System.out.println("ID of firstBicycle after bs1 - of bs - " + bs.getID());
		System.out.println("No.ofbicycles after bs1 - of bs1 - " + bs1.getNumberOfBicycles());
		System.out.println("ID of Second after bs1 - of bs1 - " + bs1.getID());
		bs2 = new BicycleStatic(7,5,1);//0,2 -> 3, 3
		System.out.println("No.ofbicycles after bs2 - of bs - " + bs.getNumberOfBicycles());
		System.out.println("ID of firstBicycle after bs2 - of bs - " + bs.getID());
		System.out.println("No.ofbicycles after bs2 - of bs1 - " + bs1.getNumberOfBicycles());
		System.out.println("ID of second after bs2 - of bs1 - " + bs1.getID());
		System.out.println("No.ofbicycles after bs2 - of bs2 - " + bs2.getNumberOfBicycles());
		System.out.println("ID of third after bs2 - of bs2 - " + bs2.getID());
		
		//bs.getSpeed();
		BicycleStatic.getNumberOfBicycles();
		//bs = new BicycleStatic(3,2,4);
		bs.getSpeed();
		System.out.println(BicycleStatic.getNumberOfBicycles());
//		BicycleStatic bs1 = new BicycleStatic(3,2,4);
	//	System.out.println(bs1.getNumberOfBicycles());
	}

}
