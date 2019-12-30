package com.kh.variable;

import java.util.Scanner;

public class E_KeyboardInput {
	public void inputScanner() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : "); // 안내 문구 역할

		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		System.out.print("키(소수점 첫째 자리까지 입력) : ");
		double height = sc.nextDouble();
		
		System.out.println(name + "님은 " + age +"세이며, 키는 " +height+ "cm 입니다.");
		
	}
	
	public void inputScanner2() {
		// 사용자에게 이름과 나이를 입력 받으세요
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt();
//		sc.nextLine();
//		String address = sc.nextLine();
		
		// 해결하는 방법
		// 방법1. 줄바꿈을 가져갈 수 있는 nextLine() 추가
//		int age = sc.nextInt();
//		sc.nextLine(); // 버퍼에 남아있는 줄바꿈을 가져와주는 역할
//		System.out.print("주소를 입력하세요 : ");
//		String address = sc.nextLine();
		
		// 방법2. age를 받을 때도 nextLine()을 쓰되 int로 파싱하기
		// 파싱 : 문자열을 기본자료형으로 바꿔주는 일
		int age = Integer.parseInt(sc.nextLine());
//		String userAge = sc.nextLine();
//		int age = Integer.parseInt(userAge);
		System.out.print("주소를 입력하세요 : ");
		String address = sc.nextLine();

		// 방법3. next()로 주소를 받기
		// 한계 : next()는 띄어쓰기를 구분자로 인식하기 때문에 처음에 쓴 것만 가져온다.
//		int age = sc.nextInt();
//		System.out.print("주소를 입력하세요 : ");
//		String address = sc.next();
		
		// + 추가 : char형을 받고 싶을 때는?
		System.out.print("성별을 입력하세요 : "); // F / M
//		String userGender = sc.nextLine();
//		char gender = userGender.charAt(0);
		char gender = sc.nextLine().charAt(0);
		
		
		System.out.println("이름은 " +name+" 나이는 " +age+" 주소는 "+ address +" 성별은 " +gender +" 입니다.");
	}
}
