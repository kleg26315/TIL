package com.kh.variable;

public class C_Overflow {
	public void overflow() {
		byte bNum = 127;
		bNum = (byte) (bNum + 1);
		
		System.out.println("bNum : "+bNum);
	}
	
	public void calc() {
		int num1 = 1000000;
		int num2 = 700000;
		
		long result = (long) num1 * num2;
		System.out.println("계산 결과 : "+ result);
	}
}
