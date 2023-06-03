/**
  @file CreditCardPaymentStrategy.java
  @brief Contains classes related to payment processing.
 */
/**
@package ce204_hw4_lib.payment
@brief The ce204_hw4_lib.payment package contains all the classes and files related to the Rent Car App.
*/
package ce204_hw4_lib.payment;

/**
 * @class CreditCardPaymentStrategy
 * @brief The CreditCardPaymentStrategy class represents a payment strategy for
 *        credit card payments.
 */
public class CreditCardPaymentStrategy implements PaymentStrategy {

	/**
	 * @brief The card number associated with the account.
	 */
	private String cardNumber;
	/**
	 * @brief The expiration date of the card.
	 */
	private String expirationDate;
	/**
	 * @brief The CVV (Card Verification Value) of the card.
	 */
	private String cvv;

	/**
	 * @brief Constructs a CreditCardPaymentStrategy object with the specified card
	 *        number, expiration date, and CVV.
	 *
	 * @param cardNumber     the credit card number
	 * @param expirationDate the expiration date of the credit card
	 * @param cvv            the CVV code of the credit card
	 */
	public CreditCardPaymentStrategy(String cardNumber, String expirationDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	/**
	 * @brief Makes a payment using the credit card payment strategy.
	 *
	 * @param amount the amount to be paid
	 */
	public void pay(double amount) {
		System.out.println("Paying $" + amount + " with Credit Card: " + cardNumber);
		// Additional code for processing credit card payment
	}
}
