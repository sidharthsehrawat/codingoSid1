package folder.design_patterns.factory;

public abstract class PaymentGatewayProcessor {
    // open closed principle ...
    public void processPayment(int amount, String company) {
        verifyOperartor(company);
        verifyPlan(company);
        validation(company);

       final Gateway gatewayType = getPaymentgateway(amount);
       gatewayType.getPaymentgateway();

        /*if (company.equals("phonepe")) {
            PhonePeOperator phonePeOperator = new PhonePeOperator(amount);
            phonePeOperator.process(amount, company);
        } else if (company.equals("paytm")) {
            PaytmOperator paytmOperator = new PaytmOperator(amount);
            paytmOperator.process(amount, company);
        } else if (company.equals("googlepay")) {
            GooglePay paytmOperator = new GooglePay(amount);
            paytmOperator.process(amount, company);
        }*/
        ;
    }

    public abstract Gateway getPaymentgateway(int amount);

    private boolean verifyOperartor(String company) {
        System.out.println("Operator verifying success..." + company);
        return true;
    }

    private int verifyPlan(String company) {
        System.out.println("Verify plan success ...  " + company);
        return 0;
    }

    private boolean validation(String company) {
        System.out.println("validation payment  success ... " + company);
        return true;
    }
}
