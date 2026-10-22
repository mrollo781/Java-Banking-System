package bankPractice3;

import java.util.Scanner;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private AccountType accountType;

    Scanner scan = new Scanner(System.in);

    public BankAccount() {
        accountNumber = 0;
        balance = 0.0;
        accountType = AccountType.CURRENT;
    }

    public int getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public AccountType getAccountType() { return accountType; }

    public boolean setAccountNumber(int accountNumber) {
        if (accountNumber > 0) {
            this.accountNumber = accountNumber;
            return true;
        } else {
            return false;
        }
    }

    public boolean setBalance(double balance) {
        if (balance >= 0.0) {
            this.balance = balance;
            return true;
        } else {
            System.out.println("Invalid amount.");
            return false;
        }
    }

    public boolean setAccountType(AccountType accountType) {
        if (accountType != null) {
            this.accountType = accountType;
            return true;
        } else {
            System.out.println("Invalid account type.");
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Account Number: %d, Balance: £%.2f, Account Type: %s", accountNumber, balance, accountType);
    }

    public boolean deposit() {
        double amount = 0.0;
        System.out.println("How much would you like to deposit? : ");
        amount = scan.nextDouble();
        if (amount > 0.0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Invalid amount.");
            return false;
        }
    }

    public void withdraw() {
        double amount = 0.0;
        System.out.println("How much would you like to withdraw? : ");
        amount = scan.nextDouble();

        if (amount <= 0.0) {
            System.out.println("Invalid amount. Must be greater than 0.");
            return; 
        }

        if (accountType == AccountType.CURRENT) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Not enough funds");
            }
        } 
        else if (accountType == AccountType.SAVINGS) {
            if ((balance - amount) >= 50.00) {
                balance -= amount;
            } else {
                System.out.println("Balance cannot drop below £50.00");
            }
        } 
        else if (accountType == AccountType.STUDENT) {
            if ((balance - amount) >= -200.0) {
                balance -= amount;
            } else {
                System.out.println("Overdraft limit reached.");
            }
        } else {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Not enough funds");
            }
        }
    }
    
    public double applyInterest() {
        double rate = switch (this.accountType) {
            case CURRENT -> 1.0; 
            case SAVINGS -> 3.0;
            case STUDENT -> 0.0;
            default      -> 0.0;
        };

        balance += (balance * (rate / 100));
        return balance;
    }	
}
