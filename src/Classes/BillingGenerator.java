package src.Classes;

import src.Interfaces.DiscountStrategy;
import src.Interfaces.PaymentStrategy;

public class BillingGenerator {
	PricingService pricingService;

	public BillingGenerator() {
		pricingService = new PricingService();
	}

	public String generateBill(Order order) {
		String bill = "";
		for (OrderItem i : order.getItems()) {
			DiscountStrategy disc = DiscountFactory.getStrategy(i.getItem());
			bill += "-" + i.getItem().getName() + " $" + i.getItem().getPrice() + " x" + i.getQuantity() + "\n";
			if (!disc.getDisountDetails().isEmpty())
				bill += "  " + disc.getDisountDetails() + " $" + disc.applyDiscount(i.getItem().getPrice()) + "\n";
			for (Addon addon : i.getAddons()) {
				bill += "    *" + addon.getName() + " $" + addon.getPrice()  + "\n";
			}

			bill += "-- $" + i.calculateItemTotal() + "\n";
		}

		bill += "\n----------\n\n";

		double total = pricingService.calculateTotal(order);
		bill += "Total: $" + total + "\n";

		bill += "Tax: $" + pricingService.calculteTaxes(total) + "\n";

		bill += "Final Total: $" + (total + pricingService.calculteTaxes(total)) + '\n';

		return bill;
	}

	public String processPayment(PaymentStrategy paymentStrategy, double amount) {
		return "Charged $" + amount + " using " + paymentStrategy.getType();
	}
}
