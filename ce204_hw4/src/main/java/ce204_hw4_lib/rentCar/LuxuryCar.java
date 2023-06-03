
/**
@file LuxuryCar.java
@brief This file serves as a demonstration file for the Rent Car class.
*/

/**

@package ce204_hw4_lib.rentCar
@brief The ce204_hw4_lib.rentCar package contains all the classes and files related to the Calculator App.
*/

package ce204_hw4_lib.rentCar;

/**
 * @brief LuxuryCar class.
 *
 *        This class represents a luxury car, which is a type of Car.
 */
public class LuxuryCar extends Car {

	/**
	 * @brief Constructs a LuxuryCar object with the specified brand, model, and
	 *        year.
	 *
	 * @param brand The brand of the luxury car.
	 * @param model The model of the luxury car.
	 * @param year  The year of the luxury car.
	 */
	public LuxuryCar(String brand, String model, int year) {
		super(brand, model, year);
	}

	/**
	 * @brief Displays the information about the luxury car.
	 *
	 *        This method overrides the displayInfo() method in the Car class to
	 *        display specific information about the luxury car.
	 */
	public void displayInfo() {
		System.out.println("Luxury Car: " + brand + " " + model + " (" + year + ")");
	}
}