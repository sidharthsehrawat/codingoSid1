package folder.design_patterns.factory;

public class App {
    public static void main(String[] args) {
       // PaymentGatewayProcessor paymentGatewayProcessor = createPaymentMode("paytm");
       // paymentGatewayProcessor.processPayment(10, "paytm");

        PaymentGatewayProcessor paymentGatewayProcessor = createPaymentMode("phonepe");
        paymentGatewayProcessor.processPayment(10, "phonepe");
        System.out.println("committed .... ENDS ...");
    }

    private static PaymentGatewayProcessor createPaymentMode(String mode) {
        if (mode.equals("paytm")) {
            return new PaytmGateway();
        }else if (mode.equals("googlePay")) {
            return new GooglePayGateway();
        }else if (mode.equals("phonepe")) {
            return new PhonePeGateway();
        }
        return null;
    }
}
