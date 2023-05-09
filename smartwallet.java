import java.util.Scanner;

public class smartwallet implements paymentmethod {
    private double amount;
    private String appname;
    private String email;
    private String phonenumber;
    private String password;
    Scanner in = new Scanner(System.in);

    public smartwallet(){

    }
    public void chooosewallet(){
        System.out.println("Choose your wallet name");
        System.out.println("1-vodafone");
        System.out.println("2-etisalat");
        System.out.println("3-orange");
        int des=0;
        des=in.nextInt();
        if(des==1){
            appname="vodafone";
        }
        else if(des==2){
            appname="etisalat";
        }
        else if(des==3){
            appname="orange";
        }


    }


    @Override
    public void makepayment(order o) {
        chooosewallet();
        System.out.println("total price: ");
        System.out.println(o.calculateOrderTotal());
        int de;
        System.out.println("do you want to confirm payment?");
        System.out.println("1-yes");
        System.out.println("2-no");
        de=in.nextInt();
        if(de==1){
            System.out.println("process done");
            System.out.println("here is your receipt");
            System.out.println("Date:5/9/2023");
            System.out.println("total pices"+" "+o.calculateOrderTotal()+"Egp");
            System.out.println("phone number"+" "+"01114402117");
        }
        else{
            System.out.println("opeartion is cancelled");
            return;
        }
    }
}
