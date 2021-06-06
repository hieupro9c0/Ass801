package model;

public class Helicopter extends Airplane{
	private int range;
	private String flyMethod;
	
	public Helicopter() {
		// TODO Auto-generated constructor stub
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public String getFlyMethod() {
		return flyMethod;
	}
	public void setFlyMethod(String flyMethod) {
		this.flyMethod = flyMethod;
	}
}
