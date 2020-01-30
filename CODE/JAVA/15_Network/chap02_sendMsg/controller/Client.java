package com.kh.example.chap02_sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	// Ŭ���̾�Ʈ �� TCP ���� ���α׷��� ����
	// 1) ������ IP�ּҿ� ��Ʈ��ȣ�� �Ű������� �Ͽ� Ŭ���̾�Ʈ�� ���� ��ü ����
	// 2) ����� ��Ʈ�� ����
	// 3) ������Ʈ���� ���� ���� ����
	// 4) ��Ʈ���� ���� �а� ����
	// 5) ��� ����
	
	public void clientStart() {
		try {
			// 1) ������ IP�ּҿ� ��Ʈ��ȣ�� �Ű������� �Ͽ� Ŭ���̾�Ʈ�� ���� ��ü ����
			int port = 8500;
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(serverIP, port); // ���� ������ ��� null ��ȯ
			
			if(socket != null) {	// ���� ���� ��
				// 2) ����� ��Ʈ�� ����
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				
				// 3) ������Ʈ���� ���� ���� ����
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				PrintWriter pw = new PrintWriter(output);
				
				// 4) ��Ʈ���� ���� �а� ����
				pw.println("�ݰ�����");
				pw.flush();
				System.out.println(br.readLine());
				
				// 5) ��� ����
				pw.close();
				br.close();
				socket.close();
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
