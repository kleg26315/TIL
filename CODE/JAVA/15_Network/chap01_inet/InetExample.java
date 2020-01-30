package com.kh.example.chap01_inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetExample {
	// InetAddress : IP�ּҸ� �ٷ�� ���� �ڹٿ��� �����ϴ� Ŭ����
	public static void main(String[] args) {
		try {
			// static InetAddress getLocalHost() : ���� ȣ��Ʈ(��Ʈ��ũ�� ����Ǿ� �ִ� ��ǻ��)�� Host��� IP�ּ� ��ȯ
			InetAddress localIP = InetAddress.getLocalHost();
			
			// String getHostName() : ȣ��Ʈ �̸� ��ȯ
			System.out.println("�� PC �� : " + localIP.getHostName());
			
			// String getHostAddress() : ȣ��Ʈ�� IP�ּ� ��ȯ
			System.out.println("�� IP : " + localIP.getHostAddress());
			
			// byte[] getAddress() : IP�ּҸ� byte�迭�� ��ȯ
			byte[] ipAddress = localIP.getAddress();
			System.out.println(Arrays.toString(ipAddress));
			
			// static InetAddress getByName(String host) : ������ ��(host)�� ���� IP�ּ� ����
			InetAddress naverIP = InetAddress.getByName("www.naver.com");
			System.out.println("naver ���� �� : " + naverIP.getHostName());
			System.out.println("naver ���� ip : " + naverIP.getHostAddress());
			
			InetAddress[] googleIPs = InetAddress.getAllByName("www.google.com");
			System.out.println("���� IP ���� : "+ googleIPs.length);
			for(InetAddress ip : googleIPs) {
				System.out.println(ip.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
