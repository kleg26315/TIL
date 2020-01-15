package com.kh.example.chap03_user.controller;

import java.util.Scanner;

import com.kh.example.chap03_user.model.exception.MyException;

public class UserExceptionController {
	private Scanner sc = new Scanner(System.in);
	
	public void inputAge() {
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		try {
			checkAge(age);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void checkAge(int age) throws MyException {
		if(age < 19) {
			throw new MyException("입장 불가");			
		} else {
			System.out.println("즐거운 관람");
		}

	}
}
