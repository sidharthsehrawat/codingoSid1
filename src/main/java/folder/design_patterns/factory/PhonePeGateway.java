package folder.design_patterns.factory;

public class PhonePeGateway extends PaymentGatewayProcessor{
    @Override
    public Gateway getPaymentgateway(int amount) {
        System.out.println("PhonePe Amount paid " + amount);
        return new PhonePeOperator(amount);
    }
}
