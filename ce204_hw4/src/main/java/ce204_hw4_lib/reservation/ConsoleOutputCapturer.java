/**
  @file ConsoleOutputCapturer.java
  @brief This package contains classes related to reservations.
 */
/**
@package ce204_hw4_lib.reservation
@brief ce204_hw4_lib.reservation package contains all the classes and files related to the Rent Car App.
*/

package ce204_hw4_lib.reservation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 
 * @brief A utility class for capturing console output.
 * @class ConsoleOutputCapturer
 */
public class ConsoleOutputCapturer {
	/**
	 * @brief Represents the ByteArrayOutputStream used for capturing console
	 *        output.
	 *
	 *        This variable stores the ByteArrayOutputStream instance that is used
	 *        to capture the console output.
	 */
	private ByteArrayOutputStream outputStream;
	/**
	 * @brief Represents the original PrintStream.
	 *
	 *        This variable stores the original PrintStream instance before it is
	 *        replaced with the custom PrintStream.
	 */
	private PrintStream originalPrintStream;
	/**
	 * @brief Represents the custom PrintStream.
	 *
	 *        This variable stores the custom PrintStream instance that is used to
	 *        redirect the console output to the ByteArrayOutputStream.
	 */
	private PrintStream customPrintStream;

	/**
	 * @brief Starts capturing console output.
	 */
	public void start() {

		outputStream = new ByteArrayOutputStream();
		originalPrintStream = System.out;
		customPrintStream = new PrintStream(outputStream);
		System.setOut(customPrintStream);
	}

	/**
	 * @brief Stops capturing console output.
	 */
	public void stop() {
		System.out.flush();
		System.setOut(originalPrintStream);
		customPrintStream.close();
	}

	/**
	 * @brief Gets the captured console output as a string.
	 * @return The captured console output.
	 */
	public String getOutput() {
		return outputStream.toString().trim();
	}
}
