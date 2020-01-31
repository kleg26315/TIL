package com.kh.example.chap03_sendExit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public void startClient() {
		try {
			int port = 8500;
			String serverIP;
			serverIP = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) {
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);
				
				
				Scanner sc = new Scanner(System.in);
				
				while(true) {
					System.out.print("보낼 메시지 : ");
					String msg = sc.nextLine();
					
					pw.println(msg);
					pw.flush();
					
					if(msg.equals("exit")) {
						System.out.println("접속 종료");
						break;
					}
											
					System.out.println("받은 메시지 : " + br.readLine());
						
				}
				br.close();
				pw.close();
				socket.close();
				
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
