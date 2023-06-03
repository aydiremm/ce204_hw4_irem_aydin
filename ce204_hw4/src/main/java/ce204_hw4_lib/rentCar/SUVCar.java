/**

@file SUVCar.java
@brief This file serves as a demonstration file for the Rent Car class.
*/

/**

@package ce204_hw4_lib.rentCar
@brief The ce204_hw4_lib.rentCar package contains all the classes and files related to the Calculator App.
*/


package ce204_hw4_lib.rentCar;


/**
 * @brief SUVCar class.
 *
 * This class represents an SUV car, which is a type of Car.
 */
public class SUVCar extends Car {

  /**
     * @brief Constructs an SUVCar object with the specified brand, model, and year.
     *
     * @param brand The brand of the SUV car.
     * @param model The model of the SUV car.
     * @param year The year of the SUV car.
     */
  public SUVCar(String brand, String model, int year) {
    super(brand, model, year);
  }


  /**
   * @brief Displays the information about the SUV car.
   *
   * This method overrides the displayInfo() method in the Car class to display specific information about the SUV car.
   */
  public void displayInfo() {
    System.out.println("SUV Car: " + brand + " " + model + " (" + year + ")");
  }
}
