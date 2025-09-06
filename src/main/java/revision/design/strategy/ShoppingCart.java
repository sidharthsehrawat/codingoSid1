package revision.design.strategy;

public class ShoppingCart {
    public PaymentStrategy paymentStrategy ;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount){
        paymentStrategy.pay(amount);
    }
}
