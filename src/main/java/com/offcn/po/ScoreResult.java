package com.offcn.po;

public class ScoreResult {
	private String name;
	private double value;
	public ScoreResult() {
		super();
	}
	public ScoreResult(String name, double value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "valueResult [name=" + name + ", value=" + value + "]";
	}
	
	
	
	
	
	
	
}
