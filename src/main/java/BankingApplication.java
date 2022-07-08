import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        AccountNumber accountNumber = new AccountNumber("Efemena",2020111);
        accountNumber.showMenu();

    }
}

class AccountNumber {
    String customerName;
    int bvnNumber;
    int previousTransaction;
    int balance;

    public AccountNumber(String customerName, int bvnNumber) {
        this.customerName = customerName;
        this.bvnNumber = bvnNumber;
    }

    void deposit(int amount) {
        balance = balance + amount;
        previousTransaction = amount;
    }

    void withdraw(int amount) {
        balance = balance - amount;
        previousTransaction -= amount;

    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Hello " + customerName + ", your last transaction was " + balance);

        } else if (previousTransaction < 0) {
            System.out.println("Hello this transaction is not valid");

        } else {
            System.out.println("you are yet to make any transaction");
        }
    }

    void showMenu() {
        Scanner scanner = new Scanner(System.in);
        char option = '\0';
        System.out.println("Welcome Dear " + customerName);
        System.out.println("This is your bvn number kindly keep this number as private " + bvnNumber);
        System.out.println("\n");
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("Enter an option:");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    System.out.println("balance " + balance);
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("Enter the amount for deposit");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("Enter the amount you would like to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'E':
                    System.out.println("EXIT!");
                default:
                    System.out.println("Option is invalid");
                    break;
            }
        } while (option != 'E');
        System.out.println("Thank you for using our service!");
    }

}