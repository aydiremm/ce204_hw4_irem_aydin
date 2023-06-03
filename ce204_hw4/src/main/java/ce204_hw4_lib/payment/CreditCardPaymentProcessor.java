/**
  @file CreditCardPaymentProcessor.java
  @brief Contains classes related to payment processing and strategies.
 */
/**
@package ce204_hw4_lib.payment
@brief The ce204_hw4_lib.payment package contains all the classes and files related to the Rent Car App.
*/

package ce204_hw4_lib.payment;

/**
 * @class CreditCardPaymentProcessor
 * @brief A class for processing credit card payments.
 *
 * This class implements the PaymentProcessor interface and provides functionality
 * to process credit card payments. It takes a credit card number as a parameter
 * and uses it to process the payment.
 */
public class CreditCardPaymentProcessor implements PaymentProcessor {
	/**
	 * @brief The credit card number associated with the account.
	 */
	private String creditCardNumber;


  /**
   * @brief Constructs a CreditCardPaymentProcessor object with the specified credit card number.
   * @param The credit card number to be used for processing payments.
   */
  public CreditCardPaymentProcessor(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }



  /**
   * @brief Processes a payment using the credit card.
   * @param amount The amount to be paid.
   *
   * This method processes the payment using the credit card number provided during
   * object construction. It prints the amount being paid and a success message
   * indicating that the payment has been processed successfully.
   */

  @Override
  public void processPayment(double amount) {
    // Code to process credit card payment goes here
    System.out.println("------------------------------------------------");
    System.out.println("Processing credit card payment...");
    System.out.println("\nAmount: $" + amount);
    System.out.println("\nPayment processed successfully!");
  }
}