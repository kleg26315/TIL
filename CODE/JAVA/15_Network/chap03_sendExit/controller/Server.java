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
			
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ�...");
			
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
					System.out.println("���� �޽��� : "+msg);

					Scanner sc = new Scanner(System.in);
					System.out.print("���� �޽��� : "); 
					sendTxt = sc.nextLine();
					pw.println(sendTxt);
					pw.flush();
				}
				else {
					System.out.println("���� ����");
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
