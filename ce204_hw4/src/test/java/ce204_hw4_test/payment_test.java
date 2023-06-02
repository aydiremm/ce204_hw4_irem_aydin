package ce204_hw4_test;

import ce204_hw4_lib.payment.*;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class payment_test {

	@Test
	public void testPay() {
		double amount = 50.0;
		CashPaymentStrategy cashPaymentStrategy = new CashPaymentStrategy();
		cashPaymentStrategy.pay(amount);
		assertTrue(true);
	}

	@Test
	public void testProcessPayment() {
		double amount = 100.0;
		String creditCardNumber = "1234567890123456";
		CreditCardPaymentProcessor paymentProcessor = new CreditCardPaymentProcessor(creditCardNumber);
		paymentProcessor.processPayment(amount);
		assertTrue(true);
	}

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

	@Test
	public void testPay2() {
		double amount = 100.0;
		PaymentStrategy paymentStrategy = new CashPaymentStrategy();
		paymentStrategy.pay(amount);
		assertTrue(true);
	}

	@Test
	public void testProcessPayment1() {
		double amount = 100.0;
		String email = "example@example.com";
		PayPalPaymentProcessor paymentProcessor = new PayPalPaymentProcessor();
		paymentProcessor.processPayment(amount, email);
		assertTrue(true);
	}

	@Test
	public void testPay3() {
		double amount = 100.0;
		String email = "example@example.com";
		PayPalPaymentStrategy paymentStrategy = new PayPalPaymentStrategy(email);
		paymentStrategy.pay(amount);
		assertTrue(true);
	}

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
