package com.kh.example.chap02.loop;

import java.util.Scanner;

public class C_DoWhile {
	public void method1() {
		// 키보드로 문자열 값을 입력 받아 출력 반복 실행
		// 단, exit가 들어오면 반복 종료
		Scanner sc = new Scanner(System.in);
//		String str = null;
		// Exception in thread "main" java.lang.NullPointerException
		// : null이면 아무것도 없는데 무엇을 비교하는지 모른다는거기 때문에 에러가 나는거임
		
//		// 1. while
//		String str = "";
//		while(!str.equals("exit")) {
//			System.out.print("문자열 입력 : ");
//			str = sc.nextLine();
//			System.out.print("str : "+str);
//			System.out.println();
//		}
		
		// 2. do while 문
		String str = null;
		// String str = null; 이 가능한 이유는 do ~ while 문은 while문 과 다르게 일단 한번은 실행되기 때문에
		// str안에 값이 들어간 상태서 while이 돌기 때문에 가능함
		do {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.print("str : "+str);
			System.out.println();
		} while(!str.equals("exit"));		
	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		int menuNum =0;
		do {
			System.out.println("1. 테스트 1");
			System.out.println("2. 테스트 2");
			System.out.println("3. 테스트 3");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1: System.out.println(1); break;
			case 2: System.out.println(2); break;
			case 3: System.out.println(3); break;
			case 9: System.out.println("종료합니다."); break;
			default: System.out.println("잘못 입력하셨습니다."); break;
			}
		} while(menuNum!=9);
		// do while 은 do 안에가 먼저 실행되는건 맞지만 while menuNum에 빨간 줄이 뜨는 이유는
		// while menuNum은 do 밖에 있는 구문이기 때문에 에러가 남
	}
}
