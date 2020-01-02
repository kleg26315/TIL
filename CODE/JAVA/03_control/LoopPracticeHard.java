package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPracticeHard {
	public void pratice15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		boolean sosu = false;
		
		if(num<=2) {
			System.out.println("잘못 입력하셨습니다.");
		}
		else {
			for(int i =2; i<num; i++) {
				if(num%i==0)
				{
					sosu = true;
					break;
				}
			}
			
			if(sosu==true) {
				System.out.println("소수가 아닙니다.");
			} else {
				System.out.println("소수입니다.");
			}
		}
	}
	
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		boolean sosu = false;
		
		if(num<=2) {
			System.out.println("잘못 입력하셨습니다.");
			practice16();
		}
		else {
			for(int i =2; i<num; i++) {
				if(num%i==0)
				{
					sosu = true;
					break;
				}
			}
			
			if(sosu==true) {
				System.out.println("소수가 아닙니다.");
			} else {
				System.out.println("소수입니다.");
			}
		}
	}
	
	public void practice17() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		int flag = 1;
		int count=0;
		
		if(num<=2) {
			System.out.println("잘못 입력하셨습니다.");
			practice16();
		}
		else {
			for(int k=2; k<=num; k++) {
				flag=1;
				if(k==2) {
					System.out.print(k+" ");
					count++;
				}
				else {
					for(int i =2; i<k; i++) {
						if(k%i==0)
						{
							flag = 0;
							break;
						}
					}
					if(flag==1) {
						System.out.print(k+" ");
						count++;
					}
	
				}				
			}
			System.out.println();
			System.out.println("2부터 "+num+"까지 소수의 개수는 "+count+"개입니다.");
		}
	}
	
	public void practice18() {
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int num = sc.nextInt();
		int count =0;
		for(int i = 1; i<=num; i++) {
			if(i%2==0 && i%3==0) {
				count++;
				System.out.print(i+" ");
			}
			else if(i%3==0) {
				System.out.print(i+" ");
			}
			else if(i%2==0 ){
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("count : "+count);
	}
	
	public void practice19() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int row = 1;
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num-row; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<row; k++) {
				System.out.print("*");
			}
			row++;
			System.out.println();
		}
	}
	
	public void practice20() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i<num*2; i++) {
			if(i>=num) {
				for(int k=num*2-i; k>=1; k--) {
					System.out.print("*");
				}
				System.out.println();
			}
			else {
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}				
				System.out.println();
			}
		}
	}
	
	public void practice21() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int row = 1;
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num-row; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<row*2-1; k++) {
				System.out.print("*");
			}
			row++;
			System.out.println();
		}
		
	}
	
	public void practice22() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			if(i==1||i==num) {
				for(int k =0; k<num; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			else {
				System.out.print("*");
				for(int j=0; j<num-2; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
				System.out.println();
			}
		}
		
		
	}
}
