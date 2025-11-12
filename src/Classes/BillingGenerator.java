package src.Classes;

import src.Interfaces.PaymentStrategy;

public class BillingGenerator {
	PricingService pricingService;

	public BillingGenerator() {
		pricingService = new PricingService();
	}

	public String generateBill(Order order) {
		String bill = "";
		for (OrderItem i : order.getItems()) {
			bill += "-" + i.getItem().getName() + " $" + i.getItem().getPrice() + " x" + i.getQuantity() + "\n";
			for (Addon addon : i.getAddons()) {
				bill += "---" + addon.getName() + " $" +addon.getPrice() + "\n";
			}
		}
		System.out.println("tax: 10% applied");

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
