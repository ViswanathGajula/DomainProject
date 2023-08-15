package com.bikeapp.client;



import com.bikeapp.model.Bike;
import com.bikeapp.service.BikeServiceImlp;
import com.bikeapp.service.IBikeService;
import java.util.Scanner;

public class BikeMain {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		IBikeService bikeService = new BikeServiceImlp();
		
		System.out.println("Welcome to Bike App! Please choose the below process to perform: ");
		System.out.println(
				" 1. Add Bike\n 2. Update Bike \n 3. Get Bikes By ID's \n 4. Get All Bikes \n 5. Delete Bike By Id\n 6. Get Bike By Brandname\n 7. Get Bike By Brandname And By Modelname\n 8. Get Bike By Brandname And By Modelprice");
		int choice = scanner.nextInt();
		if (choice == 1) {
			
			scanner.nextLine();
			System.out.println("Enter modelname: ");
			String name = scanner.nextLine();
			System.out.println("Enter modelId: ");
			int modelId = scanner.nextInt();
			System.out.println("Enter modelprice: ");
			Double price = scanner.nextDouble();
			System.out.println("Enter brandname: ");
			scanner.nextLine();
			String brandname = scanner.nextLine();
			System.out.println("Enter brandId: ");
			int brandId = scanner.nextInt();
	        Bike bike = new Bike(name, modelId,price,brandname,brandId);
			bikeService.addBike(bike);
			
		} else if (choice == 2) {
			System.out.println("Enter bike Id to update price");
			int id = scanner.nextInt();
			System.out.println("Enter new modelprice to add to bike");
			int modelprice= scanner.nextInt();
			bikeService.updateBike(id, modelprice);
		} else if (choice==3) {
			System.out.println("Enter modelId to fetch bikes");
			int id = scanner.nextInt();
			bikeService.getById(id);
		} else if (choice==4) {
			bikeService.getAllBikes();	
		} else if (choice==5) {
			
			System.out.println("Enter bike Id to delete bike");
			
			int id = scanner.nextInt();
			bikeService.deleteBike(id);	
			
			
		} else if (choice==6) {
			System.out.println("Enter bike brandname to fetch bike");
			scanner.nextLine();
			String brandname = scanner.nextLine();
			bikeService.getByBrandname(brandname);
		} else if (choice==7) {
			System.out.println("Enter bike brandname and modelname to fetch bikes");
			System.out.println("brandnames: ");
			scanner.nextLine();
			String brandname = scanner.nextLine();
			System.out.println("Enter modelname: "); 
			String modelname = scanner.nextLine();
			
			bikeService.getByBrandnameAndModelname(brandname, modelname);
		} else {
			System.out.println("Enter bike brandname and modelprice to fetch bikes");
			System.out.println("Brandnames: ");
			scanner.nextLine();
			String brandnames = scanner.nextLine();
			System.out.println("Enter modelprice: ");
			Double modelprice = scanner.nextDouble();
			bikeService.getByBrandnameAndModelprice(brandnames, modelprice);
		}
		scanner.close();


	}



	



	}
