public class CheckingAccount extends Account {
    private static final double TRANSACTION_FEE = 3.0;
    private static final int FREE_TRANSACTIONS = 2;

    public CheckingAccount(String accountNumber, Customer customer, double initialBalance) {
        super(accountNumber, customer, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        
        double withdrawableAmount = Math.min(amount, balance);
        if (withdrawableAmount > 0) {
            balance -= withdrawableAmount;
            transactionCount++;
            return true;
        }
        return false;
    }

    @Override
    public void applyMonthlyUpdate() {
        int chargeableTransactions = Math.max(0, transactionCount - FREE_TRANSACTIONS);
        double fees = chargeableTransactions * TRANSACTION_FEE;
        balance -= fees;
        if (balance < 0) balance = 0;
        resetTransactionCount();
    }

    @Override
    public String toString() {
        return "Checking " + super.toString() + ", Transactions this month: " + transactionCount;
    }
}