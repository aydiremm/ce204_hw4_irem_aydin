
/**
  @file UserMenu.java
 
  @brief Contains the menu classes for the Car Rental Management System application.
 
  This package includes the menu classes used in the application, such as the UserMenu and MainMenu classes.
  These classes provide functionality for displaying menus, handling user input, and performing specific tasks based on user choices.
 */
/**

@package ce204_hw4_app.Menus
@brief The ce204_hw4_app.Menus package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_app.Menus;

import java.util.List;
import java.util.Scanner;

import ce204_hw4_app.App;
import ce204_hw4_lib.payment.CashPaymentStrategy;
import ce204_hw4_lib.payment.CreditCardPaymentProcessor;
import ce204_hw4_lib.payment.PayPalPaymentStrategy;
import ce204_hw4_lib.payment.PaymentProcessor;
import ce204_hw4_lib.payment.PaymentStrategy;
import ce204_hw4_lib.payment.Reservation;
import ce204_hw4_lib.rentCar.Car;
import ce204_hw4_lib.rentCar.Vendor;

/**
 * @class UserMenu
 *
 * @brief Represents the user menu of the Car Rental Management System.
 *
 *        The UserMenu class extends the Menu class and provides functionality
 *        for displaying the user menu options and handling user input. It
 *        allows users to view available cars, rent a car, or exit the menu.
 */
public class UserMenu extends Menu {

	List<Car> cars;

	/**
	 * @brief Constructs a UserMenu object with the specified App instance.
	 *
	 * @param app The App instance.
	 */
	public UserMenu(App app) {
		super(app);
		cars = app.getCars();
	}

	/**
	 * @brief Displays the user menu and handles user input.
	 *
	 *        The run() method prompts the user to select an option from the user
	 *        menu and performs actions based on the selected choice. It allows
	 *        users to view available cars, rent a car, or exit the menu.
	 */
	@Override
	public void run() {
		boolean exitUserMenu = false;

		while (!exitUserMenu) {
			System.out.println("------------------------------------------------");
			System.out.println("User Menu");
			System.out.println("1. View Available Cars");
			System.out.println("2. Rent a Car");
			System.out.println("3. Exit");
			System.out.println("------------------------------------------------");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				viewAvailableCars();
				break;

			case 2:
				rentCar();
				break;

			case 3:
				exitUserMenu = true;
				System.out.println("Exiting User Menu...");
				break;

			default:
				System.out.println("------------------------------------------------");
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}

		// Return to the role selection menu after exiting the user menu
		app.setMainMenu();
	}

	/**
	 * @brief Displays the list of available cars.
	 */
	private void viewAvailableCars() {
		System.out.println("------------------------------------------------");
		System.out.println("Available Cars:");

		for (Car car : cars) {
			car.displayInfo();
		}
	}

	/**
	 * @brief Handles the process of renting a car.
	 */
	private void rentCar() {
		System.out.println("------------------------------------------------");
		System.out.println("Renting a Car");
		// Display available cars for selection
		System.out.println("\nAvailable Cars:");

		for (int i = 0; i < cars.size(); i++) {
			System.out.println((i + 1) + ". " + cars.get(i).getBrand() + " " + cars.get(i).getModel());
		}

		// Prompt for car selection
		System.out.print("\nEnter the number of the car to rent: ");
		int carNumber = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		// Check if the car number is valid
		if (carNumber >= 1 && carNumber <= cars.size()) {
			Car carToRent = cars.get(carNumber - 1);
			// Display car information and rental cost
			System.out.println("------------------------------------------------");
			System.out.println("Car Details:");
			carToRent.displayInfo();
			System.out.println("Rental Cost: " + carToRent.getPrice());
			// Prompt user to rent the car
			System.out.println("------------------------------------------------");
			System.out.print("Do you want to rent this car? (y/n): ");
			String choice = scanner.nextLine();

			if (choice.equalsIgnoreCase("y")) {
				// Prompt for payment method
				System.out.println("------------------------------------------------");
				System.out.println("Payment Methods:");
				System.out.println("1. Credit Card");
				System.out.println("2. PayPal");
				System.out.println("3. Cash");
				System.out.println("------------------------------------------------");
				System.out.print("Select payment method: ");
				int paymentMethod = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character
				PaymentStrategy paymentStrategy;

				// Process payment based on the selected method
				switch (paymentMethod) {
				case 1:
					System.out.println("------------------------------------------------");
					System.out.print("Enter credit card number: ");
					String creditCardNumber = scanner.nextLine();
					System.out.print("Enter expiration date: ");
					String expirationDate = scanner.nextLine();
					System.out.print("Enter CVV: ");
					String cvv = scanner.nextLine();
					PaymentProcessor creditCardPaymentProcessor = new CreditCardPaymentProcessor(creditCardNumber);
					creditCardPaymentProcessor.processPayment(carToRent.getPrice());
					System.out.println("\\nPayment successful!");
					System.out.println("\nYou have rented the following car");
					carToRent.displayInfo();
					break;

				case 2:
					System.out.println("------------------------------------------------");
					System.out.print("Enter PayPal email: ");
					String email = scanner.nextLine();
					PaymentStrategy payPalPaymentStrategy = new PayPalPaymentStrategy(email);
					Reservation reservation = new Reservation(payPalPaymentStrategy);
					reservation.processPayment(carToRent.getPrice());
					System.out.println("Payment successful!");
					System.out.println("You have rented the following car:");
					carToRent.displayInfo();
					break;

				case 3:
					System.out.println("------------------------------------------------");
					System.out.print("Enter cash: ");
					Integer cash = scanner.nextInt();
					scanner.nextLine();
					CashPaymentStrategy cashPayment = new CashPaymentStrategy();
					cashPayment.pay(cash);
					System.out.println("Payment successful!");
					System.out.println("You have rented the following car:");
					carToRent.displayInfo();
					break;

				default:
					System.out.println("Invalid payment method. Renting failed!");
					return;
				}

				// Prompt for billing information
				System.out.println("------------------------------------------------");
				System.out.println("\nBilling Information");
				System.out.print("Enter user name: ");
				String customerName = scanner.nextLine();
				System.out.print("Enter user address: ");
				String customerAddress = scanner.nextLine();
				// Generate and display the bill
				System.out.println("------------------------------------------------");
				System.out.println("\n******* Rental Bill ********");
				System.out.println("User Name: " + customerName);
				System.out.println("User Address: " + customerAddress);
				System.out.println("Car Details:");
				carToRent.displayInfo();
				System.out.println("Rental Cost: " + carToRent.getPrice());
				// Generate and display the vendor
				Vendor vendor = carToRent.getVendor();

				if (vendor != null) {
					System.out.println("Vendor Information: ");
					System.out.println("Name: " + vendor.getVendorName());
					System.out.println("Contact: " + vendor.getContactInformation());
					System.out.println("*************************");
				}
			} else {
				System.out.println("Car rental canceled.");
			}
		} else {
			System.out.println("Invalid car number!");
		}
	}

}
