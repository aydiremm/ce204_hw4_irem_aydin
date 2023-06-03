/**
  @file Menu.java
 
  @brief Contains the menu classes for the Car Rental Management System application.
 
  This package includes the abstract menu class, which provides a method or function to access or retrieve a reference to a paste button in a user interface.
  The specific implementation of the method or function would depend on the programming language, framework, or library being used.
 */
/**

@package ce204_hw4_app.Menus
@brief The ce204_hw4_app.Menus package contains all the classes and files related to the Rent Car App.
*/

package ce204_hw4_app.Menus;

import java.util.Scanner;

import ce204_hw4_app.App;
import ce204_hw4_app.Main;

/**
 * @class Menu
 *
 * @brief This abstract class provides a method or function to access or
 *        retrieve a reference to a paste button in a user interface.
 *
 *        The method or function would depend on the programming language,
 *        framework, or library being used. It is typically used to obtain a
 *        reference to the paste button object, allowing developers to
 *        manipulate its appearance or functionality.
 */
public abstract class Menu {

	/**
	 * @brief Constructor method for the Menu class.
	 *
	 * @param app An instance of the App class that holds the reference to the
	 *            application.
	 */
	protected App app;
	/**
	 * @brief Scanner object for input.
	 */
	protected Scanner scanner;

	/**
	 * @brief Constructs a new Menu object.
	 *
	 * @param app The App object associated with this Menu.
	 */
	public Menu(App app) {
		this.app = app;
		this.scanner = app.scanner;
	}

	/**
	 * @brief Executes the main functionality of the abstract class.
	 *
	 * @details This method should be implemented by subclasses to define the
	 *          specific behavior of the class. It represents the main entry point
	 *          of the abstract class and is responsible for executing its core
	 *          functionality.
	 */
	public abstract void run();

}
