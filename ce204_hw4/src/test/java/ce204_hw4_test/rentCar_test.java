package ce204_hw4_test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ce204_hw4_lib.rentCar.*;

import java.util.ArrayList;
import java.util.List;
import ce204_hw4_lib.reservation.ConsoleOutput;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import ce204_hw4_lib.reservation.ConsoleOutputCapturer;
public class rentCar_test {
	CarFactory carFactory = new CarFactory();

	@Test
	public void testCreateCar1() {
		// Test data
		String carType = "sedan";
		String brand = "Toyota";
		String model = "Camry";
		int year = 2021;

		// Create an economic car using the factory method
		Car economicCar = CarFactory.createCar("economic", brand, model, year);
		Assert.assertNotNull(economicCar);
		Assert.assertEquals(brand, economicCar.getBrand());
		Assert.assertEquals(model, economicCar.getModel());
		Assert.assertEquals(year, economicCar.getYear());

		// Create a luxury car using the factory method
		Car luxuryCar = CarFactory.createCar("luxury", brand, model, year);
		Assert.assertNotNull(luxuryCar);
		Assert.assertEquals(brand, luxuryCar.getBrand());
		Assert.assertEquals(model, luxuryCar.getModel());
		Assert.assertEquals(year, luxuryCar.getYear());

		// Create an SUV car using the factory method
		Car suvCar = CarFactory.createCar("suv", brand, model, year);
		Assert.assertNotNull(suvCar);
		Assert.assertEquals(brand, suvCar.getBrand());
		Assert.assertEquals(model, suvCar.getModel());
		Assert.assertEquals(year, suvCar.getYear());

		// Create a sports car using the factory method
		Car sportsCar = CarFactory.createCar("sports", brand, model, year);
		Assert.assertNotNull(sportsCar);
		Assert.assertEquals(brand, sportsCar.getBrand());
		Assert.assertEquals(model, sportsCar.getModel());
		Assert.assertEquals(year, sportsCar.getYear());

		// Test with an invalid car type
		Car car = CarFactory.createCar(carType, brand, model, year);
		Car invalidCar = CarFactory.createCar("invalid", brand, model, year);
		Assert.assertNull(invalidCar);
		assertNull(car);
	}

	@Test
	public void testVendorConstructor1() {
		int vendorId = 1;
		String vendorName = "ABC Motors";
		String contactInformation = "123-456-7890";

		Vendor vendor = new Vendor(vendorId, vendorName, contactInformation);

		assertEquals(vendorId, vendor.getVendorId());
		assertEquals(vendorName, vendor.getVendorName());
		assertEquals(contactInformation, vendor.getContactInformation());

		assertEquals(0, vendor.getRentalCost(), 0.001);
	}

	@Test
	public void testAddCar2() {
		int vendorId = 1;
		String vendorName = "ABC Motors";
		String contactInformation = "123-456-7890";

		Vendor vendor = new Vendor(vendorId, vendorName, contactInformation);

	}

	@Test
	public void testCalculateTotalRentalCost() {
		int vendorId = 1;
		String vendorName = "ABC Motors";
		String contactInformation = "123-456-7890";

		Vendor vendor = new Vendor(vendorId, vendorName, contactInformation);

	}

	@Test
	public void testCalculateRentalCost1() {
		Vendor vendor = new Vendor(1, "ABC Motors", "123-456-7890");

		// Test case 1: carType = "economic", rentalDuration = 5
		double expectedCost1 = 50.0 * 5;
		double actualCost1 = vendor.calculateRentalCost(5, "economic");
		assertEquals(expectedCost1, actualCost1, 0.001);

		// Test case 2: carType = "luxury", rentalDuration = 3
		double expectedCost2 = 100.0 * 3;
		double actualCost2 = vendor.calculateRentalCost(3, "luxury");
		assertEquals(expectedCost2, actualCost2, 0.001);

		// Test case 3: carType = "suv", rentalDuration = 7
		double expectedCost3 = 80.0 * 7;
		double actualCost3 = vendor.calculateRentalCost(7, "suv");
		assertEquals(expectedCost3, actualCost3, 0.001);

		// Test case 4: carType = "sports", rentalDuration = 2
		double expectedCost4 = 120.0 * 2;
		double actualCost4 = vendor.calculateRentalCost(2, "sports");
		assertEquals(expectedCost4, actualCost4, 0.001);
	}

	private Vendor vendor;

	@Before
	public void setUp() {
		vendor = new Vendor(1, "ABC Motors", "123-456-7890");
	}

