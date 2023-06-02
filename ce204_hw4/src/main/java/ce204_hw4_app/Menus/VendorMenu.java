package ce204_hw4_app.Menus;

import java.util.List;
import java.util.Scanner;

import ce204_hw4_app.App;
import ce204_hw4_lib.rentCar.Car;
import ce204_hw4_lib.rentCar.CarFactory;
import ce204_hw4_lib.rentCar.Vendor;


/**
 * @name VendorMenu
 * @brief Represents a menu for vendor-related actions in the car rental application.
 */
public class VendorMenu extends Menu {
	
	private List<Car> cars;
	private List<Vendor> vendors;
	
	/**
     * @brief Constructs a new VendorMenu object.
     *
     * @param app The App object representing the car rental application.
     */
	public VendorMenu(App app) {
		super(app);
		cars = app.getCars();
		vendors = app.getVendors();
	}

	@Override
	public void run() {
        boolean exitVendorMenu = false;
        while (!exitVendorMenu) {
        	System.out.println("------------------------------------------------");
            System.out.println("Vendor Menu");
            System.out.println("1. Add Car");
            System.out.println("2. Remove Car");
            System.out.println("3. Exit");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    removeCar();
                    break;
                case 3:
                    exitVendorMenu = true;
                    System.out.println("Exiting Vendor Menu...");
                    break;
                default:

                    System.out.println("Invalid choice. Please try again.");

                    break;
            }
        }

        // Return to the role selection menu after exiting the vendor menu
        app.setMainMenu();
	}
	
	


	/**
	 * @brief Prompts the user for car and vendor information and adds a car to the system.
	 */
    private void addCar() {
    	System.out.println("------------------------------------------------");
        System.out.println("Adding Car");

        // Prompt for car information
        System.out.print("Enter car type (economic/luxury/suv/sports): ");
        String carType = scanner.nextLine();

        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        System.out.print("Enter car year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter car price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Prompt for vendor information
        System.out.print("Enter vendor ID: ");
        int vendorId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter vendor name: ");
        String vendorName = scanner.nextLine();

        System.out.print("Enter vendor contact information: ");
        String contactInformation = scanner.nextLine();

        // Create car using CarFactory
        Car car = CarFactory.createCar(carType, brand, model, year);
        if (car != null) {
            car.setPrice(price);
            cars.add(car);

            // Create vendor
            Vendor vendor = new Vendor(vendorId, vendorName, contactInformation);
            car.setVendor(vendor);
            vendor.addCar(car);
            vendors.add(vendor);

            System.out.println("Car added successfully!");
        }
    }

    /**
     * @brief Prompts the user for the car number to remove and removes the corresponding car from the system.
     */
    private void removeCar() {
    	System.out.println("------------------------------------------------");
        System.out.println("Removing Car");

        // Display available cars for selection
        System.out.println("\nAvailable Cars:");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ". " + cars.get(i).getBrand() + " " + cars.get(i).getModel());
        }

        // Prompt for car selection
        System.out.print("\nEnter the number of the car to remove: ");
        int carNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Check if the car number is valid
        if (carNumber >= 1 && carNumber <= cars.size()) {
            Car carToRemove = cars.get(carNumber - 1);

            // Remove the car from the list of cars and its associated vendor
            cars.remove(carToRemove);
            for (Vendor vendor : vendors) {
                if (vendor.hasCar(carToRemove)) {
                    vendor.removeCar(carToRemove);
                    break;
                }
            }
            System.out.println("------------------------------------------------");
            System.out.println("Car removed successfully!");
            
        } else {
        	System.out.println("------------------------------------------------");
            System.out.println("Invalid car number!");
        }
    }



}
