/**
  @file Main.java
 
 @brief Contains the main package for the Car Rental Management System application.
 
 */
/**

@package ce204_hw4_app
@brief The ce204_hw4_app package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_app;

import java.util.Scanner;

/**
 * @class Main
 *
 * @brief The main purpose of the main section in this code is to serve as the
 *        entry point of the Car Rental Management System application. This
 *        method allows the user to select their role (Vendor or User) and
 *        displays the corresponding menu based on the chosen role.
 *
 *        It performs the following steps:
 *
 *        Displays a menu to the user for role selection: Vendor, User, or Exit.
 *        Based on the user's selection, it performs the respective operation:
 *        If the selection is 1, it redirects to the Vendor role and calls the
 *        vendorMenu method. If the selection is 2, it redirects to the User
 *        role and calls the userMenu method. If the selection is 3, it exits
 *        the program. If an invalid selection is made, it displays an error
 *        message and exits the program. Each menu (vendorMenu and userMenu) can
 *        contain sub-menus and operations to perform specific tasks. After
 *        completing user operations, the main method is called again to return
 *        to the role selection menu.
 *
 **/
public class Main {

	/**
	 * @brief The main application instance.
	 */
	public static App app;

	/**
	 * @brief Flag indicating if the program is running.
	 */
	public static boolean isRunning = true;

	/**
	 * The main method that starts the Car Rental Management System application.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		app = new App(new Scanner(System.in));
		app.runMenu();
	}
}