package bank;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(double i, String id3) {
        super();
    }

    @Override
    public void displayInfo() {
        System.out.println("Checking Account Information: balance = " + getBalance());
    }
}
