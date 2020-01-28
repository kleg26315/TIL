package com.kh.example.chap02_control.thread;

public class Thread4 implements Runnable {

	@Override
	public void run() {
		int count = 0;

		while(count < 10 && !Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(1000);
				System.out.println((++count) + "초");
			} catch (InterruptedException e) {
				// InterruptedException이 발생하면 isInterrupted가 true가 되도 false로 초기화시켜줌
				System.out.println(count + "초에 카운트 종료");
				Thread.currentThread().interrupt();	// 그래서 다시 true값을 주기 위해 다시 interrupt 시킴
			}
		}
	}

}
