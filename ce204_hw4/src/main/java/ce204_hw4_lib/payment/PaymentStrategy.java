/**
  @file PaymentStrategy.java
  @brief Contains classes related to payment processing.
 */
/**
@package ce204_hw4_lib.payment
@brief The ce204_hw4_lib.payment package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_lib.payment;

/**
 * @class PaymentStrategy
 * @brief The PaymentStrategy interface represents a payment strategy.
 *
 *        It provides a common interface for implementing different payment
 *        strategies.
 */
public interface PaymentStrategy {

	/**
	 * @brief Makes a payment for the specified amount.
	 *
	 *        This method is implemented by concrete payment strategies to perform
	 *        the payment process.
	 *
	 * @param amount the amount to be paid
	 *
	 * 
	 */
	void pay(double amount);
}
