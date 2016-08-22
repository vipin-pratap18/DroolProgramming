package com.sample.model;

public class DecisionString {

	private int less;
	private int lessValue;
	private int greater;
	private int greaterValue;
	private int returnAge;
	private int clientAge;
	
	public DecisionString(int less, int lessValue, int greater, int greaterValue, int clientAge){
		this.less = less;
		this.lessValue  = lessValue;
		this.greater = greater;
		this.greaterValue = greaterValue;
		this.clientAge = clientAge;
	}
	
	public int getLess() {
		return less;
	}
	public void setLess(int less) {
		this.less = less;
	}
	public int getLessValue() {
		return lessValue;
	}
	public void setLessValue(int lessValue) {
		this.lessValue = lessValue;
	}
	public int getGreater() {
		return greater;
	}
	public void setGreater(int greater) {
		this.greater = greater;
	}
	public int getGreaterValue() {
		return greaterValue;
	}
	public void setGreaterValue(int greaterValue) {
		this.greaterValue = greaterValue;
	}
	public int getReturnAge() {
		return returnAge;
	}
	public void setReturnAge(int returnAge) {
		this.returnAge = returnAge;
	}
	public int getClientAge() {
		return clientAge;
	}
	public void setClientAge(int clientAge) {
		this.clientAge = clientAge;
	}
	
}
