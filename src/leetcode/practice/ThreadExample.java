package leetcode.practice;

import java.util.*;

public class ThreadExample{


	public static void main(String[] args){
	Thread t1 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			for(int i = 1; i<=5; i++){
				System.out.println("Thread t1 executable print statement"+i);
			try {
				Thread.sleep(500);
			}		
			catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			}			
		}
	});
	t1.start();

	for(int i = 0; i<=5; i++){
	System.out.println("Main Thread loop: "+i);

	}
	}


}

