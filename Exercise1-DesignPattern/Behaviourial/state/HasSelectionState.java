public class HasSelectionState implements State {
    VendingMachine vendingMachine;

    public HasSelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Product already selected: " + vendingMachine.getSelectedProduct());
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Money inserted: $" + amount);
        vendingMachine.setMoney(amount);
        vendingMachine.setState(vendingMachine.getHasMoneyState());
    }

    @Override
    public void dispense() {
        System.out.println("Insert money first");
    }

    @Override
    public void cancel() {
        System.out.println("Selection cancelled");
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setState(vendingMachine.getNoSelectionState());
    }
}
