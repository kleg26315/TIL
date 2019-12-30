package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		System.out.println();
		String result = num > 0 ? "양수다" : "양수가 아니다";
		System.out.println(result);
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		System.out.println();
		String result = num > 0 ? "양수다" : (num==0 ? "0이다" : "음수다");
		System.out.println(result);
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		System.out.println();
		String result = num%2 ==0 ? "짝수다" : "홀수다";
		System.out.println(result);
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		System.out.println();
		System.out.println("1인당 사탕 개수 : "+candy/people);
		System.out.println("남은 사탕 개수 : "+candy%people);
		
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("학년(숫자만) : ");
		int grade = Integer.parseInt(sc.nextLine());
		System.out.print("반(숫자만) : ");
		int ban = Integer.parseInt(sc.nextLine());
		System.out.print("번호(숫자만) : ");
		int number = Integer.parseInt(sc.nextLine());		
		System.out.print("성별(M/F) : ");
		char chGender = sc.nextLine().charAt(0);
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = Double.parseDouble(sc.nextLine());
		System.out.println();
		String gender = chGender=='M'?"남학생":"여학생";
		System.out.print(grade+"학년 "+ban+"반 "+number+"번 "+name+" "+gender+"의 성적은 "+score+"이다.");				
	}

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		String str = age<=13 ? "어린이" : age<=19? "청소년":"성인";
		System.out.println();
		System.out.println(str);
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int korea = sc.nextInt();
		System.out.print("영어 : ");
		int english = sc.nextInt();
		System.out.print("수학 : ");
		int math = sc.nextInt();
		System.out.println();
		System.out.println("합계 : "+(korea+english+math));
		double avg = (double)(korea+english+math)/3.0;
		System.out.println("평균 : "+avg);
		String result = korea>=40 && english>=40 && math>=40 && avg >=60 ? "합격" : "불합격";
		System.out.println(result);
		
		
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요(- 포함) : ");
		String juminNumber = sc.nextLine();
		String result = juminNumber.charAt(7)==1?"남자":"여자";
		System.out.println();
		System.out.println(result);
	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int input = sc.nextInt();
		String isTrue = input<=num1 || input>num2 ? "true" :"false";
		System.out.println();
		System.out.println(isTrue);
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int input1 = sc.nextInt();
		System.out.print("입력2 : ");
		int input2 = sc.nextInt();
		System.out.print("입력3 : ");
		int input3 = sc.nextInt();
		String result = (input1==input2) ? (input2==input3)?"ture":"false":"false";
		System.out.println();
		System.out.println(result);
	}

	public void practice11() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A사원의 연봉 : ");
		int a = sc.nextInt();
		System.out.print("B사원의 연봉 : ");
		int b = sc.nextInt();
		System.out.print("C사원의 연봉 : ");
		int c = sc.nextInt();
		
		System.out.println();
		double A_insen = a+(a*0.4);
		double B_insen = b;
		double C_insen = ((double)c+((double)c*0.15));
		
		System.out.println("A사원 연봉/연봉+a : "+a+"/"+A_insen);
		System.out.println(A_insen >=3000 ?"3000 이상":"3000 미만");
		
		System.out.println("B사원 연봉/연봉+a : "+b+"/"+B_insen );
		System.out.println(B_insen >=3000 ?"3000 이상":"3000 미만");
		
		System.out.println("C사원 연봉/연봉+a : " +c+"/"+C_insen);
		System.out.println(C_insen >=3000 ?"3000 이상":"3000 미만");
		
	}

}
