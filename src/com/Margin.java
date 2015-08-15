package com;

public class Margin {
	private double left;
	private double top;
	private double right; //acount with orientation
	private double bottom;	//acount with orientation
	public double getLeft() {
		return left;
	}
	public void setLeft(double left) {
		this.left = left;
	}
	public double getTop() {
		return top;
	}
	public void setTop(double top) {
		this.top = top;
	}
	public double getRight() {
		return right;
	}
	public void setRight(double right) {
		this.right = right;
	}
	public double getBottom() {
		return bottom;
	}
	public void setBottom(double bottom) {
		this.bottom = bottom;
	}
	public Margin(double left, double top, double right, double bottom) {
		super();
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
	
	
	
	
	
	
}
