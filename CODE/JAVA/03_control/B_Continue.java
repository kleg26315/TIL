package com.kh.example.chap03.branch;

public class B_Continue {
	// continue는 반복문 안에서만 사용 가능
	// continue를 만나면 아래 문장 실행하지 않고
	// 반복문을 다시 시작함
	// for문의 경우 증감식으로 가고, while문의 경우 조건식으로 감
	public void method1() {
		// 1~100까지 정수들의 합계를 출력하되 단, 4의 배수는 빼고 계산
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			if(i%4==0) {
				continue;
			}
			
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println();
		System.out.println("sum = "+sum);
	}
	
	public void method2() {
		// 구구단 출력 : 짝수 단, 짝수 수 빼고 출력
		
		int dan = 2;
		int dan2 = 9;
		
		while(dan<=9) {
			dan2 = 1;
			while(dan2<=9) {
				if(dan%2==0 || dan2%2==0) {
					dan2++;
					continue;
				}
				System.out.println(dan+" * "+dan2+" = "+(dan*dan2));
				dan2++;
			}
			dan++;
			System.out.println();
		}
	}
}
