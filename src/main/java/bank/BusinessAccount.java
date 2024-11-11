package bank;

public class BusinessAccount extends  BankAccount{


    public BusinessAccount(double i, String id1) {
        super();
    }

    @Override
    public void displayInfo() {
        System.out.println("Bank Account Information: balance ="+getBalance());
    }
}
