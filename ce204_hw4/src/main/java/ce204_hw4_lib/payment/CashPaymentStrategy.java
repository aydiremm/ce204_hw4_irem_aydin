package ce204_hw4_lib.payment;



/**
 * @class CashPaymentStrategy
 * @brief Represents a payment strategy for cash payments.
 */
public class CashPaymentStrategy implements PaymentStrategy {
	
	/**
     * @brief Performs a cash payment.
     * @param amount The amount to be paid.
     */
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " in cash");
        // Additional code for processing cash payment
    }
}
