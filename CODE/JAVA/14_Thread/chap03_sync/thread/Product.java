package com.kh.example.chap03_sync.thread;

import com.kh.example.chap03_sync.resource.Resources;

// 공유데이터 값 넣는 일을 하는 생산자 클래스
public class Product extends Thread {
	private Resources criticalData;
	
	public Product() {}
	public Product(Resources resources) {
		this.criticalData = resources;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			criticalData.setData(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
