package src.Interfaces;

public interface PaymentStrategy {
	void pay(double amount);

	String getType();
}
