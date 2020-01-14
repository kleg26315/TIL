package com.kh.practice.leap.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LeapController {
	public boolean isLeapYear(int year) {
		boolean check = true;
		
		if(year%4==0 && (year%100!=0||year%400==0)) {
			check = true;
		}
		else {
			check = false;
		}
		
		return check;
	}
	
	public long leapDate(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		int firstYear = 1;
		long cntDay = 0;
		
		while(firstYear < year)
		{
			if(firstYear%4==0 && (firstYear%100!=0||firstYear%400==0)) {
				cntDay += 366;
			}
			else {
				cntDay += 365;
			}
			firstYear++;
		}
		
		for(int i=1; i<month; i++) {
			switch(month) {
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				cntDay += 31;
				break;		
			case 4:case 6:case 9:case 11:
				cntDay += 30;
				break;
			case 2:
				if(year%4==0 && (year%100!=0||year%400==0)) {
					cntDay += 29;
				}
				else {
					cntDay += 28;
				}
				break;
			}
		}
		
		for(int i=1; i<=date; i++) {
			cntDay +=1;
		}
		
		return cntDay;
	}
}
