/**
  @file Observer.java
  @brief This package contains classes related to reservations.
 */
/**
@package ce204_hw4_lib.reservation
@brief ce204_hw4_lib.reservation package contains all the classes and files related to the Rent Car App.
*/

package ce204_hw4_lib.reservation;

/**
 * @name Observer
 * @brief The Observer interface defines the contract for objects that observe
 *        changes in the ReservationManager.
 */
public interface Observer {
	/**
	 * @brief This method is called by the ReservationManager to notify the observer
	 *        about updates.
	 * @param message The message containing the update information.
	 */
	void update(String message);
}
