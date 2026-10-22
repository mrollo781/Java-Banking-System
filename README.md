# Java Banking System

A multi-class Java application that simulates a robust banking environment. This project focuses on object-oriented design, implementing state management, robust error handling, and logic customized for various account types.

## Features
* **Encapsulation & State Management:** The `BankAccount` class securely handles private data such as balances and account numbers using getter and setter methods.
* **Account-Specific Logic:** Implements unique withdrawal and interest-rate rules based on an `AccountType` enumeration (e.g., Savings accounts have a £50 minimum balance, Student accounts allow overdrafts).
* **Input Validation:** Utilizes `try/catch` exception handling and logical checks to prevent invalid inputs (like negative deposits or entering letters instead of numbers) from crashing the program.

## How to Run
1. Clone the repository and navigate to the project directory.
2. Compile the Java files:
   ```bash
   javac bankPractice3/*.java
