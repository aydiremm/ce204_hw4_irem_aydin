package ce204_hw4_lib.reservation;

/**
 * @name User
 * @brief User class implementing the Observer interface.
 *
 *        This class represents a user who receives notifications as an
 *        observer. It provides a method to update and print the received
 *        notification.
 */
public class User implements Observer {
	private String name;

	/**
	 * @brief Constructs a User object with the given name.
	 *
	 * @param name The name of the user.
	 */
	public User(String name) {
		this.name = name;
	}

	/**
	 * @brief Updates the user with a new notification message.
	 *
	 *        This method is called when a notification is received by the user. It
	 *        prints the received notification along with the user's name.
	 *
	 * @param message The notification message.
	 */
	public void update(String message) {
		System.out.println("[" + name + "] Received notification: " + message);
	}
}
