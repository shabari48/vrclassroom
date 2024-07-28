public interface State {
    void selectProduct(String product);
    void insertMoney(double amount);
    void dispense();
    void cancel();
}
