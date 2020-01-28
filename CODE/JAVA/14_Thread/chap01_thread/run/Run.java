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
		
		System.out.println("t1 �켱���� : " + thread1.getPriority());
		System.out.println("t2 �켱���� : " + thread2.getPriority());
		System.out.println("t3 �켱���� : " + thread3.getPriority());
		
		thread1.setPriority(3);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println("t1 �켱���� : " + thread1.getPriority());
		System.out.println("t2 �켱���� : " + thread2.getPriority());
		System.out.println("t3 �켱���� : " + thread3.getPriority());
		
		thread1.start();
		thread2.start();
		thread3.start();
//		thread1.start();
		// java.lang.IllegalThreadStateException
		// : �� �� ����� ������� �ٽ� ȣ�� �Ұ�
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			// �ڽ�(main thread)�� �ϴ� �۾��� ��� ���߰� �ٸ� �����尡 ������ �ð����� ����ǵ��� ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("-------------- main end!"); 
	}
}
