package com.kh.practice.leap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.kh.practice.leap.controller.LeapController;

public class LeapView {
	public LeapView() {
		LeapController lc = new LeapController();
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		String str = "";
		
		if(lc.isLeapYear(year)==true)
			str = "윤년";
		else 
			str = "평년";
		
		System.out.println(year+"년은 "+str+"입니다.");
		System.out.println("총 날짜 수 : "+lc.leapDate(c));
	}
	
}
