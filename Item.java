import java.util.ArrayList;
import java.util.List;

public class Item
{
    private String name;
    private String description;
    private String category;
    private int itemid;
    private String image;
    private String brand;
    private double price;
    private double unitprice;
    private double discountPercentage;

    public Item(String name, String description, String category, String image, String brand, double price,
                double discountPercentage)
    {
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
        this.brand = brand;
        this.price = price;
        this.discountPercentage = discountPercentage;
    }
    public Item (int itemid,String name,double unitprice)
    {
        this.name = name;
        this.unitprice = unitprice;
        this.itemid=itemid;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
    public int getItemid() {
        return itemid;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
    public double calactotal (int quantity)

    {
        return (unitprice*quantity);
    }
}

class Items
{
public ArrayList<Item> itemList=new ArrayList<>();//array

public Items()
        {
            Item item1 = new Item("Candy", "Sweet", "Candies", "candy.jpg", "ABC Brand", 5.99, 0.1);
            Item item2 = new Item("Cake", "Sweet", "Candies", "cake.jpg", "XYZ Brand", 15.99, 0.2);
            Item item3 = new Item("Chips", "Snack", "Candies", "chips.jpg", "123 Brand", 2.99, 0.05);
            itemList.add(item1);
            itemList.add(item2);
            itemList.add(item3);
        }



    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void viewProducts() {
    for (Item item : itemList) {
        System.out.println(item.getName() + " " + item.getPrice() + " " + item.getBrand());
    }
}

}

