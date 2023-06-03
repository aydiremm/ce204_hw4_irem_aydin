/**
  @file CarFactory.java
  @brief CarFactory class creates a car object based on the provided car type, brand, model, and year.
 */
/**
@package ce204_hw4_lib.rentCar
@brief The ce204_hw4_lib.rentCar package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_lib.rentCar;

/**
 * @class CarFactory
 * @brief Creates a car object based on the provided car type, brand, model, and
 * 
 */
public class CarFactory {

	/**
	 * 
	 * @brief Creates a new instance of a Car based on the given car type, brand,
	 *        model, and year.
	 * 
	 * @param carType The type of car to create. Valid values are "economic",
	 *                "luxury", "suv", and "sports".
	 * 
	 * @param brand   The brand of the car.
	 * 
	 * @param model   The model of the car.
	 * 
	 * @param year    The manufacturing year of the car.
	 * 
	 * @return A Car object of the specified type, or null if the car type is
	 *         invalid.
	 */
	public static Car createCar(String carType, String brand, String model, int year) {
		Car car = null;

		switch (carType.toLowerCase()) {
		case "economic":
			car = new EconomicCar(brand, model, year);
			break;

		case "luxury":
			car = new LuxuryCar(brand, model, year);
			break;

		case "suv":
			car = new SUVCar(brand, model, year);
			break;

		case "sports":
			car = new SportsCar(brand, model, year);
			break;

		default:
			System.out.println("Invalid car type.");
		}

		return car;
	}
}
