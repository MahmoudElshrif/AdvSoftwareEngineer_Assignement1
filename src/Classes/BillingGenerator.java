package src.Classes;

import java.util.List;

import src.Interfaces.PaymentStrategy;

public class BillingGenerator {
	PricingService PricingService;
	PaymentStrategy paymentStrategy;
	List<Addon> addOns;

	public String generateBill(Order order) {
		return "";
	}

	public void processPayment(Order order) {

	}
}
