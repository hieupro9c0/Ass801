package UI;

import controller.Process;
import controller.Validation;

public class main {
	public static void main(String[] args) {
		Process p = new Process();	
		Validation v = new Validation();
		while(true) {
			System.out.println("1. Create Airpot");
			System.out.println("2. Create Airplane");
			System.out.println("3. List of Airport");
			System.out.println("4. Airport Status");
			System.out.println("5. List of fixed wing airplane");
			System.out.println("6. List of helicopter");
			System.out.println("7. Exit");
			int choice = v.getValidInt(1 , 7);
			switch (choice) {
			case 1: {
				System.out.println(p.createNewAirport());
				break;
			}
			case 2: {
				System.out.println(p.createNewAirplane());
				break;
			}
			case 3: {
				System.out.println("List of airport");
				p.displayListAirport();
				break;
			}
			case 4: {
				System.out.println("Airport Status");
				p.displayStatus();
				break;
			}
			case 5: {
				p.displayAllFixedWingAirplane();
				break;
			}
			case 6: {
				p.displayAllRotatedWingAirplane();
				break;
			}
			case 7: {
				return;
			}
			}
		}
	}
}
