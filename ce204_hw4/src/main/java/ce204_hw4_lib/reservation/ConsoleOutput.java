package ce204_hw4_lib.reservation;


/**
 * @name ConsoleOutput
 * @brief This file contains the definition of the ConsoleOutput class.
 */

/**
 * @brief The ConsoleOutput class provides a mechanism to print messages to the console.
 */
public class ConsoleOutput {
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
