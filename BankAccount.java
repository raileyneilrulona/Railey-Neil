package FirstWindowpackage;

public class BankAccount {
    private String holder, accountNo, type;
    private double balance;

    public BankAccount(String holder, String accountNo, String type, double balance) {
        this.holder = holder;
        this.accountNo = accountNo;
        this.type = type;
        this.balance = balance;
    }

    public String getHolder() { return holder; }
    public String getAccountNo() { return accountNo; }
    public String getType() { return type; }
    public double getBalance() { return balance; }
}
