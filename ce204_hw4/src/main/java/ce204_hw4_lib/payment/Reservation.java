/**
  @file Reservation.java
  @brief Contains classes related to payment processing.
 */
/**
@package ce204_hw4_lib.payment
@brief The ce204_hw4_lib.payment package contains all the classes and files related to the Rent Car App.
*/

package ce204_hw4_lib.payment;

/**
 * @class Reservation
 * @brief Represents a reservation for a payment.
 *
 *        This class encapsulates the logic for processing a payment for a
 *        reservation using a payment strategy defined by the client. The
 *        payment strategy is passed as a parameter during object creation and
 *        can be changed at runtime.
 */
public class Reservation {
	/**
	 * @brief The payment strategy for processing payments.
	 */
	private PaymentStrategy paymentStrategy;

	/**
	 * @brief Constructs a Reservation object with the specified payment strategy.
	 *
	 * @param paymentStrategy The payment strategy to be used for processing
	 *                        payments.
	 */
	public Reservation(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	/**
	 * @brief Processes a payment for the reservation.
	 *
	 *        This method delegates the payment processing to the payment strategy
	 *        provided during object creation.
	 *
	 * @param amount The amount to be paid for the reservation.
	 */
	public void processPayment(double amount) {
		paymentStrategy.pay(amount);
	}
}
