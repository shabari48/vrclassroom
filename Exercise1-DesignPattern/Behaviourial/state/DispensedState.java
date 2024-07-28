public class DispensedState implements State {
    VendingMachine vendingMachine;

    public DispensedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Product already dispensed. Start a new transaction.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Product already dispensed. Start a new transaction.");
    }

    @Override
    public void dispense() {
        System.out.println("Product already dispensed.");
    }

    @Override
    public void cancel() {
        System.out.println("Product already dispensed. Cannot cancel.");
    }
}
