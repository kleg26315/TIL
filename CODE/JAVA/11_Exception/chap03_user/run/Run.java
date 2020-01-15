package com.kh.example.chap03_user.run;

import com.kh.example.chap03_user.controller.UserExceptionController;
import com.kh.example.chap03_user.model.exception.MyException;

public class Run {
	public static void main(String[] args) {
		UserExceptionController uec = new UserExceptionController();
		
		uec.inputAge();
	}
}
