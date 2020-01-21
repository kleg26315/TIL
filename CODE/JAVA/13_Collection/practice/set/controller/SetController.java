package com.kh.example.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.kh.example.set.model.compare.DogComparator;
import com.kh.example.set.model.vo.Dog;

public class SetController {
	public void doSet() {
		Set<Dog> set = new HashSet<Dog>();
		
		set.add(new Dog("샤샤", 4.0));
		set.add(new Dog("호두", 3.5));
		set.add(new Dog("우유", 8.1));
		System.out.println(set);
		
		set.add(new Dog("샤샤", 4.0));
		System.out.println(set);
		
		Set<Dog> set2 = new LinkedHashSet<Dog>();
		
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		set2.add(new Dog("초코", 2.1));
		System.out.println(set2);	// 순서는 유지되고 중복 저장은 안되는 LinkedHashSet
		
		set2.add(new Dog("로이", 6.1));
		set2.add(new Dog("공주", 5.2));
		set2.add(new Dog("왕자", 9.5));
		set2.add(new Dog("조이", 12.5));
		System.out.println(set2);
		
		
		Set<Dog> set3 = new TreeSet<Dog>(set2);
		System.out.println(set3);

		Set<Dog> set4 = new TreeSet<Dog>(new DogComparator());
		set4.add(new Dog("초코", 6.1));
		set4.add(new Dog("콩이", 8.3));
		set4.add(new Dog("두부", 5.0));
		set4.add(new Dog("초코", 2.1));
		set4.add(new Dog("로이", 6.1));
		set4.add(new Dog("공주", 5.2));
		set4.add(new Dog("왕자", 9.5));
		set4.add(new Dog("조이", 12.5));
		System.out.println(set4);
		
		// 요소 뽑아내기
		// 방법 1. Set을 List화 시키기
		List<Dog> list = new ArrayList<Dog>();
		list.addAll(set4);
		System.out.println(list);
		System.out.println(list.get(3));
		
		// 방법 2. Iterator 활용하기 : iterator()
		Iterator<Dog> it = set4.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		while(it.hasNext()) {		// 1회성, 단방향이기 때문에 아무 출력이 없음
			System.out.println("re : "+it.next());
		}
		
		
	}
}
