package com.kh.practice.generics.model.vo;

public class Nut extends Farm {
	private String name;
	
	public Nut() {}
	public Nut(String kind, String name) {
		super(kind);
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return super.toString()+" : "+name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime*result +((name == null ? 0 : name.hashCode()));
		result = prime*result + ((super.getKind() == null ? 0 : super.getKind().hashCode()));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		
		Nut f = (Nut)obj;
		if(name==null) {
			if(f.name !=null) {
				return false;
			}
		}
		else if(!name.equals(f.name)) {
			return false;
		}
		
		if(super.getKind()==null) {
			if(f.getKind() != null) {
				return false;
			}
		}
		else if(super.getKind().equals(f.getKind())) {
			return false;
		}
		
		return true;
	}
}
