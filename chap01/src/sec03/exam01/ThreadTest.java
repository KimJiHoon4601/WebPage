package sec03.exam01;

import java.awt.Toolkit;

public class ThreadTest {
	public static void main(String[] args) {
		Thread thread = new BeepThread();
		thread.start();	
		thread.getName();
		
		for(int i=0; i<5; i++) {
			System.out.println("¶ò");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}
