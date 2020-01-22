package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<Lottery>();
	private HashSet<Lottery> win = new HashSet<Lottery>();
	
	public boolean insertObject(Lottery l) {
		if(lottery.add(l)==true) {
			return true;	
		}
		else {
			return false;
		}
	}
	
	public boolean deleteObject(Lottery l) {
		if(lottery.remove(l) == true) {
			if(win.contains(l)==true) {
				win.remove(l);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public HashSet winObject() {
		ArrayList<Lottery> list = new ArrayList<Lottery>();
		list.addAll(lottery);
		int winSize = win.size();
		
		if(winSize != 4) {
			if(list.size() >=4) {
				for(int i=0; i<4-winSize; i++) {
					int random = (int)(Math.random() * list.size());
					if(win.contains(list.get(random))) {
						i--;
					}
					else {
						win.add(list.get(random));	
					}
				}
			}	
		}	
		return win;
	}
	
	public TreeSet sortedWinObject() {
		TreeSet<Lottery> set = new TreeSet<Lottery>(new SortedLottery());
		set.addAll(win);
		return set;
	}
	
	public boolean searchWinner(Lottery l) {
		if(win.contains(l)==true) {
			return true;
		}
		else {
			return false;
		}
	}
}
