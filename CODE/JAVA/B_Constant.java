package com.kh.variable;

public class B_Constant {
	public void finalConstant() {
		int age; // 일반 변수 선언
		final int AGE; // 상수 선언
		
		age = 20;
		AGE = 20;

		System.out.println("age : "+age);
		System.out.println("AGE : "+AGE);

		// 변수의 값 변경
		age = 30;
//		AGE = 30;
		// The final local variable AGE may already have been assigned
		// : final변수 (상수)는 한번만 값을 저장할 수 있는데 또 바꾸려고 하니까 에러가 났다.
		
		System.out.println("값 변경 후 age : "+ age);
		System.out.println("값 변경 후 AGE : "+AGE);
	}
}
