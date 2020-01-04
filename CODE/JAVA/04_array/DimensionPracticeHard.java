package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPracticeHard {
	public void practice10() {
		String[][] arr = new String[6][6];
		
		for(int i=0; i<arr.length; i++) {	// 모든 배열인덱스에 " " 값 대입 (초기화)
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] =" ";
			}
		}
		for(int i=1; i<arr.length; i++) {	// 맨 위 행에 값 대입
			arr[0][i] = Integer.toString(i-1);
		}
		for(int i=1; i<arr.length; i++) {	// 맨 앞 열에 값 대입
			arr[i][0] = Integer.toString(i-1);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력 : ");
		int row = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int col = sc.nextInt();
		
		arr[row+1][col+1] = "X";
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void practice11() {
		String[][] arr = new String[6][6];
		
		for(int i=0; i<arr.length; i++) {	// 모든 배열인덱스에 " " 값 대입 (초기화)
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] =" ";
			}
		}
		for(int i=1; i<arr.length; i++) {	// 맨 위 행에 값 대입
			arr[0][i] = Integer.toString(i-1);
		}
		for(int i=1; i<arr.length; i++) {	// 맨 앞 열에 값 대입
			arr[i][0] = Integer.toString(i-1);
		}
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("행 인덱스 입력 : ");
			int row = sc.nextInt();
			if(row==99) {
				System.out.println("\n 프로그램 종료");
				break;
			}
			else {
				System.out.print("열 인덱스 입력 : ");
				int col = sc.nextInt();
				
				arr[row+1][col+1] = "X";
				
				for(int i=0; i<arr.length; i++) {
					for(int j=0; j<arr[i].length; j++) {
						System.out.print(arr[i][j]+" ");
					}
					System.out.println();
				}
			}
		}

	}
}
