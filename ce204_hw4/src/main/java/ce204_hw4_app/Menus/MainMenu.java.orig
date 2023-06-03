package ce204_hw4_app.Menus;

import ce204_hw4_app.App;
import ce204_hw4_app.Main;

/**      *
 *      @name  MainMenu
 *
 *      @brief Represents the main menu of the Car Rental Management System.
 *
 *     The MainMenu class extends the Menu class and provides functionality for displaying
 *     the main menu options and handling user input. It allows users to select their role
 *     (vendor or user) or choose to exit the program.
 **/
public class MainMenu extends Menu {
	
	
	/**
	 * @brief Constructs a new MainMenu object.
	 * @param app The main application object.
	 */

	public MainMenu(App app) {
		super(app);
		
	}

	
	/**
	 * @brief Displays the main menu and handles user input.
	 * 
	 * The run() method prompts the user to select their role and performs actions
	 * based on the selected choice. It allows users to log in as a vendor, log in as
	 * a user, or exit the program.
	 */
	@Override
	public void run() {
        // Prompt for login role
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to the Car Rental Management System!");
        System.out.println("------------------------------------------------");
        System.out.println("Please select your role:");
        System.out.println("1. Vendor");
        System.out.println("2. User");
        System.out.println("3. Exit");
        System.out.println("------------------------------------------------");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Perform actions based on selected role
        switch (choice) {
            case 1:
                // Vendor login
            	app.setVendorMenu();
                break;
            case 2:
                // User login
                app.setUserMenu();
                break;
            case 3:
                // Exit the program
                System.out.println("Exiting...");
                Main.isRunning = false;
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
	}

}
