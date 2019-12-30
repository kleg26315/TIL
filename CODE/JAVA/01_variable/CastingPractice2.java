package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	public void cp2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("±¹¾î : ");
		double korea = Double.parseDouble(sc.nextLine());
		
		System.out.print("¿µ¾î : ");
		double english = Double.parseDouble(sc.nextLine());
		
		System.out.print("¼öÇÐ : ");
		double math = Double.parseDouble(sc.nextLine());
		
		System.out.println("ÃÑÁ¡ : "+(int)(korea+english+math));
		System.out.println("Æò±Õ : "+(int)((korea+english+math)/3));
		
		
	}
}
