package com.offcn.po;

public class NewStudent {
	private int id;
	private String name;
	private double score;
	private String phone;
	
	
	
	
	
	
	public NewStudent() {
		super();
	}
	
	
	
	
	
	
	
	
	
	public NewStudent(int id, String name, double score, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.phone = phone;
	}









	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}









	@Override
	public String toString() {
		return "NewStudent [id=" + id + ", name=" + name + ", score=" + score + ", phone=" + phone + "]";
	}
	
	
	
	
	
	
}
