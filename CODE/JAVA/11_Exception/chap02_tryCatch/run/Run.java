package com.kh.example.chap02_tryCatch.run;

import com.kh.example.chap02_tryCatch.controller.TryCatchController;

public class Run {
	public static void main(String[] args) {
		TryCatchController tcc = new TryCatchController();
		tcc.method1();
		
		System.out.println("정상적으로 종료됨...");
	}
}
