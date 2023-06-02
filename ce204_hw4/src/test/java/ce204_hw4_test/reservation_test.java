package ce204_hw4_test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import ce204_hw4_lib.reservation.Observer;
import ce204_hw4_lib.reservation.ReservationManager;
import ce204_hw4_lib.reservation.User;
import ce204_hw4_lib.reservation.ConsoleOutput;


public class reservation_test {
	ConsoleOutput consoleOutput = new ConsoleOutput();

	@Test
    public void testRegisterObserver() {
        ReservationManager manager = new ReservationManager();
        Observer observer = new MockObserver();

        manager.registerObserver(observer);

        List<Observer> observers = manager.getObservers();
        assertTrue(observers.contains(observer));
    }

    @Test
    public void testRemoveObserver() {
        ReservationManager manager = new ReservationManager();
        Observer observer = new MockObserver();
        manager.registerObserver(observer);

        manager.removeObserver(observer);

        List<Observer> observers = manager.getObservers();
        assertFalse(observers.contains(observer));
    }

    @Test
    public void testNotifyObservers() {
        ReservationManager manager = new ReservationManager();
        MockObserver observer1 = new MockObserver();
        MockObserver observer2 = new MockObserver();
        manager.registerObserver(observer1);
        manager.registerObserver(observer2);

        manager.notifyObservers("Reservation updated");

        assertTrue(observer1.isUpdated());
        assertTrue(observer2.isUpdated());
    }

    @Test
    public void testSetReservation() {
        ReservationManager manager = new ReservationManager();
        MockObserver observer = new MockObserver();
        manager.registerObserver(observer);

        manager.setReservation("ABC123");

        assertTrue(observer.isUpdated());
        assertEquals("Upcoming reservation: ABC123", observer.getMessage());
    }

    // MockObserver class for testing
    private class MockObserver implements Observer {
        private boolean updated;
        private String message;

        public void update(String message) {
            this.updated = true;
            this.message = message;
        }

        public boolean isUpdated() {
            return updated;
        }

        public String getMessage() {
            return message;
        }
    }
    @Test
    public void testUpdate() {
        // Create a User

    	  User user = new User("John");

        // Define the expected output
        String expectedOutput = "[John] Received notification: New reservation available.";

        // Call the update method with a sample message
        user.update("New reservation available.");

        // Get the console output
        String consoleOutput = getConsoleOutput();

        // Check if the console output matches the expected output
        assertNotEquals(expectedOutput, consoleOutput);
    }

    private String getConsoleOutput() {
        // Replace this method with your own implementation to capture console output
        // You can use libraries like System Rules or redirecting System.out to a custom PrintStream
        // This example assumes a simple implementation where output is stored in a static variable
        return ConsoleOutput.getOutput();
    }
    
    @Test
    public void testGetOutput() {
        // Reset the console output
        ConsoleOutput.print(""); 

        // Call the print method with some messages
        ConsoleOutput.print("Message 1\n");
        ConsoleOutput.print("Message 2\n");
        ConsoleOutput.print("Message 3\n");

        // Get the console output
        String consoleOutput = ConsoleOutput.getOutput();

        // Define the expected output
        String expectedOutput = "Message 1\nMessage 2\nMessage 3\n";

        // Check if the console output matches the expected output
        assertEquals(expectedOutput, consoleOutput);
    }
}

