package com.kh.example.chap02_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharDAO {
	public void fileSave() {
		try (FileWriter fw = new FileWriter("b_char.txt")) {
			fw.write("¿Í, IO Àç¹Õ´Ù !!");
			fw.write('A');
			fw.write(' ');
			char[] cArr = {'a','p','p','l','e'};
			fw.write(cArr);
		} catch(IOException e){
			e.printStackTrace();
		} 
	}
	
	public void fileOpen() {
		try (FileReader fr = new FileReader("b_char.txt")) {
			int value =0;			
			while((value=fr.read()) != -1) {
				System.out.print((char)value+ " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
