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
	private List<Observer> observers;
	private String upcomingReservation;

	/**
	 * @brief Constructs a new ReservationManager object.
	 */
	public ReservationManager() {
		observers = new ArrayList<>();
	}

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
