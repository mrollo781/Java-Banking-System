package bankPractice3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountApp {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        BankAccount b1 = new BankAccount();
        
        boolean loop = false;
        
        while (!loop) {
            try {
                System.out.println("Enter account number : ");
                int accountNumber = scan.nextInt();
                
                if (b1.setAccountNumber(accountNumber)) {
                    loop = true;
                    System.out.println("Account created successfully!");
                    System.out.println(b1.toString());
                } else {
                    System.out.println("Account number must be greater than 0.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scan.next(); // Clear the invalid input to prevent infinite loops
            }
        }
        scan.close();
    }
}
