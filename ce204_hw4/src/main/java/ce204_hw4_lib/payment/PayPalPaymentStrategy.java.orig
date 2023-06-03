package ce204_hw4_lib.payment;


/**
 * @name PayPalPaymentStrategy.java
 * @brief Implements the PayPal payment strategy.
 *
 * This class represents a payment strategy that allows making payments using a PayPal account.
 * The payment amount is processed with the specified PayPal account.
 */
public class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    
    /**
     * @brief Constructs a new PayPalPaymentStrategy instance.
     * 
     * This constructor initializes the PayPalPaymentStrategy with the provided email address.
     *
     * @param email The email address associated with the PayPal account.
     */
    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    
    /**
     * @brief Performs the payment using the PayPal account.
     * 
     * This method processes the specified payment amount using the PayPal account associated with this strategy.
     * It prints the payment amount and the PayPal account email address to the console.
     * Additional code for processing the PayPal payment may be included.
     *
     * @param amount The amount to be paid.
     * @retval None
     */
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with PayPal account: " + email);
        // Additional code for processing PayPal payment
    }
}
