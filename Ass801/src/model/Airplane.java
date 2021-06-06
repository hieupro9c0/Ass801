package model;

abstract class Airplane {
	private String id;
	private String model;
	private int cruiseSpeed;
	private int emptyWeight;
	private int maxTakeoffWeight;
	
	public Airplane() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCruiseSpeed() {
		return cruiseSpeed;
	}
	public void setCruiseSpeed(int cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}
	public int getEmptyWeight() {
		return emptyWeight;
	}
	public void setEmptyWeight(int emptyWeight) {
		this.emptyWeight = emptyWeight;
	}
	public int getMaxTakeoffWeight() {
		return maxTakeoffWeight;
	}
	public void setMaxTakeoffWeight(int maxTakeoffWeight) {
		this.maxTakeoffWeight = maxTakeoffWeight;
	}
}
