/**
  @file VendorMenu.java
  @brief Represents a menu for vendor-related actions in the car rental application.
 */
/**

@package ce204_hw4_app.Menus
@brief The ce204_hw4_app.Menus package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_app.Menus;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ce204_hw4_app.App;
import ce204_hw4_lib.rentCar.Car;
import ce204_hw4_lib.rentCar.CarFactory;
import ce204_hw4_lib.rentCar.Vendor;


/**
 * @class VendorMenu
 * @brief Represents a menu for vendor-related actions in the car rental application.
 */
public class VendorMenu extends Menu {
	/**
	 * @brief List of cars available in the system.
	 */
  private List<Car> cars;
  /**
   * @brief List of vendors in the system.
   */
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
  /**
   * @brief Executes the main functionality of the class.
   *
   * @details This method represents the main entry point of the class and is responsible for executing its core functionality.
   * It displays a menu for vendors, allowing them to add or remove cars, or exit the menu.
   * The user's choice is read from the input using a Scanner object.
   * Based on the chosen option, the corresponding method is called to perform the requested action.
   * The loop continues until the user chooses to exit the menu.
   */
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
    String carNumberStr = scanner.nextLine();
    int carNumber;

    try {
      carNumber = Integer.parseInt(carNumberStr);

      // Check if the car number is valid
      if (carNumber >= 1 && carNumber <= cars.size()) {
        Car carToRemove = cars.get(carNumber - 1);
        // Remove the car from the list of cars and its associated vendor
        cars.remove(carToRemove);

        for (Vendor vendor : vendors) {
          if (vendor.hasCar(carToRemove)) {
            vendor.removeCar(carToRemove);
          }
        }

        System.out.println("------------------------------------------------");
        System.out.println("Car removed successfully!");
      } else {
        System.out.println("------------------------------------------------");
        System.out.println("Invalid car number!");
      }
    } catch (Exception e) {
      System.out.println("------------------------------------------------");
      System.out.println("Invalid car number!");
    }
  }



}
