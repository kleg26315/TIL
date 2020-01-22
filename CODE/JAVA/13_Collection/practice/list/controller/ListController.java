package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public void doList() {
		List list1 = new ArrayList();
		// List is a raw type. References to generic type List<E> should be parameterized
		// ���׸��� ������
		
		List<Student> list = new ArrayList<Student>(3);	// �ʱ� ����뷮�� 10���� �ڵ� ����, ������ ������ ũ�⸸ŭ ����
		// add(E e) : ����Ʈ ���� ������ e �߰�
		list.add(new Student("�׽�Ʈ",0));
		list.add(new Student("�����",60));
		
		System.out.println("list : " + list);
		
		// �÷��� ���� 1. ũ���� ������ ����.
		list.add(new Student("������", 90));
		list.add(new Student("����ȣ", 85));
		
		System.out.println("���� list�� ��� element ���� : "+ list.size());
		System.out.println("list : " + list);

		// �÷��� ���� 2. �߰�/����/���� ���� ���ó�� ����
		// add(int index, E e) : index��° �ε����� e �߰�
		list.add(0, new Student("�����",100));
		System.out.println("list : " + list);
		
		list.add(3, new Student("���ǰ�",40));
		System.out.println("list : " + list);
		
		// remove(int index) : �ش� index��° ��ü ����
		list.remove(1);
		System.out.println("list : " + list);
	
		// remove(Object o) : �ش� Object��ü ����
		// Object Ŭ���� �ȿ��ִ� equals()�� hashcode()�� �Ѵ� �������̵��ؼ� �ּҰ��� 
		// ���ϴ� ���� �ƴ϶� �ȿ� �ִ� �ʵ尪���� ���ϰ� �� �������ؾ����� new��� �ص� ������ �����ϰ��Ѵ�.
		list.remove(new Student("���ǰ�",40));
		System.out.println("list : " + list);
		
		// ���� ��� 1. Collections Ŭ���� �̿�
		Collections.sort(list);			// �̸� �� ����
		System.out.println("list : " + list);
		
		// ���� ��� 2. List.sort()�޼ҵ� �̿�
		list.add(new Student("�ں���", 85));
		list.sort(new StudentComparator());
		System.out.println("list : " + list);
		
		// set(int index, E e) : index��° �ε����� �ִ� ��Ҹ� e�� ����
		list.set(2, new Student("�����", 31));
		System.out.println("list : " + list);
		
		// get(int index) : index��° �ε����� �ִ� ��Ҹ� ������ ��
		Student s = list.get(2);
		System.out.println(s);
		System.out.println("list : " + list);
		
		// subList(int index1, int index2) : index1��° �ε������� index2��° �ε������� ����Ʈ ��ȯ
		System.out.println("list ���� : "+ list.subList(2, 5));
		
		// contains(Object o) : o�� ����Ʈ�� �����Ѵٸ� true ��ȯ 
		// indexOf(Object o) : o�� ����Ʈ�� ��ġ�ϴ� �ε��� ��ȣ ��ȯ, ���ٸ� -1 ��ȯ
		System.out.println("������, 90�� �ִ°�? "+ list.contains(new Student("������",90)));
		System.out.println("������, 90�� �ε��� ��ġ��? "+ list.indexOf(new Student("������",90)));
		System.out.println("�׽�Ʈ, 0�� �ε��� ��ġ��? "+ list.indexOf(new Student("�׽�Ʈ",0)));
		
		// clear() : ����� ��� ��ü ����
		// isEmpty() : ����Ʈ�� ����� �� true ��ȯ
		list.clear();
		System.out.println("list : "+ list);
		System.out.println("list�� �������? "+ list.isEmpty());
		
	}
}