/**
  @file PaymentProcessor.java
  @brief Contains classes related to payment processing.
 */
/**
@package ce204_hw4_lib.payment
@brief The ce204_hw4_lib.payment package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_lib.payment;

/**
 * @class PaymentProcessor
 * @brief The PaymentProcessor interface provides a contract for processing
 *        payments.
 */
public interface PaymentProcessor {

	/**
	 * @brief Processes a payment for the specified amount.
	 *
	 *        This method is responsible for processing a payment for the specified
	 *        amount. Implementations of this interface should define their own
	 *        logic for processing payments.
	 *
	 * @param amount The amount to be processed.
	 */
	void processPayment(double amount);
}
