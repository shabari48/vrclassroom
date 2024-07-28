public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.selectProduct("Soda");
        vendingMachine.insertMoney(1.0);
        vendingMachine.dispense();

        vendingMachine.selectProduct("Chips");
        vendingMachine.cancel();
    }
}
