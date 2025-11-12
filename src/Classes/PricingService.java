package src.Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PricingService {
	TaxService taxService = new TaxService();

	public double calculateTotal(Order order) {
		double total = 0;
		for (OrderItem oi : order.getItems()) {
			double price = oi.calculateItemTotal();

			total += price;
		}
		// total += taxService.calculateTax(total);
		return BigDecimal.valueOf(total).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

	public double calculteTaxes(double amount) {
		return BigDecimal.valueOf(taxService.calculateTax(amount)).setScale(3, RoundingMode.HALF_UP).doubleValue();

	}
}
