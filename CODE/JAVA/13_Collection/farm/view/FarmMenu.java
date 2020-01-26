package com.kh.practice.generics.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmMenu {
	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========= KH ��Ʈ =========\n");
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ���� �޴�");
			System.out.println("2. �մ� �޴�");
			System.out.println("9. ����\n");
			System.out.print("�޴� ��ȣ ���� : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: adminMenu(); break;
			case 2: customerMenu(); break;
			case 9: System.out.println("���α׷� ����"); return;
			default : System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.\n");
			}	
		}		
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. �� ��깰 �߰�");
			System.out.println("2. ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ��깰 ���");
			System.out.println("9. �������� ���ư���\n");
			System.out.print("�޴� ��ȣ ���� : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: addNewKind(); break;
			case 2: removeKind(); break;
			case 3: changeAmount(); break;
			case 4: printFarm(); break;
			case 9: return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}	
		}
	}
	
	public void customerMenu() {
		while(true) {
			System.out.println("���� KH��Ʈ ��깰 ����");
			printFarm();
			System.out.println();
			System.out.println("******* �� �޴� *******");
			System.out.println("1. ��깰 ���");
			System.out.println("2. ��깰 ����");
			System.out.println("3. ������ ��깰 ����");
			System.out.println("9. �������� ���ư���\n");
			System.out.print("�޴� ��ȣ ���� : ");
			int menuItem = Integer.parseInt(sc.nextLine());
			
			switch(menuItem) {
			case 1: buyFarm(); break;
			case 2: removeFarm(); break;
			case 3: printBuyFarm(); break;
			case 9: return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}	
		}
	}
	
	public void addNewKind() {
		while(true) {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("�߰��� ���� ��ȣ : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "����"; break;
			case 2: kind = "ä��"; break;
			case 3: kind = "�߰�"; break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			if(kind != null) {
				System.out.print("�̸� : ");
				String name = sc.nextLine();
				System.out.print("���� : ");
				int amount = Integer.parseInt(sc.nextLine());
				
				if(kind.equals("����")) {
					if(fc.addNewKind(new Fruit(kind,name), amount)== true) {
						System.out.println("�� ��깰�� �߰��Ǿ����ϴ�.");
						break;
					}
					else {
						System.out.println("�� ��깰 �߰��� �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("ä��")) {
					if(fc.addNewKind(new Vegetable(kind,name), amount)==true) {
						System.out.println("�� ��깰�� �߰��Ǿ����ϴ�.");
						break;
					}
					else {
						System.out.println("�� ��깰 �߰��� �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("�߰�")){
					if(fc.addNewKind(new Nut(kind,name), amount)==true) {
						System.out.println("�� ��깰�� �߰��Ǿ����ϴ�.");
						break;
					}
					else {
						System.out.println("�� ��깰 �߰��� �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
			}
		}
	}
	
	public void removeKind() {
		while(true) {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("������ ���� ��ȣ : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "����"; break;
			case 2: kind = "ä��"; break;
			case 3: kind = "�߰�"; break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			if(kind != null) {
				System.out.print("�̸� : ");
				String name = sc.nextLine();
				if(kind.equals("����")) {
					if(fc.removeKind(new Fruit(kind,name))== true) {
						System.out.println("��깰 ������ �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("��깰 ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("ä��")) {
					if(fc.removeKind(new Vegetable(kind,name))== true) {
						System.out.println("��깰 ������ �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("��깰 ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("�߰�")){
					if(fc.removeKind(new Nut(kind,name))== true) {
						System.out.println("��깰 ������ �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("��깰 ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
			}
		}
	}
	
	public void changeAmount() {
		while(true) {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("������ ���� ��ȣ : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "����"; break;
			case 2: kind = "ä��"; break;
			case 3: kind = "�߰�"; break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			if(kind != null) {
				System.out.print("�̸� : ");
				String name = sc.nextLine();
				System.out.print("������ ���� : ");
				int amount = Integer.parseInt(sc.nextLine());
				
				if(kind.equals("����")) {
					if(fc.changeAmount(new Fruit(kind,name), amount)== true) {
						System.out.println("��깰 ������ �����Ǿ����ϴ�.");
						break;
					}
					else {
						System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("ä��")) {
					if(fc.changeAmount(new Vegetable(kind,name),amount)== true) {
						System.out.println("��깰 ������ �����Ǿ����ϴ�.");
						break;
					}
					else {
						System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("�߰�")){
					if(fc.changeAmount(new Nut(kind,name),amount)== true) {
						System.out.println("��깰 ������ �����Ǿ����ϴ�.");
						break;
					}
					else {
						System.out.println("��깰 ���� ������ �����Ͽ����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
			}
		}
	}
	
	public void printFarm() {
		Map<Farm, Integer> map = new HashMap<Farm, Integer>();
		map = fc.printFarm();
		Set<Farm> set = new HashSet<Farm>();
		set = map.keySet();
		Iterator<Farm> it = set.iterator();
		while(it.hasNext()) {
			Farm f = it.next();
			if( f instanceof Fruit) {
				System.out.println(f.getKind()+" : "+((Fruit) f).getName()+"("+map.get(f)+"��)");
			}
			else if( f instanceof Vegetable) {
				System.out.println(f.getKind()+" : "+((Vegetable) f).getName()+"("+map.get(f)+"��)");
			}
			else if( f instanceof Nut) {
				System.out.println(f.getKind()+" : "+((Nut) f).getName()+"("+map.get(f)+"��)");
			}
		}
	}
	
	public void buyFarm() {
		while(true) {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("������ ���� ��ȣ : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "����"; break;
			case 2: kind = "ä��"; break;
			case 3: kind = "�߰�"; break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			if(kind != null) {
				System.out.print("������ �� : ");
				String name = sc.nextLine();
				
				if(kind.equals("����")) {
					if(fc.buyFarm(new Fruit(kind,name))== true) {
						System.out.println("���ſ� �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("��Ʈ�� ���� �����̰ų� ������ �����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("ä��")) {
					if(fc.buyFarm(new Vegetable(kind,name))== true) {
						System.out.println("���ſ� �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("��Ʈ�� ���� �����̰ų� ������ �����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("�߰�")){
					if(fc.buyFarm(new Nut(kind,name))== true) {
						System.out.println("���ſ� �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("��Ʈ�� ���� �����̰ų� ������ �����ϴ�. �ٽ� �Է����ּ���.");
					}
				}
			}
		}
	}
	
	public void removeFarm() {
		while(true) {
			System.out.println("1. ���� / 2. ä�� / 3. �߰�");
			System.out.print("������ ���� ��ȣ : ");
			int item = Integer.parseInt(sc.nextLine());
			String kind = null;
			switch(item) {
			case 1: kind = "����"; break;
			case 2: kind = "ä��"; break;
			case 3: kind = "�߰�"; break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			if(kind != null) {
				System.out.print("���� ����� �� : ");
				String name = sc.nextLine();
				
				if(kind.equals("����")) {
					if(fc.removeFarm(new Fruit(kind,name))== true) {
						System.out.println("���� ��ҿ� �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("���Ÿ� ��Ͽ� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("ä��")) {
					if(fc.removeFarm(new Vegetable(kind,name))== true) {
						System.out.println("���� ��ҿ� �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("���Ÿ� ��Ͽ� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
					}
				}
				else if(kind.equals("�߰�")){
					if(fc.removeFarm(new Nut(kind,name))== true) {
						System.out.println("���� ��ҿ� �����Ͽ����ϴ�.");
						break;
					}
					else {
						System.out.println("���Ÿ� ��Ͽ� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
					}
				}
			}
		}
	}
	
	public void printBuyFarm() {
		List<Farm> list = new ArrayList<Farm>();
		list = fc.printBuyFarm();
		Iterator<Farm> it = list.iterator();
		
		while(it.hasNext()) {
			Farm f = it.next();
			if( f instanceof Fruit) {
				System.out.println(f.getKind()+" : "+((Fruit) f).getName());
			}
			else if( f instanceof Vegetable) {
				System.out.println(f.getKind()+" : "+((Vegetable) f).getName());
			}
			else if( f instanceof Nut) {
				System.out.println(f.getKind()+" : "+((Nut) f).getName());
			}
		}
		
	}
}
