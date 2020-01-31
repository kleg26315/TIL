package com.kh.example.chap04_io.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import com.kh.example.chap04_io.model.vo.Person;

public class ClientController {
	public ClientController() {
		// 객체를 파일로 만들기 위한 Stream 구현 (파일 이름 : person.txt)
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))){
			ArrayList<Person> list = new ArrayList<>();
			list.add(new Person("박신우", 20));
			list.add(new Person("강건강", 30));
			list.add(new Person("남나눔", 25));
			
			for(Person p : list) {
				oos.writeObject(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startClient() {
		try {
			String server = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(server, 8500);
			
			if(socket != null) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				try {
					while(true) {
						Person p = (Person) ois.readObject();
						oos.writeObject(p);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e ) {
					oos.writeObject(null);
					oos.flush();
					
					ois.close();
					oos.close();
					socket.close();
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
