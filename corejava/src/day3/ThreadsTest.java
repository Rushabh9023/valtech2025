package day3;


import java.lang.Thread;
import org.junit.jupiter.api.Test;

class ThreadsTest {

	@Test
	void test() {

		Runnable r = new Runnable() {
			
			public void run() {
				for(int i=0; i<10;i++) {
					System.out.println(Thread.currentThread()+" "+i);
				}
			}
		};
		
		
		// we have used start() not run() because run will always called by start method and we need to check the working 
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		
		
		Thread t = new Thread() {
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println(Thread.currentThread()+" "+i);
				}
			};
			
		};
		t.start();
		
	}

}
