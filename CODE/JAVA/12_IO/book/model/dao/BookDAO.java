package com.kh.practice.book.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {
	private Book[] bArr = new Book[10];
	
	public void fileSave(Book[] bArr) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"))){
			
			for(int i=0; i<bArr.length; i++) {
				if(bArr[i] != null) {
					oos.writeObject(bArr[i]);
				}
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Book[] fileRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"))){
			
			for(int i=0; i<bArr.length; i++) {
				//if(bArr[i] != null)		// 처음에 도서를 불러올때는 객체배열에 아무것도 들어있지 않기 때문에 이 조건은 빼야함
				bArr[i] = (Book) ois.readObject();
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return bArr;
	}
}
