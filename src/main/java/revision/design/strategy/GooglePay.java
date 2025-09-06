package revision.design.strategy;

public class GooglePay implements PaymentStrategy {
    @Override
    public void pay(int pay) {
        System.out.println("Paid " + pay);
    }
}
