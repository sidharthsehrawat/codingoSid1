package folder.design_patterns.factory;

public class PaytmGateway extends PaymentGatewayProcessor{
    public Gateway getPaymentgateway(int amount) {
        System.out.println("Paytm Amount paid " + amount);
        return new PaytmOperator(amount);
    }
}
