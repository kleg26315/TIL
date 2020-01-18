package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator<Music> {
	@Override
	public int compare(Music o1, Music o2) {
		String standard = o1.getTitle();
		String object = o2.getTitle();
		
		String standardSinger = o1.getSinger();
		String objectSinger = o2.getSinger();
		
		if( standard == object) {
			return standardSinger.compareTo(objectSinger);
		}
		else {
			return standard.compareTo(object);
		}
	}
}
