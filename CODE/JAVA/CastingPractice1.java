package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {
	public void cp1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 : ");
		char ch1 = sc.nextLine().charAt(0);
		System.out.println(ch1+" unicode : "+ (int)ch1);
		
		System.out.print("문자 : ");
		char ch2 = sc.nextLine().charAt(0);
		System.out.println(ch2+" unicode : "+ (int)ch2);
		
		
	}
}
