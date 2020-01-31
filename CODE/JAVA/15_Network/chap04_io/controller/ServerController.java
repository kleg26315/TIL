package com.kh.example.chap04_io.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.kh.example.chap04_io.model.vo.Person;

public class ServerController {
	public void startServer() {
		// 서버 포트 정하기
		// 서버용 소켓 객체 생성
		// 클라이언트 요청 기다림
		// 요청 수락 후 클라이언트 소켓 객체 생성
		// 입출력 스트림 생성
		// 보조스트림
		// 읽고쓰기
		// 종료
		try {
			int port = 8500;
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("클라이언트의 요청을 기다리는중...");
			
			Socket client = server.accept();
			
			InputStream input = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(input);

			Person message = null;
			while(true) {
				message = (Person) ois.readObject();
				
				if(message != null) {
					System.out.println(client.getInetAddress().getHostAddress() +"가 보낸 메시지 : "+ message);
				}
				else {
					break;
				}
			}
			
			ois.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
