package revision.design.strategy;

public class UPI implements PaymentStrategy {
    @Override
    public void pay(int pay) {
        System.out.println("Paid " + pay);
    }
}


