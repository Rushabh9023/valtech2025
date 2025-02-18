package day2;

import java.util.Random;

public class Authenticator {

	public long authenticate(String name, String pass) throws Exception {
		//to avoid null pointer exception we can write scott = name
//		if(name.equals("scott") && pass.equals("tiger")) {
		if ("scott".equals(name) && "tiger".equals(pass)) {
			return new Random().nextLong();
		}
		
		throw new Exception("Only Scott is allowed");
	}
	
}
