package kh.controller;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import kh.model.vo.Book;

public class ClientController {
	public void fileUpload() {
		int port = 3000;
		String serverIP = "192.168.20.34";
		
		try {
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) {
				InputStream input = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(input));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"));
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				
				try {
					while(true) {
						Book b = (Book) ois.readObject();
						oos.writeObject(b);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					oos.writeObject(null);
					oos.flush();
				}
					
				if(br.readLine().equals("exit")) {
					oos.close();
					ois.close();
					br.close();
					socket.close();
				}
				
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
