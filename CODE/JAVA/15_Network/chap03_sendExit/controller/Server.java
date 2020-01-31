package com.kh.example.chap03_sendExit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public void startServer() {
		int port = 8500;
		try {
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("클라이언트의 요청을 기다림...");
			
			Socket client = server.accept();
			String clientIP = client.getInetAddress().getHostAddress();
			
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);
			
			String sendTxt = "";

			while(true) {

				String msg = br.readLine();
				if(!msg.equals("exit")) {
					System.out.println("받은 메시지 : "+msg);

					Scanner sc = new Scanner(System.in);
					System.out.print("보낼 메시지 : "); 
					sendTxt = sc.nextLine();
					pw.println(sendTxt);
					pw.flush();
				}
				else {
					System.out.println("접속 종료");
					break;
				}
			}	
			
			br.close();
			pw.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
