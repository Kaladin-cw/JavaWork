public class GoldAccount extends Account {
    private static final double INTEREST_RATE = 0.05;

    public GoldAccount(String accountNumber, Customer customer, double initialBalance) {
        super(accountNumber, customer, initialBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) return false;
        balance -= amount;
        transactionCount++;
        return true;
    }

    @Override
    public void applyMonthlyUpdate() {
        balance += balance * INTEREST_RATE;
        resetTransactionCount();
    }

    @Override
    public String toString() {
        return "Gold " + super.toString();
    }
}