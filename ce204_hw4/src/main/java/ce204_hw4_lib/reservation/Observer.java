package ce204_hw4_lib.reservation;

/**
 * @name Observer
 * @brief The Observer interface defines the contract for objects that observe changes in the ReservationManager.
 */
public interface Observer {
	/**
     * @brief This method is called by the ReservationManager to notify the observer about updates.
     * @param message The message containing the update information.
     */
    void update(String message);
}
