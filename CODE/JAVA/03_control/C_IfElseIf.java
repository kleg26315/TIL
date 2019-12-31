package com.kh.example.chap01.condition;

import java.util.Scanner;

public class C_IfElseIf {
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 하나 입력하세요 : ");
		int num = sc.nextInt();
		
		String result = null;
		if(num>0) {
			result = "양수다";
		} else if(num ==0) {
			result = "0이다";
		} else if(num<0) {
			result=  "음수다";
		}
		
		System.out.println(result);
	}
	
	public void method2() {
		// 나이를 입력 받아 13살 이하면 "어린이", 13초과 19살 이하면 "청소년", 19살 초과 "성인" 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		if(age<=13) {
			System.out.println("어린이");
		} else if(age>19) {
			System.out.println("성인");
		} else {
			System.out.println("청소년");
		}
		
	}
}
