package bank;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(double i, String id2) {
        super();
    }

    @Override
    public void displayInfo() {
        System.out.println("Savings Account Information : balance = " + getBalance());
    }
}
