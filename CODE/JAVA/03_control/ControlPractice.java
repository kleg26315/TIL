package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("9. 종료");
		System.out.print("메뉴 번호를 입력하세요  : ");
		menuNum = sc.nextInt();
		
		switch(menuNum) {
		case 1: System.out.println("입력메뉴입니다"); break;
		case 2: System.out.println("수정메뉴입니다"); break;
		case 3: System.out.println("조회메뉴입니다"); break;
		case 4: System.out.println("삭제메뉴입니다"); break;
		case 7: System.out.println("프로그램이 종료됩니다."); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>0) {
			if(num%2==0) {
				System.out.println("짝수다");
			}
			else {
				System.out.println("홀수다");
			}
		}
		else {
			System.out.println("양수만 입력해주세요.");
		}	
		
	}

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int korea = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int english = sc.nextInt();
		int sum = korea+math+english;
		double avg =(sum)/3.0;
		if(korea>=40 && english>=40 && math >= 40 && avg>=60) {
			System.out.println("국어 : "+korea);
			System.out.println("수학 : "+math);
			System.out.println("영어 : "+english);
			System.out.println("합계 : "+sum);
			System.out.println("평균 : "+avg);
			System.out.println("축하합니다, 합격입니다!");
		}
		else {
			System.out.println("불합격입니다.");
		}
		
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 12:
		case 1:
		case 2:
			System.out.println(num+"월은 겨울입니다.");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println(num+"월은 봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println(num+"월은 여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println(num+"월은 가을입니다.");
			break;
			
		default: System.out.println(num+"월은 잘못 입력된 달입니다.");
		}
		
	}

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		String id = "myId";
		String password = "myPassword12";
		
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String inputPassword = sc.nextLine();
		
		if(id.equals(inputId) && password.equals(inputPassword)) {
			System.out.println("로그인 성공");
			
		}
		else if(id.equals(inputId) && !password.equals(inputPassword)) {
			System.out.println("비밀번호가 틀렸습니다.");
		}
		else if(!id.equals(inputId) && password.equals(inputPassword)) {
			System.out.println("아이디가 틀렸습니다.");
		}
		else {
			System.out.println("둘다 틀렸습니다.");
		}
		
	}

	public void practice6() {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String str = sc.nextLine();
		
		switch(str) {
		case "관리자": System.out.println("회원관리, 게시글 관리, 게시글 작성, 댓글 작성, 게시글 조회"); break;
		case "회원": System.out.println("게시글 작성, 게시글 조회, 댓글 작성"); break;
		case "비회원": System.out.println("게시글 조회");
		default : System.out.println("잘못 입력하셨습니다.");
		}
		
	}

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("키(m)를 입력해주세요 : ");
		double key = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (key*key);
		
		if(bmi<18.5) {
			System.out.println("BMI 지수 : "+bmi);
			System.out.println("저체중");
		}
		else if(bmi >= 18.5 && bmi<23) {
			System.out.println("BMI 지수 : "+bmi);
			System.out.println("정상체중");
		}
		else if(bmi >= 23 && bmi<25) {
			System.out.println("BMI 지수 : "+bmi);
			System.out.println("과체중");
		}
		else if(bmi >= 25 && bmi<30) {
			System.out.println("BMI 지수 : "+bmi);
			System.out.println("비만");
		}
		else if(bmi >= 30) {
			System.out.println("BMI 지수 : "+bmi);
			System.out.println("고도 비만");
		}
		
		
	}

	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("피연산자1 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		char op = sc.next().charAt(0);
		double result =0;
		switch(op) {
		case '+':
			if(num1>0 && num2>0) {
				result = num1 + num2;
				System.out.println(num1+" "+op+" "+num2+" = "+result);
			}
			else {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
			break;
		case '-':
			if(num1>0 && num2>0) {
				result = num1 - num2;
				System.out.println(num1+" "+op+" "+num2+" = "+result);
			}
			else {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
			break;
		case '*':
			if(num1>0 && num2>0) {
				result = num1 * num2;
				System.out.println(num1+" "+op+" "+num2+" = "+result);
			}
			else {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
			break;
		case '/':
			if(num1>0 && num2>0) {
				result = (double)num1 / (double)num2;
				System.out.println(num1+" "+op+" "+num2+" = "+result);
			}
			else {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
			break;
		case '%':
			if(num1>0 && num2>0) {
				result = num1 % num2;
				System.out.println(num1+" "+op+" "+num2+" = "+result);
			}
			else {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
			break;
		default: 	System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
		
	}

	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		int middle = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int last = sc.nextInt();
		System.out.print("과제 점수 : ");
		int assignment = sc.nextInt();
		System.out.print("출석 회수 : ");
		int attendance = sc.nextInt();
		System.out.println("============= 결과  =============");
		double middleScore = (20*middle) / 100;
		double lastScore = (30*last) / 100;
		double assignmentScore = (30*assignment)/100;
		double attendanceScore = attendance;
		double total = middleScore+ assignmentScore+ lastScore + attendanceScore;
		
		if(total>=70 && attendanceScore>=(20*0.7)) {
			System.out.println("총점 : "+total);
			System.out.println("PASS");
		}
		else if(attendanceScore<(20*0.7) && total>=70){
			System.out.println("총점 : "+total);
			System.out.println("Fail [출석 회수 부족 (" +attendance+"/20)]");
		}
		else if(attendanceScore<(20*0.7) && total<70) {
			System.out.println("총점 : "+total);
			System.out.println("Fail [점수 미달, 출석 회수 부족 ("+attendance+"/20)]");
		}
		else if(total<70 && attendanceScore>=(20*0.7)) {
			System.out.println("총점 : "+total);
			System.out.println("Fail [점수 미달]");
		}
	}

	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		int menu = 100;
		while(menu!=0) {
			System.out.println("1. 메뉴 출력");
			System.out.println("2. 짝수/홀수");
			System.out.println("3. 합격/불합격");
			System.out.println("4. 계절");
			System.out.println("5. 로그인");
			System.out.println("6. 권한 확인");
			System.out.println("7. BMI");
			System.out.println("8. 계산기");
			System.out.println("9. P/F");
			System.out.println("0. 종료");
			
			System.out.print("선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1: practice1(); break;
			case 2: practice2(); break;
			case 3: practice3(); break;
			case 4: practice4(); break;
			case 5: practice5(); break;
			case 6: practice6(); break;
			case 7: practice7(); break;
			case 8: practice8(); break;
			case 9: practice9(); break;
			case 0: System.out.println("프로그램을 종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}		
	}


}
