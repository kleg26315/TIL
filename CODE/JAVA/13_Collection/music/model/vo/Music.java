package com.kh.practice.list.music.model.vo;

public class Music implements Comparable<Music>{
	private String title;
	private String singer;
	
	public Music() {}
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return singer +" - "+ title;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ( (singer == null) ? 0 : singer.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Music other = (Music)obj;
		if(title == null) {
			if(other.title != null) {
				return false;
			}
		} else if(!title.equals(other.title)) {
			return false;
		}
		
		if(singer == null) {
			if(other.singer != null) {
				return false;
			}
		} else if(!singer.equals(other.singer)) {
			return false;
		}
		
		return true;
	}
	@Override
	public int compareTo(Music o) {
		String objectSinger = o.getSinger();
		return -singer.compareTo(objectSinger);
	}
	
	
}
