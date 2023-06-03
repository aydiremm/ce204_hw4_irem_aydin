/**
 * @file payment_test.java
 * @brief This file contains the unit tests for the payment module.
 *        It tests different payment strategies and processors.
 */

package ce204_hw4_test;

import ce204_hw4_lib.payment.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;


/**
 * @class payment_test
 * @brief This class contains the unit tests for the payment module.
 */
public class payment_test {


  /**
     * @brief Tests the payment using cash payment strategy.
     * @details It creates an instance of the CashPaymentStrategy and calls the pay() method with a specified amount.
     *          The test passes if no exceptions are thrown.
     */
  @Test
  public void testPay() {
    double amount = 50.0;
    CashPaymentStrategy cashPaymentStrategy = new CashPaymentStrategy();
    cashPaymentStrategy.pay(amount);
    assertTrue(true);
  }


  /**
     * @brief Tests the payment processing using credit card payment processor.
     * @details It creates an instance of the CreditCardPaymentProcessor with a credit card number,
     *          and then calls the processPayment() method with a specified amount.
     *          The test passes if no exceptions are thrown.
     */
  @Test
  public void testProcessPayment() {
    double amount = 100.0;
    String creditCardNumber = "1234567890123456";
    CreditCardPaymentProcessor paymentProcessor = new CreditCardPaymentProcessor(creditCardNumber);
    paymentProcessor.processPayment(amount);
    assertTrue(true);
  }


  /**
     * @brief Tests the payment using credit card payment strategy.
     * @details It creates an instance of the CreditCardPaymentStrategy with a credit card number,
     *          expiration date, and CVV. Then, it calls the pay() method with a specified amount.
     *          The test passes if no exceptions are thrown.
     * @throws None
     */
  @Test
  public void testPay1() {
    double amount = 100.0;
    String cardNumber = "1234567890123456";
    String expirationDate = "12/25";
    String cvv = "123";
    CreditCardPaymentStrategy paymentStrategy = new CreditCardPaymentStrategy(cardNumber, expirationDate, cvv);
    paymentStrategy.pay(amount);
    assertTrue(true);
  }



  /**
     * @brief Tests the payment using cash payment strategy through a generic payment strategy.
     * @details It creates an instance of the CashPaymentStrategy and assigns it to a PaymentStrategy variable.
     *          Then, it calls the pay() method of the PaymentStrategy with a specified amount.
     *          The test passes if no exceptions are thrown.
     */
  @Test
  public void testPay2() {
    double amount = 100.0;
    PaymentStrategy paymentStrategy = new CashPaymentStrategy();
    paymentStrategy.pay(amount);
    assertTrue(true);
  }


  /**
     * @brief Tests the payment processing using PayPal payment processor.
     * @details It creates an instance of the PayPalPaymentProcessor and calls the processPayment() method
     *with a specified amount and email. The test passes if no exceptions are thrown.
     */
  @Test
  public void testProcessPayment1() {
    double amount = 100.0;
    String email = "example@example.com";
    PayPalPaymentProcessor paymentProcessor = new PayPalPaymentProcessor();
    paymentProcessor.processPayment(amount, email);
    assertTrue(true);
  }


  /**
     * @brief Tests the payment using PayPal payment strategy.
     * @details It creates an instance of the PayPalPaymentStrategy with an email,
     *          and then calls the pay() method with a specified amount.
     *          The test passes if no exceptions are thrown.
     */
  @Test
  public void testPay3() {
    double amount = 100.0;
    String email = "example@example.com";
    PayPalPaymentStrategy paymentStrategy = new PayPalPaymentStrategy(email);
    paymentStrategy.pay(amount);
    assertTrue(true);
  }


  /**
   * @brief Tests the payment processing using a custom payment strategy.
   * @details It creates an anonymous class implementing the PaymentStrategy interface,
   *          which has an empty pay() method. Then, it creates a Reservation object with the custom payment strategy,
   *          and calls the processPayment() method with a specified amount.
   *          The test passes if no exceptions are thrown.
   * @throws None
   */
  @Test
  public void testProcessPayment2() {
    double amount = 100.0;
    PaymentStrategy paymentStrategy = new PaymentStrategy() {
      @Override
      public void pay(double amount) {
      }
    };
    Reservation reservation = new Reservation(paymentStrategy);
    reservation.processPayment(amount);
    assertTrue(true);
  }
}
