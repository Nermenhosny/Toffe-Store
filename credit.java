import java.util.Scanner;

public class credit implements paymentmethod
{

    private String cardnum;
    private int cvc;



    Scanner in = new Scanner(System.in);
    public void information(){
        System.out.println("enter your card number");
        String cardnum;
        int cvc=0;
        cardnum=in.next();
        System.out.println("Enter cvc code");
        cvc=in.nextInt();

    this.cardnum=cardnum;
    this.cvc=cvc;
    }
    @Override
    public void makepayment(order o){
        information();;
        int de;
        System.out.println("do you want to confirm payment?");
        System.out.println("1-yes");
        System.out.println("2-no");
        de=in.nextInt();
        if(de==1){
            System.out.println("process done");
            System.out.println("here is your receipt");
            System.out.println("Date:5/9/2023");
            System.out.println("total price"+" "+o.calculateOrderTotal()+"Egp");
            System.out.println("phone number"+" "+"01114402117");
        }
        else{
            System.out.println("opeartion is cancelled");
            return;
        }
    };

}
