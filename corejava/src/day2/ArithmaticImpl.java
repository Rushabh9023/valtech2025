package day2;

public class ArithmaticImpl implements Arithmatic {

	@Override
	public double add(double a, double b) {
		return a+b;

	}

	@Override
	public double sub(double a, double b) {
            return a-b;
	}

	@Override
	public double mult(double a, double b) {
		return a*b;

	}

	@Override
	public double div(double a, double b) {
		return a/b;
	}
	
	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	public static void main(String[] args) {
		ArithmaticImpl arithmatic = new ArithmaticImpl();
		System.out.println(arithmatic.add(10, 30));
		System.out.println(arithmatic.sub(30, 10));
		System.out.println(arithmatic.mult(30, 10));
		System.out.println(arithmatic.div(30, 10));
		
		
	}

	

}
