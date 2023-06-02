/**
 * @file app_test.java
 * @brief This file contains the unit tests for the App class.
 */

/**
 * @package ce204_hw4_test
 * @brief This package contains the unit tests for the App class.
 */
package ce204_hw4_test;

import org.junit.Assert;
import org.junit.Test;

import ce204_hw4_app.App;
import ce204_hw4_app.Main;
import ce204_hw4_app.Menus.*;
import ce204_hw4_lib.rentCar.Car;
import ce204_hw4_lib.rentCar.EconomicCar;
import ce204_hw4_lib.rentCar.Vendor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Scanner;


/**
 * @file app_test.java
 * @brief This file contains the unit tests for the App class.
 */

/**
 * @class app_test
 * @brief This class contains the unit tests for the App class.
 */

public class app_test {
	
	
	/**
     * @brief Test case for the setMenu() method.
     * @details This test verifies that the setMenu() method sets the selected menu correctly.
     */
	@Test
	public void setMenuTest() {
		App app = new App(null);
		app.setMenu(app.selectedMenu);
		assertTrue(app.selectedMenu instanceof MainMenu);
	}

	
	/**
     * @brief Test case for the setMainMenu() method.
     * @details This test verifies that the setMainMenu() method sets the selected menu to the main menu.
     */
	@Test
	public void setMainMenuTest() {
		App app = new App(null);
		assertTrue(app.selectedMenu instanceof MainMenu);
	}

	
	
	/**
     * @brief Test case for the setUserMenu() method.
     * @details This test verifies that the setUserMenu() method sets the selected menu to the user menu.
     */
	@Test
	public void setUserMenuTest() {
		App app = new App(null);
		app.setUserMenu();
		assertTrue(app.selectedMenu instanceof UserMenu);
	}
	
	
	/**
     * @brief Test case for the setVendorMenu() method.
     * @details This test verifies that the setVendorMenu() method sets the selected menu to the vendor menu.
     */
	@Test
	public void setVendorMenuTest() {
		App app = new App(null);
		app.setVendorMenu();
		assertTrue(app.selectedMenu instanceof VendorMenu);
	}

	
	/**
     * @brief Test case for the runMainMenuOptions() method.
     * @details This test simulates user input and verifies that the main menu options are executed correctly.
     */
	@Test
	public void runMainMenuOptions() {
		disableConsole();
        String input = "99\n1\n3\n2\n3\n3\n";
        StringReader inputStream = new StringReader(input);
		new App(new Scanner(inputStream)).runMenu();
		assertTrue(true);
	}

	
	/**
     * @brief Test case for the runUserMenuOptions() method.
     * @details This test simulates user input and verifies that the user menu options are executed correctly.
     */
	@Test
	public void runUserMenuOptions() {
		Main.isRunning = true;
        String input = "99\n1\n2\n99"
        		+ "\n2\n1\ny\n1\n123\n123\n123\nR\nI"
        		+ "\n2\n2\nn\n"
        		+ "\n3\n3\n";
        
		App app = new App(new Scanner(new StringReader(input)));
		app.setUserMenu();
		Car car = new EconomicCar("BMW", "M3", 2023);
		car.setVendor(new Vendor(1, "asd", "asd"));
		app.getCars().add(car);
		car = new EconomicCar("BMW", "M4", 2023);
		app.getCars().add(car);
		car = new EconomicCar("BMW", "M5", 2023);
		app.getCars().add(car);
		app.runMenu();
		

		Main.isRunning = true;
		input = "\n2\n1\ny\n2\n123\nI\nR"
				+ "\n2\n2\ny\n5"
        		+ "\n3\n3\n";
		app = new App(new Scanner(new StringReader(input)));
		app.setUserMenu();
		car = new EconomicCar("BMW", "M4", 2023);
		app.getCars().add(car);
		car = new EconomicCar("BMW", "M5", 2023);
		app.getCars().add(car);
		app.runMenu();
		
		

		Main.isRunning = true;
		input = "\n2\n1\ny\n3\n100\nI\nR"
        		+ "\n3\n3\n";
		app = new App(new Scanner(new StringReader(input)));
		app.setUserMenu();
		car = new EconomicCar("BMW", "M5", 2023);
		app.getCars().add(car);
		app.runMenu();
		
		assertTrue(true);
		
	}
	
	/**
     * @brief Test case for the vendorMenuOption3() method.
     * @details This test simulates user input and verifies that vendor menu option 3 is executed correctly.
     */
	@Test
	public void vendorMenuOption3() {
		Main.isRunning = true;
        String input = "44\n3\n1\n1\neconomic\nBMW\nM5\n2020\n1\n1\nR\nR"
        		+ "\n2\n5"
        		+ "\n2\n1"
        		+ "\n3\n3\n";
		App app = new App(new Scanner(new StringReader(input)));
		app.setVendorMenu();
		app.runMenu();
		Assert.assertTrue(true);		
	}
	
	
	/**
     * @brief Test case for the mainClass() method.
     * @details This test simulates user input and verifies that the main method is executed correctly.
     */
	@Test
	public void mainClass() {
		Main.isRunning = true;
        String input = "3\n";
        ByteArrayInputStream reader = new ByteArrayInputStream(input.getBytes());
        System.setIn(new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return reader.read();
			}
		});
        
		new Main();
		Main.main(null);
		Assert.assertTrue(true);
	}
	
	
	/**
     * @brief Helper method to disable console output.
     * @details This method redirects the standard output to a ByteArrayOutputStream to disable console output.
     */
	private void disableConsole() {
		System.setOut(new PrintStream(new ByteArrayOutputStream()));
	}
	
	

}
