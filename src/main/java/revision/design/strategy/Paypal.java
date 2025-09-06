package revision.design.strategy;

public class Paypal implements PaymentStrategy {
    @Override
    public void pay(int pay) {
        System.out.println("Paid " + pay);
    }
}

