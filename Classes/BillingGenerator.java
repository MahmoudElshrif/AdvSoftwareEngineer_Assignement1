import java.util.List;

import interfaces.PaymentStrategy;

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
