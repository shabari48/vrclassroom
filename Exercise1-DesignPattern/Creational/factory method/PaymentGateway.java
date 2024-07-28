// PaymentGateway.java
public interface PaymentGateway {
    void processPayment(double amount);
    String getPaymentMethod();
}