package corejavarefresher.d_classDemo.DInterface;

public interface InterfaceBicycle {
	
    //  wheel revolutions per minute
    void changeCadence(int newValue);

    void changeGear(int newValue);

    void speedUp(int increment);

    void applyBrakes(int decrement);
	
    /*
     * Use when
     * -Unrelated classes would implement your interface
     * 	- Concerned with the behaviour of data type but not with who implements
     * - take advantage of multiple inheritance
     */
    
    
}
