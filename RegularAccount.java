public class RegularAccount extends Account {
    private static final double INTEREST_RATE = 0.06;
    private static final double MAINTENANCE_FEE = 10.0;

    public RegularAccount(String accountNumber, Customer customer, double initialBalance) {
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
        balance += balance * INTEREST_RATE;
        balance -= MAINTENANCE_FEE;
        if (balance < 0) balance = 0;
        resetTransactionCount();
    }

    @Override
    public String toString() {
        return "Regular " + super.toString();
    }
}