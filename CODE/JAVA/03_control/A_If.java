package com.kh.example.chap01.condition;

import java.util.Scanner;

public class A_If {
	/*
	 	단독 if문
	 	if(조건식){
	 		실행할 문장;
	 	}
	 	
	 	조건식의 결과 값이 참이면 {} 안에 있는 코드 실행
	 	조건식의 결과 값이 거짓이면 {} 안에 있는 코드는 무시하고 넘어감
	 */
	
	public void method1() {
		// 키보드로 입력한 숫자가 양수인지 음수인지 출력하시오
		// '숫자를 한 개 입력하세요 : ' 안내멘트 띄운 후 num 변수에 입력한 정수 저장
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num>0) {
			System.out.println("입력하신 숫자는 양수입니다");
		}
		if (num==0) {
			System.out.println("입력하신 숫자는 0입니다");
		}
		if (num<0) {
			System.out.println("입력하신 숫자는 음수입니다");
		}
		
		System.out.println("프로그램 종료");
		
	}
	
	public void method2(){
		// 키보드로 입력한 숫자가 짝수인지 홀수인지 출력
		
		// '숫자 한 개를 입력하세요 : ' 안내문구 출력 후 num변수에 데이터 저장
		// 짝수이면 "입력하신 숫자는 짝수입니다.", 홀수이면 "입력하신 숫자는 홀수입니다" 출력
		// 프로그램이 끝날 때 "프로그램 종료" 까지 출력 후 종료
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num%2==0) {
			System.out.println("입력하신 숫자는 짝수입니다");
		}
		if (num%2==1) {
			System.out.println("입력하신 숫자는 홀수입니다");
		}
		
		System.out.println("프로그램 종료");
			
		
	}
}
