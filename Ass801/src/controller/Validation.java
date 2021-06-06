package controller;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.Airport;

public class Validation {
	Scanner sc = new Scanner(System.in);
	 public int getValidInt(int min, int max) {
	        while (true) {
	            try {
	                int temp = Integer.parseInt(sc.nextLine());
	                if (temp < min || temp > max) {
	                    throw new Exception();
	                }
	                return temp;
	            } catch (Exception e) {
	                System.out.println("Wrong format");
	                System.out.println("Please enter again");
	            }
	        }
	    }
	 
	 public String getValidId(String type) {
			String pattern = "[A-Z]{2}\\d{5}";
			System.out.println("Please Enter " + type + " Id ");
			String id = sc.nextLine();
			if (Pattern.matches(pattern, id)) {
				if (type.equals("Fixed Wing (Format: FWXXXXX)")) {
					if (id.substring(0, 2).equals("FW")) {
						return id;
					} else {
						System.out.println("Wrong format");
						System.out.println("Please enter again");
						getValidId(type);
					}
				}
				if (type.equals("Helicopter (Format: RWXXXXX)")) {
					if (id.substring(0, 2).equals("RW")) {
						return id;
					} else {
						System.out.println("Wrong format");
						System.out.println("Please enter again");
						getValidId(type);
					}
				}
				if (type.equals("Airport (Format: APXXXXX)")) {
					if (id.substring(0, 2).equals("AP")) {	
						return id;
					} else {
						System.out.println("Wrong format");
						System.out.println("Please enter again");
						getValidId(type);
					}
				}

			}else {
				System.out.println("Wrong format");
				System.out.println("Please enter again");
				getValidId(type);
			}
			return "";
		}
	 
	 public String getValidModel() {
			System.out.println("Please enter airplane model : ");
			String model = sc.nextLine();
			if (model.length() > 40) {
				System.out.println("size limit 40 char");
				System.out.println("Please enter again");
				getValidModel();
			} else {
				return model;
			}
			return null;
		}
	 
	 public String inputFixWingType() {
			System.out.println("Enter type (CAG/LGR/PRV): ");
			String type = sc.nextLine();
			if("CAG".equals(type)||"LGR".equals(type)||"PRV".equals(type)) {
				return type;
			}else{
				System.out.println("Please Enter CAG/LGR/PRV");
				System.out.println("Please enter again");
				inputFixWingType();
			}
			return null;
		}
	 
	 public int inputFixWingRunwaySize(Airport airpot) {
			System.out.println("Enter Fix Wing runway size ");
			int runwaySize = sc.nextInt();
			if(airpot.getRunwaySize() > runwaySize) {
				return runwaySize;
			}else {
				System.out.println("Please enter runwaysize < than airpot runway size ("+airpot.getRunwaySize()+")");
				inputFixWingRunwaySize(airpot);
			}
			return 0;
		}
	 
	 public String inputString() {
			while (true) {
				String result = sc.nextLine().trim();
				if (result.isEmpty()) {
					System.err.println("Not Empty!");
					System.out.print("Enter Again: ");
				} else {
					return result;
				}
			}
		}
}
