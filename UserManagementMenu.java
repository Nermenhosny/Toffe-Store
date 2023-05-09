import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

interface User
{
    String getName();
    String getEmail();
    String getAddress();
    String getPassword();
}

class Register implements User
{
    private String name;
    private String email;
    private String address;
    private String password;

    public Register(String name, String email, String address, String password)
    {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPassword() {
        return password;
    }
}

 class Login implements User
{
    private String name;
    private String address;
    private String email;
    private String password;

    public Login(  String password,String email )
    {

        this.email = email;
        this.password = password;
    }
    public String getName()
    {
        return name;
    }
    @Override
    public String getEmail()
    {
        return email;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPassword() {
        return password;
    }


}



public class UserManagementMenu
{
    public List<User> RegisteredUsersinTheSystem()
    {

        String name="Nermen Hosny";
        String email="nermenhosny@gmail.com";
        String address="12 st El Nasr";
        String password="Nermen hosny123";
        User newUser = new Register(name, email, address, password);
        name="Dalia Ibrahim";
         email="daliaibrahim@gmail.com";
        address="12 st El 8";
       password="Dalia Ibrahim123";
       newUser = new Register(name, email, address, password);
        users.add(newUser);
        return users;
    }


   public void order()
   {
       orderManager manager = new orderManager();
       // Call the createOrder method to create a new order
       manager.createOrder(1, 1234, "123 Main St");
       // Call the addItemsToOrder method to add items to the order
       manager.addItemsToOrder(1, 100, 3);



       // Call the checkOrderValid method to check if the order is valid
       boolean isValid = manager.checkOrderValid(1);
       System.out.println("Order is valid: " + isValid);
       // Call the cancelOrder method to cancel the order
       Date orderDate = new Date(2023, 3, 3); // March 3, 2023
       Date cancelDate = new Date(2023, 3, 3); // March 5, 2023
       manager.cancelOrder(1,orderDate , cancelDate);

       order myOrder = new order(1, 456, "123 Main St");

       // Add an item to the order
       Item myItem = new Item(1, "Item 1", 50.00);
       Item myItem1 = new Item(2, "Item 2", 20.00);

       myOrder.addOrderDetail(myItem1, 2);
       myOrder.addOrderDetail(myItem, 5);
       // Calculate the order total
       double orderTotal = myOrder.calculateOrderTotal();
       System.out.println("Order total: $" + orderTotal);




   }

    private List<User> users;
    private Register register;
    private Login login;

    public UserManagementMenu()
    {
        users = new ArrayList<>();
        register = new Register(null, null, null, null);
        login = new Login(null, null);
    }

    public void displayMenu()
    {
        RegisteredUsersinTheSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("User Management Menu");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. viewcatalog");
            System.out.println("4. Exist");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice)
            {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    System.out.println("1. view shopping card");
                    System.out.println("2. order");
                    System.out.println("3. payment");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if(choice == 1)
                    {
                        order myOrder = new order(123, 456, "123 Main St");
                        // Add an item to the order
                        Item myItem = new Item(1, "Item 1", 25.00);
                        myOrder.addOrderDetail(myItem, 2);
                        shoppingcard s=new shoppingcard();
                        s.checkout(myOrder);
                    }
                    if (choice == 2)
                        order();
                    // if(choice == 3)
                    //payment
                    break;
                case 3:
                    //view catalog
                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 4);
    }

    private void registerUser()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        RegisteredUsersinTheSystem();
        User newUser = new Register(name, email, address, password);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }

    boolean  loginUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        User login = new Login(password, email);

        for (User user : users)
        {
            if (user.getEmail().equals(login.getEmail()) && user.getPassword().equals(login.getPassword()))
            {
                System.out.println("Login successful!");
                return true;
            }
        }

        System.out.println("Invalid email or password. Login failed.");
        return false;
    }
}

