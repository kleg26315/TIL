package com.kh.example.chap01_inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetExample {
	// InetAddress : IP주소를 다루기 위해 자바에서 제공하는 클래스
	public static void main(String[] args) {
		try {
			// static InetAddress getLocalHost() : 지역 호스트(네트워크에 연결되어 있는 컴퓨터)의 Host명과 IP주소 반환
			InetAddress localIP = InetAddress.getLocalHost();
			
			// String getHostName() : 호스트 이름 반환
			System.out.println("내 PC 명 : " + localIP.getHostName());
			
			// String getHostAddress() : 호스트의 IP주소 반환
			System.out.println("내 IP : " + localIP.getHostAddress());
			
			// byte[] getAddress() : IP주소를 byte배열로 반환
			byte[] ipAddress = localIP.getAddress();
			System.out.println(Arrays.toString(ipAddress));
			
			// static InetAddress getByName(String host) : 도메인 명(host)을 통해 IP주소 얻음
			InetAddress naverIP = InetAddress.getByName("www.naver.com");
			System.out.println("naver 서버 명 : " + naverIP.getHostName());
			System.out.println("naver 서버 ip : " + naverIP.getHostAddress());
			
			InetAddress[] googleIPs = InetAddress.getAllByName("www.google.com");
			System.out.println("구글 IP 개수 : "+ googleIPs.length);
			for(InetAddress ip : googleIPs) {
				System.out.println(ip.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
