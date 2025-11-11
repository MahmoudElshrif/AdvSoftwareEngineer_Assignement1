package src.Classes;

import src.Interfaces.DiscountStrategy;

public class PricingService {
	TaxService TaxService;

	double calculateTotal(Order order) {
		double total = 0;
		for (OrderItem oi : order.getItems()) {
			double price = oi.calculateItemTotal();

			DiscountStrategy disc = DiscountFactory.getStrategy(oi.getItem());

			price = disc.applyDiscount(price);
		}

		return total;
	}
}
