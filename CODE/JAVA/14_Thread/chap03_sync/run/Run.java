package com.kh.example.chap03_sync.run;

import com.kh.example.chap03_sync.resource.Resources;
import com.kh.example.chap03_sync.thread.Customer;
import com.kh.example.chap03_sync.thread.Product;

public class Run {
	public static void main(String[] args) {
		Resources resources = new Resources();
		
		Thread t1 = new Product(resources);
		Thread t2 = new Customer(resources);
		
		t1.start();
		t2.start();
		
		// java.lang.IllegalMonitorStateException
		// wait()가 동기화블록/동기화메소드 안에서 사용되어야하는데 일반 메소드 안에서 사용되었기 때문에 뜨는 에러
		
	}
}
