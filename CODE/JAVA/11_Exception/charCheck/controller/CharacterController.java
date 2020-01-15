package com.kh.practice.charCheck.controller;

import java.util.StringTokenizer;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {
	public CharacterController() {}
	
	public int countAlpha(String s) throws CharCheckException {
		StringTokenizer st = new StringTokenizer(s, " ");
		int cnt = 0;
		
		if(st.countTokens()>1) {
			throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
		}
		else {
			for(int i =0; i<s.length(); i++) {
				if(s.charAt(i)>'A' && s.charAt(i)<'z' && !(s.charAt(i)>90&&s.charAt(i)<97))
					cnt++;
			}
		}
		
		return cnt;
	}
}
