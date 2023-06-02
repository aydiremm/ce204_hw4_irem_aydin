package ce204_hw4_lib.reservation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 * @name ConsoleOutputCapturer
 * @brief A utility class for capturing console output.
 */
public class ConsoleOutputCapturer {
    private ByteArrayOutputStream outputStream;
    private PrintStream originalPrintStream;
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
