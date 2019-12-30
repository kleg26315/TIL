package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice2 {
	public void vp2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수 : ");
		int fNum = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int sNum = sc.nextInt();
		System.out.println("더하기 결과 : "+ (fNum+sNum));
		System.out.println("빼기 결과 : "+ (fNum-sNum));
		System.out.println("곱하기 결과 : "+ (fNum*sNum));
		System.out.println("나누기 결과 : "+ (fNum/sNum));
		
	}
}
