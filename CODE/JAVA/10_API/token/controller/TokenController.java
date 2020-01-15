package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {}
	
	public String afterToken(String str) {
		String afterToken = "";
		StringTokenizer st = new StringTokenizer(str, " ");
		
		while(st.hasMoreTokens()) {
			afterToken += st.nextToken();
		}
		return afterToken;
	}
	
	public String firstCap(String input) {
		String firstCap = String.valueOf(input.toUpperCase().charAt(0)).concat(input.substring(1));
	
		return firstCap;
	}
	
	public int findChar(String input, char one) {
		int cnt = 0;
		for(int i =0; i<input.length(); i++) {
			if(input.charAt(i)== one)
				cnt++;
		}

		return cnt;
	}
}
