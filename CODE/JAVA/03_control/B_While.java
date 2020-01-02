package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
	/*
	 	while(조건식){
	 		실행 문장;
	 		[증감식 or 분기문];
	 	}
	 	조건식 확인 -> (조건식이 true일 때) 실행 문장 수행 -> 조건식 확인 -> (반복)
	 	조건식 결과가 false가 될 때까지 반복
	 */
	public void method1() {
		// 1부터 5까지 출력
		int i = 1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
	}
	
	public void method2() {
		// 5부터 1까지 출력
		int i = 0;
		while(i<5) {
			System.out.println(5-i);
			i++;
		}
	}
	
	public void method3() {
		// 1에서 10 사이의 홀수만 출력
		int i =1;
		while(i<11) {
			if(i%2==1) {
				System.out.println(i);
			}
			i++;
		}
	}
	
	public void method4() {
		// 정수 두 개를 입력 받아 그 사이 숫자 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 두 개를 입력하세요");
		System.out.print("\n단, 첫 번째 숫자가 두 번째 숫자보다 작게 입력하세요\n");
		System.out.print("첫 번째 숫자 : ");
		int first = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int second = sc.nextInt();
		
		while(first<=second) {
			System.out.println(first);
			first++;
		}
		
	}
	
	public void method4_1() {
		// 정수를 하나 입력 받아 그 수가 1~9 사이의 수 일때만 그 수의 구구단 출력
		// 조건이 맞지 않으면 1~9사이의 양수를 입력하여야합니다 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 한 개를 입력하세요 : ");
		int num = sc.nextInt();
		int dan = 1;
		
		if(num>=1 && num<=9) {
			while(dan<=9) {
				System.out.println(num+" * "+dan+" = "+ (num*dan));
				dan++;
			}
		} else {
			System.out.println("1~9사이의 양수를 입력하여야합니다.");
		}
	}
	
	public void method5() {
		// 1부터 10 사이의 임의의 난수를 정해 1 부터 난수까지의 정수 합계 출력
		int random = (int)(Math.random() * 10 + 1);
		int i =1;
		int sum = 0;
		System.out.println(random);
		while(i<=random) {
			sum = sum + i;
			i++;
		}
		System.out.println(sum);
		
	}
	
	public void method6() {
		// 사용자에게 문자열을 입력 받아 인덱스 별로 문자 출력
		// 문자열 입력 : apple
		// 0 : a
		// 1 : p
		// 2 : p
		// 3 : l
		// 4 : e
		Scanner sc =new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		int i = 0;
		while(i<str.length()) {
			System.out.println(i+" : "+str.charAt(i));
			i++;
		}
		
		for(int j =0; j<str.length(); j++) {
			System.out.println(j + " : " + str.charAt(j));
			
		}
	}
	
	public void method7() {
		// 2단부터 9단까지 출력
		int num = 2;
		
		while(num<=9) {
			int dan=1;
			while(dan<=9) {
				System.out.println(num + " * " +dan+" = " +(num*dan));
				dan++;
			}
			num++;
			System.out.println("-------------");
		}
		
	}
	
	public void method8() {
		// 아날로그 시계
		int hour = 0;
		int min = 0;
		
		while(hour < 24) {
			min = 0;
			while(min<60) {
				System.out.printf("%2d시 %02d분 \n",hour,min);
				min++;
			}
			hour++;
		}
	}
	
	public void method9() {
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		
		while(menu!=9) {
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1까지 출력");
			System.out.println("3. 1~10사이 홀수 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1: method1(); break;
			case 2: method2(); break;
			case 3: method3(); break;
			case 9: System.out.println("종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
}
