package com.kh.practice.map.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<String, Member>();
	
	public boolean joinMembership(String id, Member m) {
		if(map.containsKey(id) == true) {	// containsKey 메소드를 굳이 반복해서 검사할 필요가 없음
			return false;
		}
		map.put(id, m);
		return true;
	}
	
	public String logIn(String id, String password) {
		Set<Entry<String,Member>> set = new HashSet<Entry<String,Member>>();
		set = map.entrySet();
		Iterator<Entry<String,Member>> it = set.iterator();
		
		while(it.hasNext()) {
			Entry<String,Member> entry = it.next();
			if(entry.getKey().equals(id)) {
				if(entry.getValue().getPassword().equals(password)) {
					return entry.getValue().getName();
				}
			}
		}
		
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		Set<Entry<String,Member>> set = new HashSet<Entry<String,Member>>();
		set = map.entrySet();
		Iterator<Entry<String,Member>> it = set.iterator();
		
		while(it.hasNext()) {
			Entry<String,Member> entry = it.next();
			if(entry.getKey().equals(id)) {
				if(entry.getValue().getPassword().equals(oldPw)) {
					map.put(id, new Member(newPw, entry.getValue().getName()));
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void changeName(String id, String newName) {
		Set<Entry<String,Member>> set = new HashSet<Entry<String,Member>>();
		set = map.entrySet();
		Iterator<Entry<String,Member>> it = set.iterator();
		
		while(it.hasNext()) {
			Entry<String,Member> entry = it.next();
			if(entry.getKey().equals(id)) {
				map.put(id, new Member(entry.getValue().getPassword(), newName));				
			}
		}
	}
	
	public TreeMap sameName(String name) {
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		Set<String> set = new HashSet<String>();
		set = map.keySet();
		List<String> list = new ArrayList<String>();
		list.addAll(set);
		for(int i=0; i<list.size(); i++) {
			if(map.get(list.get(i)).getName().equals(name)) {
				treeMap.put(list.get(i),name);
			}
		}
		
		return treeMap;
	}
	
}
