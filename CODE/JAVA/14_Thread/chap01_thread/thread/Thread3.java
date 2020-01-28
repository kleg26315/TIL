package com.kh.example.chap01_thread.thread;

public class Thread3 extends Thread {
	@Override
	public void run() {
		setName("½º·¹µå3");
		for(int i=0; i<10; i++) {
			System.out.println(getName() + " ON...");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
