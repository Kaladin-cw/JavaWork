/* Bank methods that allow the bank operator to use the menu in BankSystem,
 * and store values into the ArrayList 'accounts' for retrieval and use from the menu.
 *
 * @Author: Team Red
 * @Date: 2AUG25
 * @Version: 1.0
 */


//import the utils

import java.util.ArrayList;
import java.util.List;


public class Bank {
    private List<Account> accounts;

    //create our ArrayList to store our info.
    public Bank() {
        accounts = new ArrayList<>();
    }

    //Allows us to make a checking account, as well as add it to our ArrayList.
    public void createCheckingAccount(String accountNumber, Customer customer, double initialBalance) {
        accounts.add(new CheckingAccount(accountNumber, customer, initialBalance));
    }

    //Same as above, but for the gold account.
    public void createGoldAccount(String accountNumber, Customer customer, double initialBalance) {
        accounts.add(new GoldAccount(accountNumber, customer, initialBalance));
    }

    //Same here, but for the Regular account type.
    public void createRegularAccount(String accountNumber, Customer customer, double initialBalance) {
        accounts.add(new RegularAccount(accountNumber, customer, initialBalance));
    }

    //This will find the account you would like to deposit to, and then call the deposit method,
    //returns true if it succeeds.
    public boolean deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null && amount > 0) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    //Same logic as above, but for the withdraw method.
    public boolean withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }

    //Allows for the searching of an account in the system, and displaying the details via .toString().
    public String displayAccountInfo(String accountNumber) {
        Account account = findAccount(accountNumber);
        return account != null ? account.toString() : "Account not found";
    }

    //Finds an account that the bank operator will input, and remove it from our ArrayList.
    public boolean removeAccount(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            accounts.remove(account);
            return true;
        }
        return false;
    }

    //Adds the monthly manipulations by calling the requisite method.
    public void applyMonthlyUpdates() {
        for (Account account : accounts) {
            account.applyMonthlyUpdate();
        }
    }

    //Method that sets initial values for the fields needed to populate the bank stats, and also displays them in
    //a neat fashion.
    public String getBankStatistics() {
        if (accounts.isEmpty()) {
            return "No accounts in the bank";
        }

        double totalBalance = 0;
        int zeroBalanceCount = 0;
        Account maxBalanceAccount = accounts.get(0);
        double maxBalance = accounts.get(0).getBalance();

        for (Account account : accounts) {
            double balance = account.getBalance();
            totalBalance += balance;
            if (balance == 0) {
                zeroBalanceCount++;
            }
            if (balance > maxBalance) {
                maxBalance = balance;
                maxBalanceAccount = account;
            }
        }

        double averageBalance = totalBalance / accounts.size();
        return String.format("Bank Statistics:\n" +
                            "Total Balance: $%.2f\n" +
                            "Number of Accounts: %d\n" +
                            "Zero Balance Accounts: %d\n" +
                            "Average Balance: $%.2f\n" +
                            "Account with Largest Balance: %s",
                            totalBalance, accounts.size(), zeroBalanceCount,
                            averageBalance, maxBalanceAccount.toString());
    }

    // Method to use in the above code to help with other methods (deposit, withdraw, displayAccount, and removeAccount)
    //Also makes it easier to write the methods to do those things, as well as make it easily re-useable as it applies to
    //many things in this class.

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}