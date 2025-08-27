package Bank;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BankAccount acc = null;
		while (true) {
			System.out.println("--- Bank Menu ---");
			System.out.println("1. Create Account");
			System.out.println("2. Check Balance");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();
			try {
				switch (choice) {
				case 1:
					System.out.println("Enter Account number : ");
					int accNO = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter Name : ");
					String name = scan.nextLine();
					System.out.println("Enter Account type(Savings/Current) : ");
					String type = scan.next();
					System.out.println("Enter Initial Balance : ");
					float balance = scan.nextFloat();

					acc = new BankAccount(accNO, name, type, balance);
					break;

				case 2:
					if (acc != null) {
						acc.getBalance();
					} else {
						System.out.println("Create account first!!");
					}
					break;
					

				case 3:
					if (acc != null) {
						System.out.println("Enter deposite amount : ");
						float amount = scan.nextFloat();
						acc.deposit(amount);
					} else {
						System.out.println("Create account first!!");
					}
					break;

				case 4:
					if (acc != null) {
						System.out.println("Enter withdraw amount : ");
						float withdraw = scan.nextFloat();
						acc.withdraw(withdraw);
					} else {
						System.out.println("Create account first!!");
					}
					break;

				case 5:
					System.out.println("Thank you for using bank app");
					scan.close();
					return;

				default:
					System.out.println("Inavlid choice, please enter from 1 to 5 ");
				}
			} catch (NegativeAmountException | LowBalanceException | InsufficientFundsException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Please enter valid input");
				scan.nextLine();
			}
		}
	}

}
