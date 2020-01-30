package com.kh.example.chap02_sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// ServerSocket
	//		포트와 연결되어 외부의 요청을 기다리다가 요청이 들어오면
	// 		Socket을 생성하여 소켓과 소켓간의 통신이 이루어지도록 함
	// 		한 포트에 한 ServerSocket만 연결 가능
	// Socket
	//		프로세스 간 통신 담당
	//		InputStream/OutputStream 보유 : 이 스트림을 통해 프로세스 간의 통신(입출력)이 이루어짐
	
	public void serverStart() {
		// 서버용 TCP소켓 프로그래밍 순서
		// 1) 서버 포트 번호 지정
		// 2) 서버용 소켓 객체 생성 후 포트와 결합
		// 3) 클라이언트 요청이 오기를 기다림
		// 4) 접속 요청이 오면 접속 수락 후 (accpet()) 클라이언트에 대한 소켓 객체 생성
		// 5) 연결된 클라이언트와 입출력 스트림 생성
		// 6) 보조스트림을 통한 성능 개선
		// 7) 스트림을 통해 읽고 쓰기
		// 8) 통신 종료
		
		// 1) 서버 포트 번호 지정
		int port = 8500;	// 0 ~ 65535(1023번 이하는 이미 사용 중인 포트가 많으니 이외의 포트 지정하기)
		try {
			// 2) 서버용 소켓 객체(ServerSocket) 생성 후 포트와 결합
			ServerSocket server = new ServerSocket(port);
			
			// 3) 클라이언트 요청이 오기를 기다림
			System.out.println("클라이언트의 요청을 기다리고 있습니다...");
			
			// 4) 접속 요청이 오면 접속 수락 후 (accpet()) 클라이언트에 대한 소켓 객체 생성
			Socket client = server.accept();
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.println(clientIP+"가 연결을 요청함...");
			
			// 5) 연결된 클라이언트와 입출력 스트림 생성
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			
			// 6) 보조스트림을 통한 성능 개선
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			// 7) 스트림을 통해 읽고 쓰기
			String message = br.readLine();
			System.out.println(clientIP + "가 보낸 메세지 : "+message);
			
			pw.println("만나서 반갑습니다.");
			pw.flush(); // 버퍼에 남아 있는 것을 비우는 역할
			
			// 8) 통신 종료
			pw.close();
			br.close();
			output.close();
			input.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
