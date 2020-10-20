package corejavarefresher.objectorientedprogramming.classNinheritance;

public class RectangleWithThis {
	    private int x, y;
	    private int width, height;
	        
	    public RectangleWithThis() {
	        this(0, 0, 1, 1);
	    }
	    public RectangleWithThis(int width, int height) {
	        this(0, 0, width, height);
	    }
	    public RectangleWithThis(int x, int y, int width, int height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }
	
	}