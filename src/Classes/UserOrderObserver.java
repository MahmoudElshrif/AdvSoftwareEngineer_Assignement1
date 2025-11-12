package src.Classes;

import src.Interfaces.Observer;

public class UserOrderObserver implements Observer {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void update(Order o) {
		user.addOrder(o);
	}
}
