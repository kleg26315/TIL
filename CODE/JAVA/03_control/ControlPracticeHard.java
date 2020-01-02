package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPracticeHard {
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 입력(1000~9999) : ");
		String str = sc.nextLine();
		int num = Integer.parseInt(str);
		int flag =10;

		if(str.length()!=4) {
			System.out.println("자리수 안맞음");
		}
		else {
			for(int i =0; i<str.length(); i++) {
				if(flag==1) {
					break;
				}
				for(int j=0; j<str.length(); j++) {
					if(i!=j) {
						if(str.charAt(i)==str.charAt(j)){
							flag=1;
							break;
						}
						else {
							flag=0;
						}
					} 
				}
			}
			if(flag==0) {
				System.out.println("성공");
			}
			else {
				System.out.println("중복 값 있음");
			}
		}
		

	}
}
