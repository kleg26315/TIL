package com.kh.example.chap00_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method1() {
		
		try {
			File f1 = new File("test.txt");
			f1.createNewFile();
			
			File f2 = new File("c:/test/test.txt");
			f2.createNewFile();
			
			File f3 = new File("c:\\temp3\\temp2");
			File f4 = new File("c:\\temp3\\temp2\\test.txt");
			f3.mkdirs();
			f4.createNewFile();
			f4.delete();
			
			System.out.println(f2.exists()); // true : 파일이든 폴더든 존재하면 true 반환
			System.out.println(f3.exists()); // true
			System.out.println(f3.isFile()); // false : exists()와 다르게 파일만 존재여부 확인
			
			// 그 외 메소드들
			System.out.println("파일 명 : "+f1.getName()); // test.txt
			System.out.println("저장 절대 경로 : "+ f1.getAbsolutePath()); // D:\1_java_workspace\13_IO\test.txt
			System.out.println("저장 상대 경로 : "+ f1.getPath()); // test.txt
			
			System.out.println("파일 용량 : " + f1.length()); // 0
 			System.out.println("f1 상위 폴더 : "+ f1.getParent()); // null
			System.out.println("f4 상위 폴더 : " + f4.getParent()); // c:\temp3\temp2
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
