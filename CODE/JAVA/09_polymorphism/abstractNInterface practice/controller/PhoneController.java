package com.kh.practice.chap02_abstractNInterface.controller;

import com.kh.practice.chap02_abstractNInterface.model.vo.GalaxyNote9;
import com.kh.practice.chap02_abstractNInterface.model.vo.Phone;
import com.kh.practice.chap02_abstractNInterface.model.vo.V40;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		String[] s = new String[2];
		Phone[] p = new Phone[2];
		p[0] = new GalaxyNote9();
		p[1] = new V40();
		
		for(int i=0; i<p.length; i++) {
			if(p[i] instanceof GalaxyNote9)
				s[i] = ((GalaxyNote9)p[i]).printInformation();
			else if(p[i] instanceof V40)
				s[i] = ((V40)p[i]).printInformation();
		}
		
		return s;
	}
}
