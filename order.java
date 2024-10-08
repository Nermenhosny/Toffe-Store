import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class order implements orderInterface {
    private List<OrderItem> orderItems;
   private ArrayList<orderDetails> orderDetails ;
    private List<order> orders;

    private int orderCode;
    private int customerId;
    private String deliveryAddress;
    private float taxPercentage;
    private OrderStatus status;
    private Date orderDate;
    private Date deliveryDate;
    private  double orderTotal;


    public order(int orderCode, int customerId, String deliveryAddress) {
        this.orderCode = orderCode;
        this.customerId = customerId;
        this.deliveryAddress = deliveryAddress;
        this.status = OrderStatus.opened;
        this.orderDate = new Date();
        this.deliveryDate = null;
        this.orderDetails = new ArrayList<orderDetails>();
        this.orders = new ArrayList<>();

    }
    public List<OrderItem> getOrderItems() {
        List<OrderItem> items = new ArrayList<>();
        for (orderDetails details : orderDetails) {
            items.add(new OrderItem( details.getOrderCode(),details.getItemId(), details.getQuantity()));
        }
        return items;
    }
    public void addOrderDetail(Item item, int quantity) {
        if (status == OrderStatus.opened) {
            if (item != null && quantity > 0) {
                orderDetails.add(new orderDetails(item, quantity));
                System.out.println("Order detail added: " + item.getName() + " x " + quantity);
            } else {
                System.out.println("Invalid product or quantity.");
            }
        } else {
            System.out.println("Cannot add items to a closed order.");
        }
    }
    public double calculateOrderTotal() {
        orderTotal = 0;
        Iterator <orderDetails> i = orderDetails.iterator();
        while (i.hasNext())
            orderTotal += (i.next()).getTotal(taxPercentage);
        return orderTotal;
    }

    public int getCustomerId() {

        return this.customerId;
    }
    public int getOrderCode() {

        return this.orderCode;
    }
    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public boolean reorderOrder(int orderCode) {
        return false;
    }

    @Override
    public OrderStatus getStatus() {
        return status;
    }
    public  OrderStatus setStatus(OrderStatus status) {
        this.status = status;
        return status;
    }

//__________________________________________
    @Override
    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public int getItemId() {
        return 0;
    }

    @Override
    public int getQuantity() {
        return 0;
    }


    public List<orderDetails> getOrderDetails(int orderCode) {
        List<orderDetails> result = new ArrayList<>();
        for (orderDetails details : orderDetails) {
            if (details.getOrderCode() == orderCode) {
                result.addAll(details.getDetailsList(orderCode));
            }
        }
        return result;
    }
    public void createOrder(int orderCode, int customerId, String deliveryAddress) {
        order or = new order(orderCode, customerId, deliveryAddress);
        orders.add(or);
    }

    public void addItemsToOrder(int orderCode, int itemId, int quantity) {
        // Find the order with the specified code
        order order = findOrder(orderCode);
        if (order != null) {
            // Create a new order item and add it to the order
            OrderItem item = new OrderItem(orderCode,itemId, quantity);
            order.getOrderItems().add(item);
        }
    }
    public boolean checkOrderValid(int orderCode) {
        order order = findOrder(orderCode);
        if (order == null) {
            System.out.println("Order with "+orderCode+" not found");
            return false;
        }
        int totalQuantity = 0;
        for (orderDetails details : order.getOrderDetails(orderCode)) {
            totalQuantity += details.getQuantity();

        }

        if (totalQuantity > 50) {
            System.out.println("Total quantity exceeds limit of 50");
            return false;
        }
        return true;
    }
    public void cancelOrder(int orderCode, Date orderDate, Date cancelDate) {
        order order = findOrder(orderCode);
        if (order != null) {
            long timeDiff = cancelDate.getTime() - orderDate.getTime();
            long hoursDiff = TimeUnit.MILLISECONDS.toHours(timeDiff);
            if (hoursDiff < 24) {
                order.setStatus(OrderStatus.CANCELLED);
                System.out.println("Order " + orderCode + " has been cancelled.");
            } else {
                System.out.println("Cannot cancel order " + orderCode + " as it has been more than 24 hours since it was created.");
            }
        } else {
            System.out.println("Order " + orderCode + " not found.");
        }
    }
    private order findOrder(int orderCode) {
        for (order order : orders) {
            if (order.getOrderCode() == orderCode) {
                return order;
            }
        }
        return null;
    }
}
class OrderItem {
    private int orderCode;
    private int itemId;
    private int quantity;

    public OrderItem(int orderCode, int itemId, int quantity) {
        this.orderCode = orderCode;
        this.itemId = itemId;
        this.quantity = quantity;
    }
}

enum OrderStatus {
    NEW,
    PLACED,
    opened,
    closed,
    CANCELLED,

}

