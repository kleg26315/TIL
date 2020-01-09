package com.kh.example.animal.controller;

import com.kh.example.animal.model.vo.Animal;
import com.kh.example.animal.model.vo.Dog;
import com.kh.example.animal.model.vo.Snake;

public class AnimalController {
	public void method() {
		Animal a = new Animal("강아지",9,6.3);
		System.out.println(a);
		Dog d = new Dog("태양이",8,4.5,40,"장모");
		System.out.println(d);
		
		Snake s = new Snake("방울", 4, 10.2, "빗살");
		System.out.println(s);
		
	}
}
