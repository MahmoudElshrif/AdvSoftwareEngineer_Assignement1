package src.Interfaces;

public interface Notifier {

	void notifyObservers();

	void addObserver(Observer o);

	void removeObserver(Observer o);

}