package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
		int[] array = new int[10];
		for(int i=0; i<10; i++) {
			array[i]=i+1;
		}
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public void practice2() {
		int[] array = new int[10];
		for(int i=0; i<10; i++) {
			array[i]=10-i;
		}
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();
		int[] array = new int[num];
		
		for(int i=0; i<num; i++) {
			array[i] = i+1;
		}
		
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public void practice4() {
		String[] strArr = {"사과","귤","포도","복숭아","참외"};
		System.out.println(strArr[1]);
		System.out.println();
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		char[] strArr = new char[str.length()];
		for(int i=0; i<str.length(); i++) {
			strArr[i]=str.charAt(i);
		}
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		int count =0;
		System.out.print(str+"에 "+ch+"가 존재하는 위치(인덱스) : ");
		for(int i=0; i<str.length(); i++) {
			if(strArr[i]==ch) {
				System.out.print((i)+" ");
				count++;
			}
		}
		System.out.println();
		System.out.print(ch+" 개수 : "+count);
		System.out.println();
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		String[] strArr = {"월","화","수","목","금","토","일"};
		
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num>=0 && num<=6) {
			System.out.println(strArr[num]);
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
		}		
		System.out.println();
	}
	
	public void practice7() {
		Scanner sc =new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[] numArr = new int[num];
		
		for(int i=0; i<num; i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값 : ");
			numArr[i]= sc.nextInt();
		}
		int sum =0;
		for(int i=0; i<numArr.length; i++) {
			System.out.print(numArr[i]+" ");
			sum += numArr[i];
		}
		
		System.out.print("총 합 : "+sum);
		System.out.println();
	}
	
	public void practice8() {
		Scanner sc =new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		if(num%2==1) {
			int[] numArr = new int[num];
			for(int i=0; i<num; i++) {
				if(i<num/2+1) {
					numArr[i] = i+1;
				}
				else {
					numArr[i] = (num)-i; 
				}
			}
			for(int i=0; i<numArr.length; i++) {
				if(i!=numArr.length-1) {
					System.out.print(numArr[i]+", ");
				}
				else {
					System.out.println(numArr[i]);
				}
			}
		}
		else {
			System.out.println("다시 입력하세요.");
			practice8();
		}
		System.out.println();
	}
	
	public void practice9() {
		Scanner sc =new Scanner(System.in);
		String[] strArr = {"양념","순살","불닭","후라이드","간장"};
		System.out.print("치킨 이름을 입력하세요 : ");
		String str = sc.nextLine();
		int flag = 1;
		for(int i=0; i<strArr.length; i++) {
			if(str.equals(strArr[i])) {
				System.out.println(str+"치킨 배달 가능");
				flag =0;
			}
		}
		
		if(flag==1) {
			System.out.println(str+"치킨은 없는 메뉴입니다.");
		}
		System.out.println();
	}
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String jumin = sc.nextLine();
		char[] jumin2 = new char[jumin.length()];
		for(int i =0; i<jumin.length(); i++) {
			jumin2[i] = jumin.charAt(i);
		}
		
		for(int i=0; i<jumin2.length; i++) {
			if(i<=7) {
				System.out.print(jumin2[i]);
			}
			else {
				System.out.print("*");
			}
		}
		System.out.println();
	}
	
	public void practice11() {
		int[] numArr = new int[10];
		
		for(int i =0; i<numArr.length; i++) {
			int random = (int)(Math.random()*10 +1);	
			numArr[i] = random;
			System.out.print(numArr[i]+" ");
		}
		System.out.println();
	}
	
	public void practice12() {
		int[] numArr = new int[10];
		
		for(int i =0; i<numArr.length; i++) {
			int random = (int)(Math.random()*10 +1);	
			numArr[i] = random;
			System.out.print(numArr[i]+" ");
		}
		int max =numArr[0];
		int min =numArr[0];
		
		for(int i=1; i<numArr.length; i++) {
			if(numArr[i]>max) {
				max = numArr[i];
			}
		}
		for(int i=1; i<numArr.length; i++) {
			if(numArr[i]<min) {
				min = numArr[i];
			}
		}
		
		System.out.print("최대값 : "+max);
		System.out.print("최소값 : "+min);
		System.out.println();
	}
	
	public void practice13() {
		int[] numArr = new int[10];
		int[] randomArr = new int[10];
		
		for(int i=0; i<randomArr.length; i++) {
			randomArr[i] = (int)(Math.random() *10+1);
			for(int j=0; j<i; j++) {
				if(randomArr[i]==randomArr[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i=0; i<randomArr.length; i++) {
			numArr[i] = randomArr[i];
			System.out.print(numArr[i]+" ");
		}
		System.out.println();
	}
	
	public void practice14() {
		int[] randomArr = new int[6];
		
		for(int i=0; i<randomArr.length; i++) {
			randomArr[i] = (int)(Math.random() *50+1);
			for(int j=0; j<i; j++) {
				if(randomArr[i]==randomArr[j]) {
					i--;
					break;
				}
			}
		}
		
		
		Arrays.sort(randomArr);
		for(int i=0; i<randomArr.length; i++) {
			System.out.print(randomArr[i]+" ");
		}
		System.out.println();
	}
	public void practice15() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		int count =0;
		int flag = 1;
		char[] ch = new char[str.length()];
		char[] ch2 = new char[str.length()];
		for(int i =0; i<str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		for(int i =0; i<ch.length; i++) {
			flag = 1;
			for(int j=0; j<i; j++) {
				if(ch[i]==ch[j]) {
					flag = 0;
					break;
				}
				else {
					flag =1;
				}
			}
			if(flag==1) {
				ch2[count] = ch[i];
				count++;
				
			}
		}
		
		for(int i=0; i<count; i++) {
			if(i!=count-1) {
				System.out.print(ch2[i]+", ");				
			}
			else {
				System.out.println(ch2[i]);
			}
		}
		System.out.print("문자 개수 : "+ count);
		System.out.println();
	}
	
	public void practice16() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int arraySize = Integer.parseInt(sc.nextLine());
		String[] strArr = new String[arraySize];
		String[] strArr2 = new String[arraySize];
		strArr2 = Arrays.copyOf(strArr, strArr.length);
		int plus = 0;
		int beforeArraySize =arraySize;
		
		for(int i=0; i<arraySize; i++) {
			System.out.print((i+1)+"번째 문자열 : ");
			strArr[i] = sc.nextLine();
		}
		
		while(true) {
			System.out.print("더 값을 입력하시겠습니가?(Y/N) : ");
			char isCheck = sc.nextLine().charAt(0);
			
			if(isCheck=='y'||isCheck=='Y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				plus =Integer.parseInt(sc.nextLine());
				arraySize += plus;
				strArr2 =new String[beforeArraySize];
				strArr2 = Arrays.copyOf(strArr, strArr.length);
				strArr = new String[arraySize];
				
				for(int i =1; i<=plus; i++) {
					System.out.print((beforeArraySize+i)+"번째 문자열 : ");
					strArr[beforeArraySize+i-1] = sc.nextLine();
				}
				beforeArraySize += plus;
				
				System.arraycopy(strArr2, 0, strArr, 0, strArr2.length);
			}
			else if(isCheck=='n'||isCheck=='N') {
				System.out.print("[");
				for(int i=0; i<strArr.length; i++) {
					if(i!=strArr.length-1) {
						System.out.print(strArr[i]+", ");
					}
					else {
						System.out.print(strArr[i]+"]");
					}			
				}
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}		
		System.out.println();
	}
}
