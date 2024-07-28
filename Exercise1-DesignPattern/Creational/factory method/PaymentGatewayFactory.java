// PaymentGatewayFactory.java
public class PaymentGatewayFactory {
    public static PaymentGateway createPaymentGateway(String paymentMethod) {
        switch (paymentMethod.toLowerCase()) {
            case "credit card":
                return new CreditCardPayment();
            
            case "bank transfer":
                return new BankTransferPayment();
            default:
                throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
    }
}