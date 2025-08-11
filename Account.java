public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected Customer customer;
    protected int transactionCount;

    public Account(String accountNumber, Customer customer, double initialBalance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = initialBalance;
        this.transactionCount = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionCount++;
        }
    }

    public abstract boolean withdraw(double amount);

    public abstract void applyMonthlyUpdate();

    public int getTransactionCount() {
        return transactionCount;
    }

    public void resetTransactionCount() {
        transactionCount = 0;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Balance: $" + String.format("%.2f", balance) +
               ", Owner: " + customer.getCustomerName();
    }
}