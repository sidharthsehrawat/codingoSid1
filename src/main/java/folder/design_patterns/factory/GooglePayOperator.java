package folder.design_patterns.factory;

public class GooglePayOperator implements Gateway {
    public GooglePayOperator(int amount){
        System.out.println("transaction money " + amount);
    }
    /*public void process(int amount , String company) {
        System.out.println("Payment Done for   ... " + company + " amount = " + amount);
    }*/

    public void getPaymentgateway() {
        System.out.println("GooglePay gateway found ... ");
    }
}
