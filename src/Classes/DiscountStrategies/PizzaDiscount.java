package src.Classes.DiscountStrategies;

import src.Interfaces.DiscountStrategy;

public class PizzaDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount * 0.7;
	}

	@Override
	public String getDisountDetails() {
		return "30% pizza discount applied";
	}
}
