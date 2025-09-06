package revision.design.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setPaymentStrategy(new GooglePay());
        shoppingCart.checkout(10);
    }
}
