package com.kh.operator;

public class D_Comparison {
	public void method1() {
		int a = 10;
		int b = 25;
		
		boolean result1 = (a == b); // false
		boolean result2 = (a <= b); // true
		boolean result3 = ( a> b); // false
		
		System.out.println("result1 : "+result1);
		System.out.println("result2 : "+result2);
		System.out.println("result3 : "+result3);
		
		System.out.println("b가 짝수인가? "+ (b % 2==0));
		System.out.println("b가 홀수인가? "+ (b %2 !=0));
		System.out.println("b가 홀수인가? "+ (b %2 ==1));
	}
}
