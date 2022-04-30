//Author: Hardik Agarwal @ 83

package com.cdac.geometry;
public class Point2D{
	private int x;
	private int y;
	
	// parameterized constructor
	public Point2D(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	// show() method
	public String show(){
		return "Point X : "+this.x+"\nPoint Y : "+this.y;	
	}
	
	public int getX(){
		return this.x;	
	}
	
	public int getY(){
		return this.y;	
	}
	
	public boolean isEqual(Point2D p){
		if((this.x == p.x) && (this.y == p.y)){
			return true;
		}
		return false;
	}
	
	public double calculateDistance(Point2D p){
		double X1 = this.getX();
		double Y1 = this.getY();
		double X2 = p.getX();
		double Y2 = p.getY();
		
		return Math.sqrt((Math.pow((Y2 - Y1),2)) + (Math.pow((X2 - X1),2)));
	}
}