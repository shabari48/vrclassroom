import java.util.Scanner;

public class ECommercePlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a payment method (Credit Card,  Bank Transfer):");
        String userChoice = scanner.nextLine();

        System.out.println("Enter the amount to pay:");
        double amount = scanner.nextDouble();

        try {
            PaymentGateway paymentGateway = PaymentGatewayFactory.createPaymentGateway(userChoice);
            paymentGateway.processPayment(amount);
            System.out.println("Payment method: " + paymentGateway.getPaymentMethod());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}