import java.util.Date;
import java.util.List;

public interface orderInterface {

    int getCustomerId();

    int getOrderCode();

    String getDeliveryAddress();
    void createOrder(int orderCode, int customerId,String deliveryAddress);

    void addItemsToOrder(int orderCode, int itemId, int quantity);

    boolean checkOrderValid(int orderCode);

    void cancelOrder(int orderCode);

    boolean reorderOrder(int orderCode);

    OrderStatus getStatus();

    Date getOrderDate();

    Date getDeliveryDate();

    int getItemId();

    int getQuantity();

}
