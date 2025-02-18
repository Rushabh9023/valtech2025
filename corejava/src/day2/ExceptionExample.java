package day2;

public class ExceptionExample {
	
	
	
public static void main(String[] args) {
	
	Authenticator auth = new Authenticator();
	try {
//		long code = auth.authenticate("Scott", "tiger"); Exception case
//		long code = auth.authenticate(null, "tiger"); Exception case
		long code = auth.authenticate("scott", "tiger"); 
		System.out.println("Auth Code = "+code);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//Chaining of Exception calling One Exception by another
		throw new RuntimeException(e);
	}
	
	finally {
		System.out.println("Finally will always be executed");
	}
	
}
}
