package folder.design_patterns.factory;

import java.security.PublicKey;

public class PaytmOperator implements Gateway {
    public PaytmOperator (int amount){
        System.out.println("transaction money " + amount);
    }

    /*public void process(int amount , String company) {
        System.out.println("Payment Done for   ... " + company + " amount = " + amount);
    }*/

    public void getPaymentgateway() {
        System.out.println("Paytm gateway found ... ");
    }
}
