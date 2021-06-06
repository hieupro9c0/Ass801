package model;

import java.util.ArrayList;
import java.util.List;

public class Airport {
	private String id;
	private String name;
	private int runwaySize;
	private int maxFixedWingParkingPlace;
	private List<Fixedwing> listOfFixedWingAirplaneID = new ArrayList<Fixedwing>();
	private List<Helicopter>listOfHelicopterID = new ArrayList<Helicopter>();
	private int maxRotatedWingParkingPlace;
	
	public Airport() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRunwaySize() {
		return runwaySize;
	}
	public void setRunwaySize(int runwaySize) {
		this.runwaySize = runwaySize;
	}
	public int getMaxFixedWingParkingPlace() {
		return maxFixedWingParkingPlace;
	}
	public void setMaxFixedWingParkingPlace(int maxFixedWingParkingPlace) {
		this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
	}
	public List<Fixedwing> getListOfFixedWingAirplaneID() {
		return listOfFixedWingAirplaneID;
	}
	public void setListOfFixedWingAirplaneID(List<Fixedwing> listOfFixedWingAirplaneID) {
		this.listOfFixedWingAirplaneID = listOfFixedWingAirplaneID;
	}
	public List<Helicopter> getListOfHelicopterID() {
		return listOfHelicopterID;
	}
	public void setListOfHelicopterID(List<Helicopter> listOfHelicopterID) {
		this.listOfHelicopterID = listOfHelicopterID;
	}
	public int getMaxRotatedWingParkingPlace() {
		return maxRotatedWingParkingPlace;
	}
	public void setMaxRotatedWingParkingPlace(int maxRotatedWingParkingPlace) {
		this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
	}
}
