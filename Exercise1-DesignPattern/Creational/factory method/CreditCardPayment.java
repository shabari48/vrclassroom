public class CreditCardPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing credit card payment of $%.2f%n", amount);
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }
}