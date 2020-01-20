package com.kh.example.chap01_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileOpen() {
		
		try (FileInputStream fis = new FileInputStream("a_byte.txt")) {
			
			int value = 0;
			
//			while(fis.read() != -1) {
//				System.out.println((char)fis.read() + " ");
//			}
			
			while((value = fis.read()) != -1) {
				System.out.print((char)value+" ");
			}
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public void fileSave() {
			
		try (FileOutputStream fos = new FileOutputStream("a_byte.txt" /* , true */)){ 
			                                               // 매개변수로 뒤에 true를 넣으면 이어쓰기가 되고 없으면 덮어쓰기가 됨)
			// write(int b):void
			fos.write(97);
			
			// write(byte[] b):void
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			//			   b   c    d   e    f    g
			fos.write(bArr);
			
			// write(byte[] b, int off, int len):void
			fos.write(bArr, 1, 3);	// 1 index부터 3개 : cde
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}
}
