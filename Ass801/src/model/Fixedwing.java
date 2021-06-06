package model;

public class Fixedwing extends Airplane{
	private String planeType;
	private int minNeededRunwaySize;
	private String flyMethod = "fixed Wings";
	
	public Fixedwing() {
		// TODO Auto-generated constructor stub
	}
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public int getMinNeededRunwaySize() {
		return minNeededRunwaySize;
	}
	public void setMinNeededRunwaySize(int minNeededRunwaySize) {
		this.minNeededRunwaySize = minNeededRunwaySize;
	}
	public String getFlyMethod() {
		return flyMethod;
	}
	public void setFlyMethod(String flyMethod) {
		this.flyMethod = flyMethod;
	}

}
