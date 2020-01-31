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
		// ���� ��Ʈ ���ϱ�
		// ������ ���� ��ü ����
		// Ŭ���̾�Ʈ ��û ��ٸ�
		// ��û ���� �� Ŭ���̾�Ʈ ���� ��ü ����
		// ����� ��Ʈ�� ����
		// ������Ʈ��
		// �а���
		// ����
		try {
			int port = 8500;
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ�����...");
			
			Socket client = server.accept();
			
			InputStream input = client.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(input);

			Person message = null;
			while(true) {
				message = (Person) ois.readObject();
				
				if(message != null) {
					System.out.println(client.getInetAddress().getHostAddress() +"�� ���� �޽��� : "+ message);
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
