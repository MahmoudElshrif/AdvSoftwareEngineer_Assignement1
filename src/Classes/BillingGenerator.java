package src.Classes;

import java.util.List;

import src.Interfaces.PaymentStrategy;

public class BillingGenerator {
	PricingService pricingService;
	List<Addon> addOns;

	public String generateBill(Order order) {
		String bill = "";
		for (OrderItem i : order.getItems()) {
			bill += "-" + i.getItem().getName() + " $" + i.getItem().getPrice() + " x" + i.getQuanitity() + "\n";
			for (Addon addon : i.getAddon()) {
				bill += "---" + addon.getName() + "\n";
			}
		}

		bill += "\n----------\n\n";

		double total = pricingService.calculateTotal(order);
		bill += total + "\n";

		bill += "Tax: " + pricingService.calculteTaxes(total) + "\n";

		return bill;
	}

	public String processPayment(PaymentStrategy paymentStrategy, double amount) {
		return "Charged $" + amount + " using " + paymentStrategy.getType();
	}
}
