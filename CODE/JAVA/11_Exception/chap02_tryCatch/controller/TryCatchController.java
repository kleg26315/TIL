package com.kh.example.chap02_tryCatch.controller;

import java.io.IOException;

public class TryCatchController {
	public void method1() {
		System.out.println("method1() 호출 됨...");
		try {
			method2();
			System.out.println("예외 발생 시에 출력될까? 출력안됨, method2에서 예외 발생하니까 catch로 넘어갔음");
		} catch (IOException e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception으로 잡음");
		} finally {
			System.out.println("예외 발생 여부와 상관 없이 무조건 수행됨");
		}
		System.out.println("method1() 종료 됨...");
	}
	
	public void method2() throws IOException {
		System.out.println("method2() 호출 됨...");
		method3();
		System.out.println("method2() 종료 됨...");
	}
	
	public void method3() throws IOException {
		System.out.println("method3() 호출 됨...");
		throw new IOException("IOException을 강제로 발생시켰습니다.");
//		System.out.println("method3() 종료 됨...");
		// Unreachable code
	}
}
