package Classes;
import java.util.List;
import java.util.ArrayList;
public class User {
    private int userId;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private List<Order> orders;

    public User(int userId, String userName, String password, String phone, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order newOrder) {
        this.orders.add(newOrder);
    }

    public List<Order> getOrders() {
        return this.orders;
    }
}
