package ce204_hw4_lib.reservation;

/**
 * @brief The Subject interface defines the contract for objects that can be
 *        observed by Observers.
 */

public interface Subject {
	/**
	 * @brief Registers an observer to receive updates from the Subject.
	 * @param observer The observer to register.
	 */
	void registerObserver(Observer observer);

	/**
	 * @brief Unregisters an observer from receiving updates from the Subject.
	 * @param observer The observer to unregister.
	 */
	void removeObserver(Observer observer);

	/**
	 * @brief Notifies all registered observers with the given message.
	 * @param message The message to notify observers with.
	 */
	void notifyObservers(String message);
}