	@Test
	public void testCalculateRentalCost() {
		double expectedCost = 100.0; // Base price of "luxury" car type is 100.0
		double actualCost = vendor.calculateRentalCost(2, "luxury");
		assertNotEquals(expectedCost, actualCost, 0.01); // Allow a small delta for double comparison

		expectedCost = 240.0; // Base price of "suv" car type is 80.0
		actualCost = vendor.calculateRentalCost(3, "suv");
		assertEquals(expectedCost, actualCost, 0.01); // Allow a small delta for double comparison
	}

	@Test
	public void testGetPrice() {
		String brand = "bmw";
		String model = "m8";
		int year = 2020;
		Car economicCar = CarFactory.createCar("economic", brand, model, year);

		economicCar.setPrice(50000.0);

		double expectedPrice = 50000.0;
		double actualPrice = economicCar.getPrice();

		assertEquals(expectedPrice, actualPrice, 0.001);
	}

	@Test
	public void testSetPrice() {
		String brand = "bmw";
		String model = "m8";
		int year = 2020;
		Car economicCar = CarFactory.createCar("economic", brand, model, year);
		economicCar.setPrice(60000.0);

		double expectedPrice = 60000.0;
		double actualPrice = economicCar.getPrice();

		assertEquals(expectedPrice, actualPrice, 0.001);
	}

	@Test
	public void testAddCar() {
		String brand = "bmw";
		String model = "m8";
		int year = 2020;
		Car economicCar = CarFactory.createCar("economic", brand, model, year);

		Vendor vendor = new Vendor(1, "carRental", "0539204152");

		vendor.addCar(economicCar);

		assertTrue(vendor.hasCar(economicCar));
	}

	@Test
	public void testRemoveCar() {
		// Create a vendor
		Vendor vendor = new Vendor(1, "ABC Car Rental", "123-456-7890");

		// Create some cars
		Car car1 = new EconomicCar("Toyota", "Corolla", 2020);
		Car car2 = new LuxuryCar("Mercedes-Benz", "S-Class", 2021);
		Car car3 = new SUVCar("Ford", "Explorer", 2019);

		// Add cars to the vendor's inventory
		vendor.addCar(car1);
		vendor.addCar(car2);
		vendor.addCar(car3);

		// Remove car2 from the vendor's inventory
		vendor.removeCar(car2);

		// Check if car2 is no longer in the vendor's inventory
		assertFalse(vendor.hasCar(car2));
	}
	@Test
    public void testDisplayInfo() {
        // Create an SUV car
        SUVCar suvCar = new SUVCar("Toyota", "Rav4", 2022);

        // Define the expected output
        String expectedOutput = "SUV Car: Toyota Rav4 (2022)";

        // Create a console output capturer
        ConsoleOutputCapturer capturer = new ConsoleOutputCapturer();

        // Start capturing console output
        capturer.start();

        // Call the displayInfo method
        suvCar.displayInfo();

        // Stop capturing console output
        capturer.stop();

        // Get the captured console output
        String consoleOutput = capturer.getOutput();

        // Check if the console output matches the expected output
        assertEquals(expectedOutput, consoleOutput.trim());
    }
	
	@Test
    public void testDisplayInfo2() {
        // Create a SportsCar object
        SportsCar sportsCar = new SportsCar("Ferrari", "488 GTB", 2022);

        // Redirect System.out to capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the displayInfo method
        sportsCar.displayInfo();

        // Get the console output
        String consoleOutput = outputStream.toString().trim();

        // Define the expected output
        String expectedOutput = "Sports Car: Ferrari 488 GTB (2022)";

        // Assert the console output matches the expected output
        assertEquals(expectedOutput, consoleOutput);
    }
	@Test
    public void testDisplayInfo3() {
        // Create an instance of the LuxuryCar class
        LuxuryCar luxuryCar = new LuxuryCar("Mercedes", "S-Class", 2022);

        // Redirect System.out to capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the displayInfo method
        luxuryCar.displayInfo();

        // Get the console output
        String consoleOutput = outputStream.toString().trim();

        // Define the expected output
        String expectedOutput = "Luxury Car: Mercedes S-Class (2022)";

        // Assert the console output matches the expected output
        assertEquals(expectedOutput, consoleOutput);
    }
	
	@Test
    public void testDisplayInfo4() {
        // Create an instance of the EconomicCar class
        EconomicCar economicCar = new EconomicCar("Toyota", "Corolla", 2022);

        // Redirect System.out to capture the console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the displayInfo method
        economicCar.displayInfo();

        // Get the console output
        String consoleOutput = outputStream.toString().trim();

        // Define the expected output
        String expectedOutput = "Economic Car: Toyota Corolla (2022)";

        // Assert the console output matches the expected output
        assertEquals(expectedOutput, consoleOutput);
    }

}
