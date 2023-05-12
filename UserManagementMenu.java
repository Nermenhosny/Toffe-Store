import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    public static boolean isValidName(String name) {
        // Name should contain only alphabetic characters and spaces
        return name.matches("^[A-Za-z ]+$");
    }


    public static boolean isValidEmail(String email)
    {
        // Basic email validation using regular expression
        return email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]+$");
    }

    public static boolean isValidPassword(String password)
    {
        // Password should have at least 8 characters
        return password.length()>=8;
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
       Scanner scanner = new Scanner(System.in);
       int c;
       do {
           System.out.println("\n1.create order and check order is valid. ");
           System.out.println("2. cancel order. ");
           System.out.println("3. calculate total  order. ");
           System.out.println("4. Exist from order page . ");
           System.out.print("Enter your choice: ");
            c = scanner.nextInt();
            scanner.nextLine();
            order myOrder = new order(1, 456, "123 Main St");
           myOrder.createOrder(1, 1234, "123 Main St");
           myOrder.addItemsToOrder(1, 100, 3);
           Item myItem = new Item(1, "Item 1", 50.00);
           Item myItem1 = new Item(2, "Item 2", 20.00);

           if (c == 1) {

               boolean isValid = myOrder.checkOrderValid(1);
               System.out.println("Order is valid: " + isValid);
               System.out.print("order is created. ");
           }
            else if (c == 2) {

               Date orderDate = new Date(2023, 3, 3); // March 3, 2023
               Date cancelDate = new Date(2023, 3, 3); // March 5, 2023
               myOrder.cancelOrder( 1, orderDate, cancelDate);
           } else if (c == 3) {
               myOrder.addOrderDetail(myItem1, 2);
               myOrder.addOrderDetail(myItem, 5);
               double orderTotal = myOrder.calculateOrderTotal();
               System.out.println("Order total: $" + orderTotal);

           }
       } while (c != 4);





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
//                        order myOrder = new order(123, 456, "123 Main St");
//                        // Add an item to the order
//                        Item myItem = new Item(1, "Item 1", 25.00);
//                        myOrder.addOrderDetail(myItem, 2);
//                        shoppingcard s=new shoppingcard();
//                        s.checkout(myOrder);

                    }
                    if (choice == 2)
                    {
                        order();

                    }

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
    while (!Register.isValidName(name)) {
        System.out.println("Invalid name format. Name should contain only alphabetic characters.");
        System.out.println("Enter name: ");
        name = scanner.nextLine();
    }
    System.out.println("Enter email: ");
    String email = scanner.nextLine();
    while (!Register.isValidEmail(email)) {
        System.out.println("Invalid email format.");
        System.out.println("Enter email: ");
        email = scanner.nextLine();
    }
    System.out.println("Enter address: ");
    String address = scanner.nextLine();
    System.out.println("Enter password: ");
    String password = scanner.nextLine();
    while (!Register.isValidPassword(password))
    {
        System.out.println("Invalid password. Password should have at least 8 characters.");
        System.out.println("Enter password: ");
        password = scanner.nextLine();
    }

    // Generate OTP
    String otp = generateOTP();

    // Send OTP via email
    boolean isEmailSent = sendOTPByEmail(email, otp);
    if (isEmailSent)
    {
        // Registration successful
        System.out.println("Registration successful!");
        User newUser = new Register(name, email, address, password);
        users.add(newUser);
        System.out.println("User registered successfully!");
    }
    else
    {
        System.out.println("Failed to send OTP. Registration aborted.");
    }
}

    private String generateOTP()
    {
        // Generate a 6-digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
    private boolean sendOTPByEmail(String recipientEmail, String otp)
    {
        // Replace these with your own email credentials and SMTP server information
        final String senderEmail = "gabrd75@gamail.com";
        final String senderPassword = "wbagmzxaryezejpn";
        final String smtpServer = "smtp.gmail.com";
        final int smtpPort = 587;
        //recipientEmail = "neemohosnee@gamil.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpServer);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.connectiontimeout", "5000"); // Set timeout to 5 seconds

        // Create a Session object with your email credentials
        Session session = Session.getInstance(props, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Registration OTP");
            message.setText("Your OTP for registration is: " + otp);

            // Send the email
            Transport.send(message);
            return true;
        }
//    catch (MessagingException e)
//    {
//        System.out.println("Failed to send OTP: " + e.getMessage());
//        return false;
//    }
        catch (MessagingException e)
        {
            System.out.println("Failed to send OTP: " + e.getMessage());
            e.printStackTrace(); // Add this line to print the full stack trace for debugging
            return false;
        }

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

