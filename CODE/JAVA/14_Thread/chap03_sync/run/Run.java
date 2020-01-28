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
		// wait()�� ����ȭ���/����ȭ�޼ҵ� �ȿ��� ���Ǿ���ϴµ� �Ϲ� �޼ҵ� �ȿ��� ���Ǿ��� ������ �ߴ� ����
		
	}
}
