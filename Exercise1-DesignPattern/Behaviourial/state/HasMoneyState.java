public class HasMoneyState implements State {
    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Product already selected: " + vendingMachine.getSelectedProduct());
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Already inserted enough money");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing product: " + vendingMachine.getSelectedProduct());
        vendingMachine.setState(vendingMachine.getDispensedState());
    }

    @Override
    public void cancel() {
        System.out.println("Transaction cancelled. Returning money.");
        vendingMachine.setMoney(0);
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setState(vendingMachine.getNoSelectionState());
    }
}
