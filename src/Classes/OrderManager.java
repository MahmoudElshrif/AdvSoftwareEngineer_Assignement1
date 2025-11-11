package src.Classes;

import src.Interfaces.Notifier;
import src.Interfaces.Observer;
import java.util.List;

public class OrderManager implements Notifier {
	private List<Observer> observers;

	public void placeOrder() {

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'addObserver'");
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'removeObserver'");
	}
}
