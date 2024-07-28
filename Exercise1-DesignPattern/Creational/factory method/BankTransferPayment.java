public class BankTransferPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing bank transfer payment of $%.2f%n", amount);
    }

    @Override
    public String getPaymentMethod() {
        return "Bank Transfer";
    }
}