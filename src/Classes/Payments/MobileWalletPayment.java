package src.Classes.Payments;

import src.Interfaces.PaymentStrategy;

public class MobileWalletPayment implements PaymentStrategy {

	@Override
	public void pay(double amount) {
	}

	@Override
	public String getType() {
		return "mobile wallet";
	}

}
