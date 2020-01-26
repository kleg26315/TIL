package com.kh.practice.generics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmController {
	private HashMap<Farm, Integer> hMap = new HashMap<>();
	private ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, int amount) {
		Set<Farm> set = new HashSet<Farm>();
		set = hMap.keySet();
		Iterator<Farm> it = set.iterator();
		
		while(it.hasNext()) {
			Farm farm = it.next();
			if(farm.equals(f)) {
				return false;
			}
		}
		
		hMap.put(f, amount);
		return true;
	}
	
	public boolean removeKind(Farm f) {
		Set<Farm> set = new HashSet<Farm>();
		set = hMap.keySet();
		Iterator<Farm> it = set.iterator();
		
		while(it.hasNext()) {
			Farm farm = it.next();
			if(farm.equals(f)) {
				hMap.remove(f);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean changeAmount(Farm f, int amount) {
		Set<Farm> set = new HashSet<Farm>();
		set = hMap.keySet();
		Iterator<Farm> it = set.iterator();
		
		while(it.hasNext()) {
			Farm farm = it.next();
			if(farm.equals(f)) {
				hMap.put(f, amount);
				return true;
			}
		}
		
		return false;
	}
	
	public HashMap<Farm, Integer> printFarm(){
		return hMap;
	}
	
	public boolean buyFarm(Farm f) {
		Set<Farm> set = new HashSet<Farm>();
		set = hMap.keySet();
		Iterator<Farm> it = set.iterator();
		
		while(it.hasNext()) {
			Farm farm = it.next();
			if(farm.equals(f)) {
				if(hMap.get(farm)>=0) {
					list.add(f);
					hMap.put(f, hMap.get(farm)-1);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean removeFarm(Farm f) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(f)) {
				hMap.put(f, hMap.get(list.get(i))+1);
				list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Farm> printBuyFarm() {
		return list;
	}
	
}
