package com.kh.example.chap02_control.controller;

import java.util.Scanner;

import com.kh.example.chap02_control.thread.Thread4;

public class InterruptController {
	public void sleepInterrupt() {
		Thread4 th4 = new Thread4();
		Thread thread = new Thread(th4);
		
		thread.start();
		
		Scanner sc =new Scanner(System.in);
		System.out.println("�ƹ� ���̳� �Է��ϼ��� : ");
		String input = sc.nextLine();
		System.out.println("�Է��� �� : " + input);
		// 10�� ī��Ʈ �� �ƹ� ���̳� �Է� ������ ī��Ʈ �����ϱ�
		thread.interrupt();
		System.out.println("isInterrupted() : "+ thread.isInterrupted());
	}
}
