package src.Classes;

import java.util.List;

import src.Interfaces.PaymentStrategy;

public class BillingGenerator {
	PricingService PricingService;
	List<Addon> addOns;

	public String generateBill(Order order) {
		return "";
	}

	public String processPayment(PaymentStrategy paymentStrategy, double amount) {
		return "Charged $" + amount + " using " + paymentStrategy.getType();
	}
}
