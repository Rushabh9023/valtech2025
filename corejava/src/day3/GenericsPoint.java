package day3;

public class GenericsPoint <T> {

	private T x;
	private T y;
	
	// Default Constructor
	public GenericsPoint() {}
	
	//Parameterized constructor 
	public GenericsPoint(T x, T y) {
		this.x = x;
		this.y = y;
	}

	
	@Override
	public String toString() {
		return "GenericsPoint [x=" + x + ", y=" + y + "]";
	}

	//Getters and Setters
	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}
	
	
	
}
