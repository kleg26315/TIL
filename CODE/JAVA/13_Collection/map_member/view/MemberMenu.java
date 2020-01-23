package com.kh.practice.map.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========= KH ����Ʈ =========\n");
		
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("3. ���� �̸� ȸ�� ã��");
			System.out.println("9. ����\n");
			System.out.print("�޴� ��ȣ ���� : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: joinMembership(); break;
			case 2: logIn(); memberMenu(); break;
			case 3: sameName(); break;
			case 9: System.out.println("���α׷� ����"); return;
			default: System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.\n");
			}	
		}
		
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("******* ȸ�� �޴� *******");
			System.out.println("1. ��й�ȣ �ٲٱ�");
			System.out.println("2. �̸� �ٲٱ�");
			System.out.println("3. �α׾ƿ�\n");
			System.out.print("�޴� ��ȣ ���� : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: changePasswrod(); break;
			case 2: changeName(); break;
			case 3: System.out.println("�α׾ƿ� �Ǿ����ϴ�.\n"); return;
			default: System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.\n");
			}	
		}
	}
	
	public void joinMembership() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			
			if(mc.joinMembership(id, new Member(password, name))==true) {
				System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�.");
				break;
			}
			else {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			}	
		}
	}
	
	public void logIn() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			String check = mc.logIn(id, password);
			if(check==null){
				System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			}
			else {
				System.out.println(check+"��, ȯ���մϴ�!");
				break;
			}
		}
	}
	
	public void changePasswrod() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("���� ��й�ȣ : ");
			String oldPw = sc.nextLine();
			System.out.print("���ο� ��й�ȣ : ");
			String newPw = sc.nextLine();
			if(mc.changePassword(id, oldPw, newPw)==true) {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�.");
				break;
			}
			else {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			}			
		}
	}
	
	public void changeName() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			String originName = mc.logIn(id, password);
			if(originName==null) {
				System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���");
			}
			else {
				System.out.println("���� ������ �̸� : "+originName);
				System.out.print("������ �̸� : ");
				String newName = sc.nextLine();
				mc.changeName(id, newName);
				System.out.println("�̸� ���濡 �����Ͽ����ϴ�.");
				break;
			}
			
		}		
	}
	
	public void sameName() {
		System.out.print("�˻��� �̸� : ");
		String searchName = sc.nextLine();
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap = mc.sameName(searchName);
		if(treeMap.isEmpty()==true) {
			System.out.println(searchName+"�԰� ���� �̸��� ȸ���� �������� �ʽ��ϴ�.");
		}
		else {
			Set<Entry<String,String>> set = new HashSet<Entry<String,String>>();
			set = treeMap.entrySet();
			Iterator<Entry<String,String>> it = set.iterator();
			
			while(it.hasNext()) {
				Entry<String,String> entry = it.next();
				System.out.println(entry.getValue()+"-"+entry.getKey());
			}
		}
			
	}
	
}
