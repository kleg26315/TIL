package practice3.controller;

import practice3.model.vo.Animal;
import practice3.model.vo.Cat;
import practice3.model.vo.Dog;

public class AnimalManager {
	public static void main(String[] args) {
		Animal[] a = new Animal[5];
		a[0] = new Dog("두부","말티즈",4);
		a[1] = new Cat("망고","먼치킨","서울","흰색");
		a[2] = new Cat("알리","스핑크스","인도","살색");
		a[3] = new Dog("홍시","포메라니안",3);
		a[4] = new Dog("만두","푸들",4);
		
		for(int i =0; i<a.length; i++) {
			if( a[i] instanceof Dog) {
				((Dog)a[i]).speak();
			} else if( a[i] instanceof Cat) {
				((Cat)a[i]).speak();
			}
		}
	}
}
