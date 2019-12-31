package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_IfElse {
	// if-else문
	// if(조건식){
	//		실행할 문장1;
	// } else {
	//		실행할 문장2;
	// }
	// 둘 중 한 개를 선택하는 조건문
	// 조건식 결과 값이 참(true)이면 if문 안에 있는 실행할 문장1 수행
	// 조건식 결과 값이 거짓(false)이면 if문을 빠져나와 else문 안에 있는 실행할 문장2 수행
	
	public void method1() {
		// 키보드로 입력한 숫자가 짝수인지 홀수인지 출력
		
		// '숫자 한 개를 입력하세요 : ' 안내문구 출력 후 num변수에 데이터 저장
		// 짝수이면 "입력하신 숫자는 짝수입니다.", 홀수이면 "입력하신 숫자는 홀수입니다" 출력
		// 프로그램이 끝날 때 "프로그램 종료" 까지 출력 후 종료
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num%2==0) {
			System.out.println("입력하신 숫자는 짝수입니다.");
		} else {
			System.out.println("입력하신 숫자는 홀수입니다.");
		}
		
		System.out.println("프로그램 종료");
		
	}
	
	public void method2() {
		// 사용자에게 국어, 영어, 수학 점수를 입력 받아서 각각 kor, eng, math 변수에 저장
		// 각 과목 점수가 40점 이상이고 세 과목 평균 점수가 60점 이상일 때 "시험 통과",
		// 하나라도 기준 미달일 때 "시험 불통과" 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		double avg = (double)(kor+eng+math)/3.0;
		
		if (kor>=40 && eng>=40 && math>=40 && avg >=60) {
			System.out.println("시험 통과");			
		} else {
			System.out.println("시험 불통과");
		}
		
	}
	
	public void method3() {
		// 문자열 비교하기 : String클래스 안에 있는 equals() 메소드를 이용
		// boolean java.lang.String.equlas(Object object)
		// 사용자에게 이름을 받는데 내가 지정한 이름과 같으면 "본인입니다"
		// 같지 않으면 "본인이 아닙니다" 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		String park = "박신우";
		String park2 = "박신우";
		if(park2==park) {
			System.out.println("본인입니다.");
		} else {
			System.out.println("본인이 아닙니다.");
		}
		
	}
}
