/**
  @file PayPalPaymentProcessor.java
  @brief Contains classes related to payment processing.
 */

/**
@package ce204_hw4_lib.payment
@brief The ce204_hw4_lib.payment package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_lib.payment;

/**
 * @class PayPalPaymentProcessor
 * @brief This class provides a method to process payments using the PayPal
 *        payment system.
 */
public class PayPalPaymentProcessor {

	/**
	 * @brief Processes a payment using the PayPal payment system.
	 *
	 *        This method takes in the payment amount and the customer's email
	 *        address and performs the necessary steps to process the payment using
	 *        PayPal.
	 *
	 * @param amount The amount to be paid.
	 * @param email  The customer's email address associated with the payment.
	 *
	 * 
	 */
	public void processPayment(double amount, String email) {
		// Code to process PayPal payment goes here
		System.out.println("Processing PayPal payment...");
		System.out.println("Amount: $" + amount);
		System.out.println("Email: " + email);
		System.out.println("Payment processed successfully!");
	}
}
