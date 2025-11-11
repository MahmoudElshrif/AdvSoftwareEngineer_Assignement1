package src.Interfaces;

import src.Classes.Order;

public interface Notifier {

	void notifyObservers(Order order);

	void addObserver(Observer o);

	void removeObserver(Observer o);

}