Bank.java: Manages the collection of accounts and provides methods for account operations and bank-wide statistics.

ArrayList:

‘Accounts’ (List<Account>): A list of all accounts in the bank (polymorphic, storing `CheckingAccount`, `GoldAccount`, or `RegularAccount` objects).

Methods:

Constructor: Initializes an empty `ArrayList` for accounts.

createCheckingAccount(String, Customer, double): Creates a new `CheckingAccount` and adds it to `accounts`.

createGoldAccount(String, Customer, double): Creates a new `GoldAccount` and adds it to `accounts`.

createRegularAccount(String, Customer, double): Creates a new `RegularAccount` and adds it to `accounts`.

deposit(String, double): Finds the account by `accountNumber` and calls its `deposit` method. Returns true if successful.

withdraw(String, double): Finds the account by `accountNumber` and calls its `withdraw` method. Returns true if successful.

displayAccountInfo(String): Finds the account by `accountNumber` and returns its .toString() representation or "Account not found".

removeAccount(String): Removes the account with the given `accountNumber` from `accounts`. Returns true if successful.

applyMonthlyUpdates(): Calls `applyMonthlyUpdate` on each account in `accounts`.

getBankStatistics(): Calculates the sum of all account balances, number of accounts (`accounts.size()), number of zero-balance accounts, 
average balance (total balance / number of accounts), account with the largest balance, and returns a formatted string with these statistics.

findAccount(String): Helper method to find an account by `accountNumber`. Returns `null` if not found.





Role in the System: Acts as the central manager for all accounts, handling creation, modification, and deletion. 
It also provides polymorphic behavior by storing all account types in a single `List<Account>` and calling their type-specific methods 
(e.g., `withdraw`, `applyMonthlyUpdate`). Lastly, it generates bank-wide statistics for administrative purposes.


BankSystem.java: Provides a console-based user interface for bank operators to interact with the `Bank` class.

Attributes: None explicitly defined, but uses a `Bank` object and a `Scanner` for user input.

Methods:

main(String[]): Creates a `Bank` object and a `Scanner`. Then runs a loop displaying a menu with 10 options.

    1. Create Checking Account
    2. Create Gold Account
    3. Create Regular Account
    4. Deposit Money
    5. Withdraw Money
    6. Display Account Information
    7. Remove Account
    8. Apply Monthly Updates
    9. Display Bank Statistics
    10. Exit

Based on the user’s choice, collects necessary input (e.g., account number, customer details, amount) and calls appropriate `Bank` methods. 
To give the user feedback, provides information on the success or failure of operations. Because of the while loop, the program will continue to run for the user until option 10 is selected, 
and the program is ended.
