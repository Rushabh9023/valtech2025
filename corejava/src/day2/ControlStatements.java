package day2;


public class ControlStatements {
	//If Else Ex
public void testIfElse(int a) {
	if(a%2==0) {
		System.out.println("A = "+a+" is Even");
	} else {
		System.out.println("A = "+a+" is Odd");
	}
	
}

//For Loop
public void testFor(int [] a) {
   for (int i = 0; i < a.length; i++) {
	System.out.println(a[i]);
}	
}

//Switch case
public void testSwitch(int a) {
	switch (a) {
	case 1: System.out.println("One");
	break;
	case 2 : System.out.println("Two");// Case without break statement
	case 3: System.out.println("Three");
	break;
	default:
		System.out.println("All others");
	}
}

// var Args means variable arguments like multiple no. of arguments here int iv is initial value 
// now this method will need atleast one argument varArgs must be the last argument
// String msg is used to print message as first argument
public int add(String msg,int iv,int ...a) {
	int sum = iv;
	for (int i = 0; i < a.length; i++) {
		sum += a[i];
	}
	System.out.println(msg+" Sum = "+sum);
	return sum;
}





public static void main(String[] args) {
	ControlStatements cs = new ControlStatements();
	
	cs.testIfElse(3);
	cs.testIfElse(4);
	cs.testIfElse(0);
	cs.testIfElse(-2);
	cs.testFor(new int[] {1,2,3});
	cs.testFor(new int[] {5,4,3,2,1});
	cs.testSwitch(1);
	cs.testSwitch(2);
	cs.testSwitch(30);
	cs.add("Sum of [1,2]",1,2);
	cs.add("Sum of [2,3,4,5,]",2,3,4,5);
	cs.add("Sum of [7,8,9]",7,8,9);
}
}
