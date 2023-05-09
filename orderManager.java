import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Hashtable;
import java.util.*;
public class orderManager {
    private List<order> orders;
    private List<orderDetails> orderDetails;
    private Hashtable<String, Item> Items;
    public orderManager() {
        this.orders = new ArrayList<>();
        this.orderDetails = new ArrayList<>();
    }

    public void createOrder(int orderCode, int customerId, String deliveryAddress) {
        order or = new order(orderCode, customerId, deliveryAddress);
        orders.add(or);
    }
    //__________________________________________________________________________________________________________________
//    public void additem (int itemid,String name,double unitPrice) {
//        Items.put(String.valueOf(itemid), new Item(itemid, name, unitPrice));
//    }
//    public Hashtable<String, Item> getitems () {
//        return Items;
//    }
//    public void addItemToOrder(int orderCode, int itemId, int quantity) {
//        order order = findOrder(orderCode);
//        if (order != null) {
//            order.addOrderDetail(Items.get(itemId), quantity);
//        } else {
//            System.out.println("Order " + orderCode + " not found.");
//        }
//    }
    //__________________________________________________________________________________________________________________
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
                System.out.println("Order not found");
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
    public void cancelOrder(int orderCode, Date orderDate, Date cancelDate)
    {
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
