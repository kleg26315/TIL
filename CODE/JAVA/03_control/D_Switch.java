package com.kh.example.chap01.condition;

import java.util.Scanner;

public class D_Switch {
	// 조건식의 결과 값을 case에서 찾아 명령을 수행하는 조건문
	// 해당하는 값이 case에 없을 경우에는 default의 명령문 수행
	
	// case와 수행문 사이에는 콜론(:)을 써야하며
	// break가 없으면 멈추지 않고 계속 수행함
	
	public void method1() {
		// 정수 두 개와 연산 기호 문자 1개를 입력 받아서
		// 연산 기호 문자에 해당하는 계산을 수행하고 출력
		/*
		 	첫 번째 값 :
		 	두 번째 값 :
		 	연산자(+,-,*,/) :
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 값 : ");
		int first = Integer.parseInt(sc.nextLine());
		System.out.print("두 번째 값 : ");
		int second = Integer.parseInt(sc.nextLine()); // sc.nextInt() 는 줄바꿈(\n)을 버퍼에 남겨놓는다.
		System.out.print("연산자(+, -, *, /) : ");
		char operator = sc.nextLine().charAt(0);
		// java.lang.StringIndexOutOfBoundsException: String index out of range: 0
		// : 지정한 String 길이에 대해서 범위가 넘어갔다. 없는거에 대해서 가져오려고하니 에러가 남
		
		int result = 0;	// 연산 결과를 저장용 변수
		
		switch(operator) {
		case '+':
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			result = first / second;
			break;
		}
		
		System.out.println(first+" "+operator+" "+second+" = "+result);
	}
	
	public void method2() {
		// 과일을 입력하여 사과는 1000, 바나나는 3000, 복숭아는 2000, 키위는 5000
		// 과일가게에 없는 과일을 입력했을때는 "잘못입력하였습니다" 출력
		// 과일 이름을 입력하시오 :
		Scanner sc = new Scanner(System.in);
		System.out.print("과일 이름을 입력하시오 : ");
		String fruit = sc.nextLine();
		
		int price = 0;
		
		switch(fruit) {
		case "사과":
			price = 1000;
			break;
		case "바나나":
			price = 3000;
			break;
		case "복숭아":
			price = 2000;
			break;
		case "키위":
			price = 5000;
			break;
		default:
			System.out.println("잘못입력하였습니다.");
			return;		// 나를 호출한 메소드에게 돌아가는 기능
						// 이때 값을 가지고 돌아갈 수도 있고 아무것도 없이 돌아갈 수도 있음
		}
		
		System.out.println(fruit+"의 가격은 "+price+"원입니다.");			

	}
	
	public void method3() {
		// 사용자가 입력한 메뉴 번호에 따라서 메뉴가 출력
		/*
			1. 회원 등록
			2. 회원 수정
			3. 회원 삭제
			메뉴 번호를 입력하세요 :
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 회원 등록");
		System.out.println("2. 회원 수정");
		System.out.println("3. 회원 삭제");
		System.out.print("메뉴 번호를 입력하세요 : ");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			System.out.println("회원 등록 메뉴입니다.");
			break;
		case 2:
			System.out.println("회원 수정 메뉴입니다.");
			break;
		case 3:
			System.out.println("회원 삭제 메뉴입니다.");
			break;
		default:  
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void method4() {
		// 1월부터 12월까지 입력 받아 해당하는 달의 마지막 날짜를 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("1월~12월까지 중 하나를 입력하세요 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("입력하신 달은 31일까지입니다.");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("입력하신 달은 30일까지입니다.");
			break;
		case 2:
			System.out.println("입력하신 달은 28일 혹은 29일까지입니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
