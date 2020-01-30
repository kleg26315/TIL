package kh.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import kh.model.vo.Book;

public class ClientController2 {
	public void fileSave() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
			ArrayList<Book> list = new ArrayList<>();
			list.add(new Book("�ڹٸ� ��ƶ�",30000));
			list.add(new Book("����Ŭ ����", 35000));
			list.add(new Book("��ǥ�� 2.0", 27500));
			list.add(new Book("�ڹ� Servlet/JSP", 28000));
			list.add(new Book("ajax ����", 15000));
			
			for(Book b : list) {
				System.out.println(b);
			}
			
			for(Book b : list) {
				oos.writeObject(b);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
			ArrayList<Book> list = new ArrayList<>();
			
			while(true) {
				try {
					list.add((Book) ois.readObject());
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					for(int i=0; i<list.size(); i++) {
						System.out.println(list.get(i));
					}
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
