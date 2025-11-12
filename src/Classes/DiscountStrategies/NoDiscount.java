package src.Classes.DiscountStrategies;

import src.Interfaces.DiscountStrategy;

public class NoDiscount implements DiscountStrategy {

	@Override
	public double applyDiscount(double amount) {
		return amount;
	}

	@Override
	public String getDisountDetails() {
		return "";
	}
}
