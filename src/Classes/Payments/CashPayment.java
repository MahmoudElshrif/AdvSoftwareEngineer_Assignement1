package src.Classes.Payments;

import src.Interfaces.PaymentStrategy;

public class CashPayment implements PaymentStrategy {

	@Override
	public void pay(double amount) {
	}

	@Override
	public String getType() {
		return "cash";
	}

}
