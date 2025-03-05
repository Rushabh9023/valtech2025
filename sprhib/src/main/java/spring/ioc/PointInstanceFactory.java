package spring.ioc;

public class PointInstanceFactory {
	
	private int x;
	private int y;
	
	
	public PointInstanceFactory(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public Point createPoint(int x, int y ) {
//		  if only x and y then take value of factory-method constructor args
//		  if this.x and this.y then take value of pointFactory
		return new Point(this.x,this.y);
	}

}
