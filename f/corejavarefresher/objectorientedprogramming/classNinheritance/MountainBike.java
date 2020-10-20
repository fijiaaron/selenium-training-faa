package corejavarefresher.objectorientedprogramming.classNinheritance;


public class MountainBike extends Bicycle {

    // the MountainBike subclass has
    // two fields
    private int seatHeight;
  //  private Bicycle bike1;
  //  private int cadence;
   // private int i = 10;
    // the MountainBike subclass has
    // two constructors
    public MountainBike(int seatHeight1, int startCadence,
                        int startSpeed, int startGear) {
       super(startCadence, startSpeed, startGear);
       // super(startCadence, startSpeed);
    	//super();
        this.seatHeight = seatHeight1;
        setCadence(5);
       // cadence = startCadence;
       // gear = 5;
        //cadence = 5;
    }   
    
    public MountainBike(int seatHeight) {
    //	super();
    	super(3,5,3);
    	this.seatHeight = seatHeight;
    	
    }
    
    public MountainBike() {
		super();
		seatHeight = 54;
    }   
        
    // the MountainBike subclass has
    // one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
        setCadence(3);
       super.setGear(3);
    }   
    
    @Override
    public void setGear(int newValue) {
     //   gear = newValue;
    	//super.setGear(newValue);
    	System.out.println("Hey, I do not want your (Bicycle) setGear Method");
    }
    
    public int getHeight() {
    	 getCadence();
    	return seatHeight;
       
    }   
    
    public void doSome() {
    	int i;
    	i=10;
    }
    
    public void doSome1() {
    	int i=0;
    	//this.i = i+1;
    	System.out.println("Value of i is - i" + i);
    }
   
    public void doSomething() {
    	
    	
    }

    
    }
	

