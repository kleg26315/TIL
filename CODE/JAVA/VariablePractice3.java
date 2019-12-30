package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {
	public void vp3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가로 : ");
		double hor = Double.parseDouble(sc.nextLine()); 
		System.out.print("세로 : ");
		double ver =Double.parseDouble(sc.nextLine()); 
		
		System.out.println("면적 : "+(hor*ver));
		System.out.println("둘레 : "+((hor+ver)*2));
		
		
	}
}
