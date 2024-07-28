public class NoSelectionState implements State {
    VendingMachine vendingMachine;

    public NoSelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Product selected: " + product);
        vendingMachine.setSelectedProduct(product);
        vendingMachine.setState(vendingMachine.getHasSelectionState());
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Select a product first");
    }

    @Override
    public void dispense() {
        System.out.println("Select a product first");
    }

    @Override
    public void cancel() {
        System.out.println("No selection to cancel");
    }
}
