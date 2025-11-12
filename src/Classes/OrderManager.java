package src.Classes;

import src.Interfaces.Notifier;
import src.Interfaces.Observer;
import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Notifier {
	private List<Observer> observers;

	public OrderManager() {
		this.observers = new ArrayList<>();
	}

	public void placeOrder(Order order) {
		notifyObservers(order);
	}

	@Override
	public void notifyObservers(Order order) {
		for (Observer o : observers) {
			o.update(order);
		}
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
}
