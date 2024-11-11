package bank;

public abstract class BankAccount implements BankOperations{
    double balance;
    String accountId;

    void BankAccount(double balance, String accountId) {
        this.balance = balance;
        this.accountId = accountId;
    }

    public void  deposit(double b){
        balance = balance + b;
        System.out.println("Deposited " + b + " to " + accountId);
    }
    public void withdraw(double b) throws InsufficientFundsException {
        if(balance >= b){
            balance = balance - b;
            System.out.println("Withdrawn " + b + " from " + accountId);
        }else{
            throw new InsufficientFundsException("Insufficient Funds");
        }
    }
    public double getBalance(){
        return balance;
    }
    public String getAccountId(){
        return accountId;
    }

    public abstract void displayInfo();

}
