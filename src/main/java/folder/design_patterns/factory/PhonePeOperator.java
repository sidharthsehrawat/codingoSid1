package folder.design_patterns.factory;

public class PhonePeOperator implements Gateway {
    public PhonePeOperator(int amount) {
        System.out.println("transaction money " + amount);
    }

    public void process(int amount, String company) {
        System.out.println("Payment Done for   ... " + company + " amount = " + amount);
    }

    @Override
    public void getPaymentgateway() {
        System.out.println("Phonepe gateway found ... ");
    }
}
