package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
	/*
	 	for(초기식; 조건식; 증감식){
	 		실행 문장;
	 	}
	 	초기식 -> 조건식 -> (조건식이 true일 때)실행 문장 -> 증감식 -> 조건식 -> (반복)
	 	조건식 결과가 false가 될때까지 반복
	 	
	 	for문 안에 있는 초기식, 조건식, 증감식 모두 생략 가능
	 	하지만, 모두 생략했을 때 반복문이 무한으로 돌기 대문에
	 	for문 안이나 밖에다가 초기식은 무엇인지 조건은 무엇인지 증감은 얼마나 될건지를 모두 표기 해야 함
	 	즉, for() 안에서만 생략될 뿐 모두 필요한 요소임
	 */
	public void method1() {
		// 1부터 5까지 출력
		for(int i = 1; i<=5; i++) {
			System.out.println(i+"번째 반복문 수행");
		}
		
	}
	
	public void method2() {
		// 5부터 1까지 출력하기
		for(int i = 5; i>=1; i--) {
			System.out.println(i+"번째 반복문 수행");
		}
		
	}
	
	public void method2_1() {
		for(int i =8; i>=3; i--) {
			System.out.println(i);
		}
	}
	
	public void method3() {
		// 1에서 10 사이의 홀수만 출력
		for(int i =1; i<11; i++) {
			if(i%2==1) {
				System.out.println(i);
			}
		}
		
		/*
		 	복합대입 연산자 이용
		 	for(int i = 1; i<=10; i+=2){
		 		System.out.println(i);
		 	}
		 */
	}
	
	public void method4() {
		// 정수 두개를 입력 받아 그 사이 숫자 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 두 개를 입력하세요.");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=a; i<=b; i++) {
			System.out.print(i+" ");
		}

	}
	
	public void method4_1() {
		// 정수 하나를 입력 받아 그 수가 1~9사이의 수일때만 그 수의 구구단 출력
		// 조건이 맞지 않으면 "1~9사이의 양수를 입력하여야합니다" 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>=1 && num<=9) {
			for(int i=1; i<=9; i++) {
				System.out.println(num +" * "+i +" = "+(num*i));
			
			}
		} else {
			System.out.println("1~9사이의 양수를 입력하여야합니다.");
		}
		/*
			switch(num) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				for(int i=1; i<=9; i++) {
					System.out.println(num +" * "+i +" = "+(num*i));
				
				}
				break;
			default:
				System.out.println("1~9사이의 양수를 입력하여야합니다.");
			}
		*/
		}
	
	public void method5() {
		// 1부터 10사이의 임의의 난수를 정해 1부터 난수까지의 정수 합계
		// Math.random(); // 임의의 난수(실수)를 반환하는 메소드
		// 원래 Math.random()의 범위 : 0 <= Math.random() < 1
		// 10까지 만들기 위해 10 곱하기 : 0 <= Math.random() * 10 < 10
		// 10을 포함하기 위해 1 더하기 : 1 <= Math.random * 10 + 1 < 11
		// 정수로 만들기 위해 int형 변환 : 1 <= (int)(Math.random() * 10 + 1) < 11
		int random = (int)(Math.random() * 10 + 1);
		int sum =0;
		
		for(int i=1; i<=random; i++) {
			sum = sum +i;			
		}
		System.out.printf("1부터 %d까지 정수 합계 : %d",random, sum);
	}
	
	public void method6() {
		// 2단부터 9단까지 출력
		for(int i = 2; i<=9; i++) {
			for(int k=1; k<=9; k++) {
				System.out.println(i+" * "+k+" = "+(i*k));
			}
			System.out.println("-----------");
		}
	}
	
	public void method7() {
		// 아날로그 시게 출력 : 0시 0분 ~ 23시 59분
		for(int si = 0; si<24; si++) {
			for(int bun = 0; bun<=59; bun++) {
				System.out.println(si+"시 "+bun+"분");
			}
			System.out.println();
		}
	}
	
	public void method8() {
		// 한 줄에 별(*)표가 5번 출력되는데
		// 그 줄은 사용자가 입력한 수만큼 출력
		/*
		 	출력할 줄 수 : 3
		 	*****
		 	*****
		 	*****
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 줄 수 : ");
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			for(int k = 0; k<5; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public void method9() {
		// 한 줄에 별표 문자를 입력된 줄 수와 칸 수 만큼 입력
		// 단, 줄 수와 칸 수가 일치하는 위치에는 줄 번호에 대한 정수가 출력
		/*
		 	줄 수 : 6
		 	칸 수 : 6
		 	1*****
		 	*2****
		 	**3***
		 	***4**
		 	****5*
		 	*****6
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수 : ");
		int jul = sc.nextInt();
		System.out.print("칸 수 : ");
		int can = sc.nextInt();
		
		for(int i = 1; i<=jul; i++) {
			for(int k = 1; k<=can; k++) {
				if(i==k) {
					System.out.printf("%d",k);
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}
}
