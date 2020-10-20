package corejavarefresher.d_classDemo.Cstatic;

public class BicycleStatic {

	    private int cadence;
	    private int gear;
	    private int speed;
	        
	    private int id;
	    
	    private static int numberOfBicycles = 0;
//BicycleStatic b1,b2,b3;
	    //b1 = new BicycleStatic(2,5,7) - id =1,nB= 1;
	    //b1.id = ++BicycleStatic.noOfBicycles;
	  //syso(b1.id +""+ b1.nB);1 1;
	    //b2 = new BicycleStatic(6,9,3) - id = 2 nB = 2 
	  //syso(b1.id +""+ BicycleStatic.nB);1 2;
	    //b3 = new BicycleStatic(6,10,6) - id = 3, nB = 3;
	    //syso(b1.id +""+ b1.nB); 1 3 , 1 1, 
	       
	    public BicycleStatic(int startCadence,
	                   int startSpeed,
	                   int startGear){
	        System.out.println(gear + cadence + speed + id + numberOfBicycles);
	    	gear = startGear;
	        cadence = startCadence;
	        speed = startSpeed;
	        System.out.println(gear + cadence + speed + id + "-" + numberOfBicycles);
	        //numberOfBicycles++;
	        //before below line what is the value of id and numberOfBicycles?
	        id = ++numberOfBicycles;
	        System.out.println(id + "-" + numberOfBicycles);
	      //  id = numberOfBicycles++;
	        
	    }
	    //bike1 = new BicycleStatic(3,4,5); nb = 1 , id = 1
	    //getNumberOfBicycles()
	  //getNumberOfBicycles()
	    //bike2 = new BicycleStatic(1,2,6); nb = 2 , id = 2 , bike1.id = 1 , BicycleStatic.nb =2 , bike2.nb=2,bike1.nb=2;
	  //getNumberOfBicycles()
	  //getNumberOfBicycles()
        //bike3 = new BicycleStatic(5,6,3); nb = 3 , id =3 , bike2.id = 2, BicycleStatic.nb = 3, bike1.id = 1 ;
	  //getNumberOfBicycles()
	    //bike4 = new BicycleStatic(6,2,9); nb = , id = , bike3.id = , bike3.nb = ; bike2.nb =  , bike1.id = ;
	    public int getID() {
	        return id;
	    }

	    public static int getNumberOfBicycles() {
	        return numberOfBicycles;
	    }
/*
 * public static int getNumberOfBicycles() {
	        return id;
	    }
 * 
 */
	    
	    
	    
	    public int getCadence(){
	        return cadence;
	    }
	        
	    public void setCadence(int newValue){
	        cadence = newValue;
	    }
	        
	    public int getGear(){
	    return gear;
	    }
	        
	    public void setGear(int newValue){
	        gear = newValue;
	    }
	        
	    public int getSpeed(){
	        return speed;
	    }
	        
	    public void applyBrake(int decrement){
	        speed -= decrement;
	    }
	        
	    public void speedUp(int increment){
	        speed += increment;
	    }
	}