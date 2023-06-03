/**
  @file ConsoleOutput.java
  @brief This package contains classes related to reservations.
 
  The `ce204_hw4_lib.reservation` package contains classes that are involved in handling reservations.
  It provides functionality for creating reservations, processing payments, and managing car rentals.
  The classes in this package are designed to work together to facilitate the reservation process.
 */
/**
@package ce204_hw4_lib.reservation
@brief ce204_hw4_lib.reservation package contains all the classes and files related to the Rent Car App.
*/

package ce204_hw4_lib.reservation;

/**
 * @class ConsoleOutput
 * @brief This file contains the definition of the ConsoleOutput class.
 */

/**
 * @brief The ConsoleOutput class provides a mechanism to print messages to the
 *        console.
 */
public class ConsoleOutput {
	/**
	 * @brief Represents the accumulated output for the ConsoleOutput class.
	 *
	 *        This variable stores the accumulated output as a string.
	 */
	private static String output = "";

	/**
	 * @brief Prints the specified message.
	 * @param message The message to be printed.
	 */
	public static void print(String message) {
		output += message;
	}

	/**
	 * @brief Returns the accumulated output.
	 * @return The accumulated output.
	 */
	public static String getOutput() {
		return output;
	}
}
