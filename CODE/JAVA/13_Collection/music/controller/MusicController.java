package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<Music>();
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	
	public List printAll() {
		
		return list;
		
	}
	
	public Music searchMusic(String title) {
		Music m = new Music();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				m = list.get(i);
				break;
			}
		}
		
		return m; 
	}
	
	public Music removeMusic(String title) {
		Music m = new Music();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				m = list.get(i);
				list.remove(i);
				break;
			}
		}
		
		return m;
	}
	
	public Music setMusic(String title, Music music) {
		Music m = new Music();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				m = list.get(i);
				list.remove(i);
				list.add(i, music);
				break;
			}
		}
		
		return m;
	}
	
	public int ascTitle() {
		list.sort(new AscTitle());
		
		return 1;
	}
	
	public int descSinger() {
		Collections.sort(list);
		return 1;
	}
}
