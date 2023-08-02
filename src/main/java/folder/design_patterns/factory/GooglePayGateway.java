package folder.design_patterns.factory;

public class GooglePayGateway extends PaymentGatewayProcessor{
    @Override
    public Gateway getPaymentgateway(int amount) {
        System.out.println("GooglePay Amount paid " + amount);
        return new GooglePayOperator(amount);
    }
}
