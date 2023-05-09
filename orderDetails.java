import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class orderDetails  {
    private int itemId;
    private Item item;
    private int orderCode;
    private  double itemtotal;
    private int quantity;
    private List<orderDetails> orderDetails;

    public orderDetails( Item item,  int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public double getTotal(float taxPercentage) {//__________________________________________________________________________________
        if (item == null)
          itemtotal = 0;
        else {
            itemtotal  = item.calactotal(quantity);
            itemtotal *= (1 + (taxPercentage/100));
        }
        return itemtotal;
    }
    public int getItemId() {
        return this.itemId;
    }

    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public List<orderDetails> getDetailsList(int orderCode) {
        List<orderDetails> detailsList = new ArrayList<>();
        for (orderDetails details : orderDetails ) {
            if (details.getOrderCode() == orderCode) {
                detailsList.add(details);
            }
        }
        return detailsList;
    }

    public int getOrderCode() {
        return this.orderCode;
    }


    public Item getItem() {
        for (orderDetails details : orderDetails) {
            if (details.getItemId() == itemId) {
                return details.getItem();
            }
        }
        return null;
    }

}
