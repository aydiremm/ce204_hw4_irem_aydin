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

public class app_test {
	
	@Test
	public void setMenuTest() {
		App app = new App(null);
		app.setMenu(app.selectedMenu);
		assertTrue(app.selectedMenu instanceof MainMenu);
	}

	@Test
	public void setMainMenuTest() {
		App app = new App(null);
		assertTrue(app.selectedMenu instanceof MainMenu);
	}

	
	@Test
	public void setUserMenuTest() {
		App app = new App(null);
		app.setUserMenu();
		assertTrue(app.selectedMenu instanceof UserMenu);
	}
	
	@Test
	public void setVendorMenuTest() {
		App app = new App(null);
		app.setVendorMenu();
		assertTrue(app.selectedMenu instanceof VendorMenu);
	}

	@Test
	public void runMainMenuOptions() {
		disableConsole();
        String input = "99\n1\n3\n2\n3\n3\n";
        StringReader inputStream = new StringReader(input);
		new App(new Scanner(inputStream)).runMenu();
		assertTrue(true);
	}

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
	
	private void disableConsole() {
		System.setOut(new PrintStream(new ByteArrayOutputStream()));
	}
	
	

}
