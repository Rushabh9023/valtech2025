package day3;

public class Outer {

	private int a;
	
	public void outerPrint() {
		System.out.println("Outer Print");
	}
	
	
	public static class StaticInner{
		public void print(Outer o) {
			System.out.println("A = "+o.a);
		}
	}
	//Anonymous Class Ex
	private static abstract class Just{
		abstract void print();
	}
	
	public static class JustImpl extends Just{

		@Override
		void print() {
			System.out.println("My Job is to Just Print ...");
			
		}
		
	}
	
	
	public class Inner{
		private int b; 
		public void print() { 
			System.out.println("Inner Print A = "+ a +" B = "+b);
		}
		
		public void addOne() {
			b++;
			a++;
		}
		
		
	}
	
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		//here we are incrementing i which will increase both a and b
		i.addOne();
		//here we are creating another instance of inner class which will have a=1 but b =0 
		Outer.Inner i1 = o.new Inner();
 		//for i1 a=1 b=0
		i1.print();
		//for i a=1 b=1
		i.print();
		
		//here we have created new instance of outer class so it will contain a=0 b=0initially
		Outer o1 = new Outer();
		Outer.Inner i2 = o1.new Inner();
		//a=0 b=0
		i2.print();
		//increment a and b
		i2.addOne();
		//a=1 b=1
		i2.print();
		//a=1 b=1
		i.print();
		
		Outer.StaticInner si = new Outer.StaticInner();
	    si.print(o1);	
	    Just j = new JustImpl();
	    j.print();
	    
	    Just j1 = new Just() {

			@Override
			void print() {
				System.out.println("Just Anonymouse class....");	
			}
	    };
	    j1.print();
	}
	
}
