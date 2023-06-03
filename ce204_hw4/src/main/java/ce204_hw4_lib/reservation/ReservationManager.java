/**
  @file ReservationManager.java
  @brief This package contains classes related to reservations.
 */
/**
@package ce204_hw4_lib.reservation
@brief ce204_hw4_lib.reservation package contains all the classes and files related to the Rent Car App.
*/


package ce204_hw4_lib.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief The ReservationManager class manages reservations and notifies
 *        registered observers of changes.
 */
public class ReservationManager implements Subject {
	/**
	 * @brief Represents a list of observers.
	 *
	 * This variable stores a List of Observer objects that are interested in receiving updates.
	 */
  private List<Observer> observers;
  /**
   * @brief Represents the upcoming reservation.
   *
   * This variable stores a String representing the details of the upcoming reservation.
   */
  private String upcomingReservation;

  /**
   * @brief Constructs a new ReservationManager object.
   */
  public ReservationManager() {
    observers = new ArrayList<>();
  }

  /**
   * @brief Returns the list of observers.
   *
   * @return The list of observers.
   */
  public List<Observer> getObservers() {
    return observers;
  }

  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

  /**
   * @brief Sets the upcoming reservation and notifies the observers.
   * @param reservation The upcoming reservation to set.
   */
  public void setReservation(String reservation) {
    upcomingReservation = reservation;
    notifyObservers("Upcoming reservation: " + reservation);
  }
}
