package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.sun.tools.javac.Main;

import model.Airport;
import model.Fixedwing;
import model.Helicopter;

public class Process {
	Validation v = new Validation();
	Scanner sc = new Scanner(System.in);
	private ArrayList<Airport> listAirport = new ArrayList<Airport>();
	public String createNewAirport() {
		Airport a = new Airport();
		a.setId(v.getValidId("Airport (Format: APXXXXX)"));
		System.out.println("Enter Aiport Name:");
		a.setName(v.inputString());
		System.out.println("Enter Runway Size");
		a.setRunwaySize(v.getValidInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println("Enter Max Gixed Wing Parking Place");
		a.setMaxFixedWingParkingPlace(v.getValidInt(1, Integer.MAX_VALUE));
		System.out.println("Enter Max Rotated Wing Parking Place");
		a.setMaxRotatedWingParkingPlace(v.getValidInt(1, Integer.MAX_VALUE));
		listAirport.add(a);
		return "Add Successful!";
	}
	public String createNewAirplane() {
		if(listAirport.isEmpty()) {
			return "Empty List! Please Add More Airport!";
		}
		System.out.println("Please Choose an Airport You Want To Parking Plane");
		for (int i =0; i < listAirport.size(); i++) {
			System.out.println((i+1)+"."+listAirport.get(i).getName());
		}
		int userChoice = v.getValidInt(1, listAirport.size());
		boolean exit = false;
		while(!exit) {
			System.out.println("1. Create New Fixedwing Airplane");
			System.out.println("2. Create New Helicopter Airplane");
			System.out.println("3. Exit");
			int choice = v.getValidInt(1, 3);
			switch (choice) {
			case 1: {
				List<Fixedwing> listFixed = listAirport.get(userChoice-1).getListOfFixedWingAirplaneID();
				createNewFixedWingAirplane(listFixed, listAirport.get(userChoice-1));
				break;
			}
			case 2: {
				List<Helicopter> listHeli = listAirport.get(userChoice-1).getListOfHelicopterID();
				createNewHelicopterAirplane(listHeli);
				break;
			}
			case 3 :
				exit = true;
				break;
			}
		}
		return "Create Successful";
	}
	private void createNewHelicopterAirplane(List<Helicopter> listHeli) {
		String id = v.getValidId("Helicopter (Format: RWXXXXX)");
		String model = v.getValidModel();
		System.out.println("Input cruise speed :");
		int cruiseSpeed = v.getValidInt(0, Integer.MAX_VALUE);
		System.out.println("Input empty weight :");
		int emptyWeight = v.getValidInt(0, Integer.MAX_VALUE);
		System.out.println("Input max take off weight :");
		int maxTakeoffWeight = v.getValidInt(0, Integer.MAX_VALUE);
		while(maxTakeoffWeight> emptyWeight*1.5) {
			System.out.println("reenter max take off weight smaller than 1.5 time of empty weight: ");
			maxTakeoffWeight = v.getValidInt(0, Integer.MAX_VALUE);
		}
		System.out.println("Input range :");
		int range = v.getValidInt(0, Integer.MAX_VALUE);
		Helicopter helicopter = new Helicopter();
		helicopter.setId(id);
		helicopter.setCruiseSpeed(cruiseSpeed);
		helicopter.setEmptyWeight(emptyWeight);
		helicopter.setMaxTakeoffWeight(maxTakeoffWeight);
		helicopter.setModel(model);
		helicopter.setRange(range);
		
		listHeli.add(helicopter);
		
	}
	private void createNewFixedWingAirplane(List<Fixedwing> listFixed, Airport airport) {
		String id = v.getValidId("Fixed Wing (Format: FWXXXXX)");
		String model = v.getValidModel();
		String planType = v.inputFixWingType();
		System.out.println("Input cruise speed :");
		int cruiseSpeed = v.getValidInt(0, Integer.MAX_VALUE);
		System.out.println("Input empty weight :");
		int emptyWeight = v.getValidInt(0, Integer.MAX_VALUE);
		System.out.println("Input max take off weight :");
		int maxTakeoffWeight = v.getValidInt(0, Integer.MAX_VALUE);
		int minNeededRunwaySize = v.inputFixWingRunwaySize(airport);
		Fixedwing fixedWing = new Fixedwing();
		fixedWing.setId(id);
		fixedWing.setPlaneType(planType);
		fixedWing.setCruiseSpeed(cruiseSpeed);
		fixedWing.setEmptyWeight(emptyWeight);
		fixedWing.setMaxTakeoffWeight(maxTakeoffWeight);
		fixedWing.setModel(model);
		fixedWing.setMinNeededRunwaySize(minNeededRunwaySize);
		listFixed.add(fixedWing);		
	}
	public void displayListAirport() {
		Collections.sort(listAirport ,new Comparator<Airport>() {  
			@Override
			public int compare(Airport a1, Airport a2) {
				return a1.getId().compareTo(a2.getId());
			}  
		});  
		System.out.println("ID" + String.format("%28s", "|") + "Name" + String.format("%26s", "|") + "RunwaySize"
				+ String.format("%20s", "|") + "maxFixedWingParkingPlace" + String.format("%6s", "|") + "maxRotatedWingParkingPlace");
		for (int i =0; i < listAirport.size(); i++) {
			System.out.println(listAirport.get(i).getId() + String.format("%"+(30-listAirport.get(i).getId().length())+"s", "|") 
			+ listAirport.get(i).getName() + String.format("%"+(30-listAirport.get(i).getName().length())+"s", "|") 
			+ listAirport.get(i).getRunwaySize() + String.format("%"+(30-Double.toString(listAirport.get(i).getRunwaySize()).length())+"s", "|") 
			+ listAirport.get(i).getMaxFixedWingParkingPlace() + String.format("%"+(30 - Double.toString(listAirport.get(i).getMaxFixedWingParkingPlace()).length())+"s", "|") 
			+ listAirport.get(i).getMaxRotatedWingParkingPlace());
		}
	}
	public void displayStatus() {
		for (Airport airports : listAirport) {
			if(airports.getListOfFixedWingAirplaneID().size() == airports.getMaxFixedWingParkingPlace()) {
				System.out.println(airports.getName() + " Airport Fixed Wing Slot is Full");
			}else {
				System.out.println(airports.getName() + " Airport has " + (airports.getMaxFixedWingParkingPlace() - airports.getListOfFixedWingAirplaneID().size()) + " fixed wing slot left");
			}
		}
		for (Airport airports : listAirport) {
			if(airports.getListOfHelicopterID().size() == airports.getMaxRotatedWingParkingPlace()) {
				System.out.println(airports.getName() + " Airport Rotated Wing Slot is Full");
			}else {
				System.out.println(airports.getName() + " Airport has " + (airports.getMaxFixedWingParkingPlace() - airports.getListOfFixedWingAirplaneID().size()) + " rotated wing slot left");
			}
		}
		
	}
	public void displayAllFixedWingAirplane() {
		System.out.println("=List of fixed wing airplane");
		System.out.println("ID" + String.format("%28s", "|") + "Model" + String.format("%25s", "|") + "ParkingAirportID"
				+ String.format("%14s", "|") + "ParkingAirportName");
		for (Airport airports : listAirport) {
			for (Fixedwing fixedwing : airports.getListOfFixedWingAirplaneID()) {
				System.out.println(fixedwing.getId() + String.format("%"+(30-fixedwing.getId().length())+"s", "|") 
				+ fixedwing.getModel() + String.format("%"+(30-fixedwing.getModel().length())+"s", "|") 
				+ airports.getId() + String.format("%"+(30-airports.getId().length())+"s", "|") + airports.getName());
			}
		}
		
	}
	public void displayAllRotatedWingAirplane() {
		System.out.println("List of rotated wing airplane");
		System.out.println("ID" + String.format("%28s", "|") + "Model" + String.format("%25s", "|") + "ParkingAirportID"
				+ String.format("%14s", "|") + "ParkingAirportName");
		for (Airport airports : listAirport) {
			for (Helicopter helicopters : airports.getListOfHelicopterID()) {
				System.out.println(helicopters.getId() + String.format("%"+(30-helicopters.getId().length())+"s", "|") 
				+ helicopters.getModel() + String.format("%"+(30-helicopters.getModel().length())+"s", "|") 
				+ airports.getId() + String.format("%"+(30-airports.getId().length())+"s", "|") + airports.getName());
			}
		}
		
	}
}
