package src;

import java.util.Scanner;
import java.util.List;

import src.Classes.*;
import src.Classes.Menus.*;
import src.Classes.Payments.*;
import src.Enumeration.OrderType;
import src.Interfaces.MenuFactory;
import src.Interfaces.PaymentStrategy;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static User currentUser;
	private static Order currentOrder;
	private static BillingGenerator billingGenerator = new BillingGenerator();
	private static OrderManager orderManager = new OrderManager();
	private static UserOrderObserver userOrderObserver = new UserOrderObserver();

	public static void main(String args[]) {
		// Step 1: Ask for username
		System.out.println("===== Welcome to Restaurant Order System =====");
		currentUser = getUserInput();

		// Step 2: Main menu loop
		boolean running = true;
		while (running) {
			System.out.println("\n===== Main Menu =====");
			System.out.println("1. Browse Menu & Order");
			System.out.println("2. Add Addon to Item");
			System.out.println("3. Proceed to Payment");
			System.out.println("4. View Order History");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			String choice = scanner.nextLine().trim();

			switch (choice) {
				case "1":
					browseMenuAndOrder();
					break;
				case "2":
					addAddonToItem();
					break;
				case "3":
					proceedToPayment();
					break;
				case "4":
					viewOrderHistory();
					break;
				case "5":
					running = false;
					System.out.println("Thank you for using our Restaurant! Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}

		scanner.close();
	}

	// Step 1: Get user information
	private static User getUserInput() {
		System.out.print("Enter your username: ");
		String userName = scanner.nextLine().trim();
		User user = new User(userName, "");
		userOrderObserver.setUser(user);
		return user;
	}

	// Step 2: Browse menu and add items to order
	private static void browseMenuAndOrder() {
		// Create a new order if one doesn't exist
		if (currentOrder == null) {
			System.out.println("\n===== Select Order Type =====");
			System.out.println("1. Dine In");
			System.out.println("2. Takeaway");
			System.out.println("3. Delivery");
			System.out.print("Enter your choice: ");
			String orderTypeChoice = scanner.nextLine().trim();

			OrderType orderType = OrderType.DINE_IN;
			switch (orderTypeChoice) {
				case "1":
					orderType = OrderType.DINE_IN;
					break;
				case "2":
					orderType = OrderType.TAKEAWAY;
					break;
				case "3":
					orderType = OrderType.DELIVERY;
					break;
				default:
					System.out.println("Invalid choice. Defaulting to Dine In.");
			}

			currentOrder = new Order(currentUser, orderType);
		}

		// Select menu type
		System.out.println("\n===== Select Menu Type =====");
		System.out.println("1. Kids Menu");
		System.out.println("2. Vegetarian Menu");
		System.out.println("3. Non-Vegetarian Menu");
		System.out.print("Enter your choice: ");

		String menuChoice = scanner.nextLine().trim();
		MenuFactory menuFactory = null;

		switch (menuChoice) {
			case "1":
				menuFactory = new KidsMenuFactory();
				break;
			case "2":
				menuFactory = new VegetarianMenuFactory();
				break;
			case "3":
				menuFactory = new NonVegetarianMenuFactory();
				break;
			default:
				System.out.println("Invalid choice.");
				return;
		}

		// Display menu and get items
		Menu menu = menuFactory.getMenu();
		System.out.println("\n===== Menu Items =====");
		List<MenuItem> items = menu.getItems();

		for (int i = 0; i < items.size(); i++) {
			System.out.println((i + 1) + ". " + items.get(i).getDetails());
			System.out.println("-----------------------");
		}

		System.out.print("\nEnter item number to add to order (0 to skip): ");
		String itemChoice = scanner.nextLine().trim();

		try {
			int itemIndex = Integer.parseInt(itemChoice) - 1;
			if (itemIndex >= 0 && itemIndex < items.size()) {
				MenuItem selectedItem = items.get(itemIndex);
				OrderItem orderItem = new OrderItem(selectedItem);
				currentOrder.addItem(orderItem);
				System.out.println(selectedItem.getName() + " added to order!");
			} else if (!itemChoice.equals("0")) {
				System.out.println("Invalid item number.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
		}
	}

	// Step 3: Add addon to an item in the current order
	private static void addAddonToItem() {
		if (currentOrder == null || currentOrder.getItems().isEmpty()) {
			System.out.println("No items in current order. Please add items first.");
			return;
		}

		// Display current order items
		System.out.println("\n===== Current Order Items =====");
		List<OrderItem> orderItems = currentOrder.getItems();

		for (int i = 0; i < orderItems.size(); i++) {
			System.out.println((i + 1) + ". " + orderItems.get(i).getItem().getName());
		}

		System.out.print("Select item number to add addon: ");
		String itemChoice = scanner.nextLine().trim();

		try {
			int itemIndex = Integer.parseInt(itemChoice) - 1;
			if (itemIndex >= 0 && itemIndex < orderItems.size()) {
				OrderItem selectedOrderItem = orderItems.get(itemIndex);

				// Display available addons
				Menu menu = new Menu(List.of()); // Create dummy menu to access addons
				List<Addon> addons = menu.getAddons();

				System.out.println("\n===== Available Addons =====");
				for (int i = 0; i < addons.size(); i++) {
					System.out.println((i + 1) + ". " + addons.get(i).getName() + " - $"
							+ addons.get(i).getPrice());
				}

				System.out.print("Select addon number (0 to skip): ");
				String addonChoice = scanner.nextLine().trim();

				try {
					int addonIndex = Integer.parseInt(addonChoice) - 1;
					if (addonIndex >= 0 && addonIndex < addons.size()) {
						Addon selectedAddon = addons.get(addonIndex);
						selectedOrderItem.addAddon(selectedAddon);
						System.out
								.println("✓ " + selectedAddon.getName() + " added to "
										+ selectedOrderItem.getItem().getName() + "!");
					} else if (!addonChoice.equals("0")) {
						System.out.println("Invalid addon number.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input.");
				}
			} else {
				System.out.println("Invalid item number.");
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
		}
	}

	// Step 4: Process payment
	private static void proceedToPayment() {
		if (currentOrder == null || currentOrder.getItems().isEmpty()) {
			System.out.println("No items in current order. Please add items first.");
			return;
		}

		// Display bill
		System.out.println("\n===== Order Summary =====");
		String bill = billingGenerator.generateBill(currentOrder);
		System.out.println(bill);

		// Select payment method
		System.out.println("\n===== Payment Methods =====");
		System.out.println("1. Cash");
		System.out.println("2. Credit Card");
		System.out.println("3. Mobile Wallet");
		System.out.print("Select payment method: ");

		String paymentChoice = scanner.nextLine().trim();
		PaymentStrategy paymentStrategy = null;

		switch (paymentChoice) {
			case "1":
				paymentStrategy = new CashPayment();
				break;
			case "2":
				paymentStrategy = new CreditCardPayment();
				break;
			case "3":
				paymentStrategy = new MobileWalletPayment();
				break;
			default:
				System.out.println("Invalid payment method.");
				return;
		}

		// Calculate total
		double total = 0;
		PricingService price = new PricingService();

		total = price.calculateTotal(currentOrder);
		double tax = price.calculteTaxes(total);
		double finalTotal = total + tax;

		// Process payment
		String paymentConfirmation = billingGenerator.processPayment(paymentStrategy, finalTotal);
		System.out.println("\n" + paymentConfirmation);

		// Add order to user's order history
		orderManager.placeOrder(currentOrder);

		System.out.println("Order placed successfully!");
		System.out.println("Order ID: " + currentOrder.getOrderId());

		// Reset current order
		currentOrder = null;

		// Ask if they want to place another order
		System.out.print("\nWould you like to place another order? (yes/no): ");
		String continueChoice = scanner.nextLine().trim().toLowerCase();
		if (!continueChoice.equals("yes") && !continueChoice.equals("y")) {
			System.out.println("Thank you for your order!");
		}
	}

	// Step 5: View order history
	private static void viewOrderHistory() {
		List<Order> orders = currentUser.getOrders();

		if (orders.isEmpty()) {
			System.out.println("No orders yet.");
			return;
		}

		System.out.println("\n===== Order History =====");
		for (Order order : orders) {
			System.out.println("Order ID: " + order.getOrderId());
			System.out.println("Date: " + order.getCreatedAt());
			System.out.println("Order Type: " + order.getOrderType());
			System.out.println("Items: ");
			for (OrderItem item : order.getItems()) {
				System.out.println("  - " + item.getItem().getName() + " $" + item.getItem().getPrice() + " x"
						+ item.getQuantity());
				for (Addon addon : item.getAddons()) {
					System.out.println("     * " + addon.getName() + " $" + addon.getPrice());
				}
			}
			double total = 0;
			for (OrderItem item : order.getItems()) {
				total += item.calculateItemTotal();
			}
			System.out.println("Total: $" + String.format("%.2f", total));
			System.out.println("---");
		}
	}
}
