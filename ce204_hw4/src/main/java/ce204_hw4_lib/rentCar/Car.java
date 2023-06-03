/**
  @file Car.java
 
  @brief Car abstract class.
 
  This abstract class represents a car. It provides common attributes and methods that all car types inherit.
 */
/**
@package ce204_hw4_lib.rentCar
@brief The ce204_hw4_lib.rentCar package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_lib.rentCar;

/**
 * @class Car
 * @brief Package for car rental management.
 * 
 */
public abstract class Car {
	/**
	 * @brief The brand of the item.
	 */
	protected String brand;
	/**
	 * @brief The model of the item.
	 */
	protected String model;
	/**
	 * @brief The year of the item.
	 */
	protected int year;
	/**
	 * @brief The price of the item.
	 */
	protected double price;
	/**
	 * @brief The vendor associated with the item.
	 */
	protected Vendor vendor;

	/**
	 * @brief Constructs a car object with the specified brand, model, and year.
	 *
	 * @param brand The brand of the car.
	 * @param model The model of the car.
	 * @param year  The year of the car.
	 */
	public Car(String brand, String model, int year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.vendor = null;
	}

	/**
	 * @brief Displays the information about the car.
	 *
	 *        This method should be implemented by the subclasses to display
	 *        specific information about the car type.
	 */
	public abstract void displayInfo();

	/**
	 * @brief Gets the price of the car.
	 *
	 * @return The price of the car.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @brief Sets the price of the car.
	 *
	 * @param price The price of the car.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @brief Gets the brand of the car.
	 *
	 * @return The brand of the car.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @brief Gets the model of the car.
	 *
	 * @return The model of the car.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @brief Gets the year of the car.
	 *
	 * @return The year of the car.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @brief Sets the vendor of the car.
	 *
	 * @return The vendor of the car.
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	/**
	 * @brief Gets the vendor of the car.
	 *
	 * @return The vendor of the car.
	 */
	public Vendor getVendor() {
		return vendor;
	}
}
