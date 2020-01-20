package com.kh.example.chap03_assist.part01_buffer.model.vo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferDAO {
	public void output() {
		try (FileWriter fw = new FileWriter("c_buffer.txt");
				BufferedWriter bw = new BufferedWriter(fw);) {
			
//			FileWriter fw = new FileWriter("c_buffer.txt");
			// 이 자체로도 데이터를 저장할 수 있음
			// 하지만 여기에 성능향상을 시키고 싶어서 보조 스트림을 달 예정임
			// 성능향상과 관련된 보조스트림은 BufferedXXXXX인데
			// 종류가 4개... => BufferedInputStream
			//				 BufferedReader
			//				 BufferedOutputStream
			//				 BufferedWriter
//			BufferedWriter bw = new BufferedWriter(fw); 
			bw.write("안녕하세요\n");
			bw.write("반갑습니다.\n");
			bw.write("저리가세요\n");
			
			// close를 통해 닫아줄 때 보조 스트림만 닫아줘도 기반 스트림을 포함하고 있기 때문에
			// 보조 스트림만 close해주면 됨
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void input() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
			String value;
			
			while((value=br.readLine()) != null)
				System.out.println(value);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
