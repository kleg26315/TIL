package com.kh.example.chap01_thread.thread;

// 스레드 생성 1 : Thread 상속
public class Thread1 extends Thread {
	
	@Override
	public void run() {
		setName("스레드1");	// 스레드 이름 지정
		for(int i=0; i<10; i++) {
			System.out.println(getName() + " ON...");
			// getName() : 스레드 이름 반환
			
			try {
				Thread.sleep(500);
				// sleep() : 스레드를 지연시키는 메소드 (1000 = 1s)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
