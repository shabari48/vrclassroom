public class VendingMachine {
    State noSelectionState;
    State hasSelectionState;
    State hasMoneyState;
    State dispensedState;

    State currentState;
    String selectedProduct;
    double money;

    public VendingMachine() {
        noSelectionState = new NoSelectionState(this);
        hasSelectionState = new HasSelectionState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensedState = new DispensedState(this);

        currentState = noSelectionState;
    }

    public void setState(State state) {
        currentState = state;
    }

    public void setSelectedProduct(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public State getNoSelectionState() {
        return noSelectionState;
    }

    public State getHasSelectionState() {
        return hasSelectionState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getDispensedState() {
        return dispensedState;
    }

    public void selectProduct(String product) {
        currentState.selectProduct(product);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }

    public void dispense() {
        currentState.dispense();
    }

    public void cancel() {
        currentState.cancel();
    }
}
