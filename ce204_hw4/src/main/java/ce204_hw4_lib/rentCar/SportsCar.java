/**
@file SportsCar.java
@brief This file serves as a demonstration file for the Rent Car class.
*/

/**
@package ce204_hw4_lib.rentCar
@brief The ce204_hw4_lib.rentCar package contains all the classes and files related to the Calculator App.
*/

package ce204_hw4_lib.rentCar;

/**
 * @brief SportsCar class.
 *
 *        This class represents a sports car, which is a type of Car.
 */
public class SportsCar extends Car {

	/**
	 * @brief Constructs a SportsCar object with the specified brand, model, and
	 *        year.
	 *
	 * @param brand The brand of the sports car.
	 * @param model The model of the sports car.
	 * @param year  The year of the sports car.
	 */
	public SportsCar(String brand, String model, int year) {
		super(brand, model, year);
	}

	/**
	 * @brief Displays the information about the sports car.
	 *
	 *        This method overrides the displayInfo() method in the Car class to
	 *        display specific information about the sports car.
	 */
	public void displayInfo() {
		System.out.println("Sports Car: " + brand + " " + model + " (" + year + ")");
	}
}