/* Bank methods that allow the bank operator to use the menu in BankSystem...
 *
 *
 * @Author: Team Red
 * @Date: 2AUG25
 * @Version: 1.0
 */

//import Scanner to capture user input.

import java.util.Scanner;

//Create our main method, declare variables, and create a scanner.
public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

//While loop to make the menu persist until the Bank Operator exits the program.
        while (running) {
            System.out.println("\nTeam Red Bank System Menu:");
            System.out.println("1. Create Checking Account");
            System.out.println("2. Create Gold Account");
            System.out.println("3. Create Regular Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Display Account Information");
            System.out.println("7. Remove Account");
            System.out.println("8. Apply Monthly Updates");
            System.out.println("9. Display Bank Statistics");
            System.out.println("10. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume user input

//Switch to properly obtain the info needed to create the items requested, or call methods as needed.
            switch (choice) {
                case 1: // Create Checking Account
                    System.out.print("Enter account number: ");
                    String checkingAccNum = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String checkingCustId = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String checkingCustName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String checkingEmail = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    String checkingPhone = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double checkingBalance = scanner.nextDouble();
                    bank.createCheckingAccount(checkingAccNum, 
                        new Customer(checkingCustId, checkingCustName, checkingEmail, checkingPhone), 
                        checkingBalance);
                    System.out.println("Checking account created successfully");
                    break;

                case 2: // Create Gold Account
                    System.out.print("Enter account number: ");
                    String goldAccNum = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String goldCustId = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String goldCustName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String goldEmail = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    String goldPhone = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double goldBalance = scanner.nextDouble();
                    bank.createGoldAccount(goldAccNum, 
                        new Customer(goldCustId, goldCustName, goldEmail, goldPhone), 
                        goldBalance);
                    System.out.println("Gold account created successfully");
                    break;

                case 3: // Create Regular Account
                    System.out.print("Enter account number: ");
                    String regularAccNum = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String regularCustId = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String regularCustName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String regularEmail = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    String regularPhone = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double regularBalance = scanner.nextDouble();
                    bank.createRegularAccount(regularAccNum, 
                        new Customer(regularCustId, regularCustName, regularEmail, regularPhone), 
                        regularBalance);
                    System.out.println("Regular account created successfully");
                    break;

                case 4: // Deposit Money
                    System.out.print("Enter account number: ");
                    String depositAccNum = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (bank.deposit(depositAccNum, depositAmount)) {
                        System.out.println("Deposit successful");
                    } else {
                        System.out.println("Deposit failed");
                    }
                    break;

                case 5: // Withdraw Money
                    System.out.print("Enter account number: ");
                    String withdrawAccNum = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (bank.withdraw(withdrawAccNum, withdrawAmount)) {
                        System.out.println("Withdrawal successful");
                    } else {
                        System.out.println("Withdrawal failed");
                    }
                    break;

                case 6: // Display Account Information
                    System.out.print("Enter account number: ");
                    String infoAccNum = scanner.nextLine();
                    System.out.println(bank.displayAccountInfo(infoAccNum));
                    break;

                case 7: // Remove Account
                    System.out.print("Enter account number: ");
                    String removeAccNum = scanner.nextLine();
                    if (bank.removeAccount(removeAccNum)) {
                        System.out.println("Account removed successfully");
                    } else {
                        System.out.println("Account removal failed");
                    }
                    break;

                case 8: // Apply Monthly Updates
                    bank.applyMonthlyUpdates();
                    System.out.println("Monthly updates applied");
                    break;

                case 9: // Display Bank Statistics
                    System.out.println(bank.getBankStatistics());
                    break;

                case 10: // Exit
                    running = false;
                    System.out.println("Exiting system, thank you for using the Team Red bank system");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }
}