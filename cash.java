import java.util.Scanner;

public class cash implements paymentmethod
{
    Scanner in = new Scanner(System.in);
    @Override
    public void makepayment(order o) {
        System.out.println("your adress is"+" "+o.getDeliveryAddress());
        System.out.println("we are sending our representative today");
        System.out.println("thank you for choosing toffe store enjoy your sweets :)");
    }

}
