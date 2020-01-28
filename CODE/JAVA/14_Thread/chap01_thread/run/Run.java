package com.kh.example.chap01_thread.run;

import com.kh.example.chap01_thread.thread.Thread1;
import com.kh.example.chap01_thread.thread.Thread2;
import com.kh.example.chap01_thread.thread.Thread3;

public class Run {
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		
		Thread2 t2 = new Thread2();
		Thread thread2 = new Thread(t2);
		
		Thread3 thread3 = new Thread3();
		
		System.out.println("t1 우선순위 : " + thread1.getPriority());
		System.out.println("t2 우선순위 : " + thread2.getPriority());
		System.out.println("t3 우선순위 : " + thread3.getPriority());
		
		thread1.setPriority(3);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println("t1 우선순위 : " + thread1.getPriority());
		System.out.println("t2 우선순위 : " + thread2.getPriority());
		System.out.println("t3 우선순위 : " + thread3.getPriority());
		
		thread1.start();
		thread2.start();
		thread3.start();
//		thread1.start();
		// java.lang.IllegalThreadStateException
		// : 한 번 종료된 스레드는 다시 호출 불가
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			// 자신(main thread)이 하던 작업을 잠시 멈추고 다른 스레드가 지정된 시간동안 실행되도록 함
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("-------------- main end!"); 
	}
}
