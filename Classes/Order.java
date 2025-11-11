package Classes;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private int orderId;
    private List<OrderItem> orderItems;
    private User customer;
    private OrderType orderType;
    private OrderStatus orderStatus;
    private LocalDate CreatedAt;


    public void addItem(OrderItem item) {
        this.orderItems.add(item);
    }


    public void removeItem(OrderItem item) {
        this.orderItems.remove(item);
    }

    public void updateStatus(OrderStatus newStatus) {
        this.orderStatus = newStatus;
    }
    


}
