package Bank;

public class BankAccount {
	public int accNo;
	public String custname;
	public String accType;
	public float balance;

	public BankAccount(int accNo, String custname, String accType, float balance)
			throws LowBalanceException, NegativeAmountException {
		if (balance < 0)
			throw new NegativeAmountException("Balance is in positive only");
		if (balance < 1000 && accType.equalsIgnoreCase("savings"))
			throw new LowBalanceException("Minimum 1000rs required to open saving account");
		if (balance < 5000 && accType.equalsIgnoreCase("Current"))
			throw new LowBalanceException("Minimum 5000rs required to open current account");
		this.accNo = accNo;
		this.custname = custname;
		this.accType = accType;
		this.balance = balance;
		System.out.println("Account created Successfully!!!");
	}

	public void deposit(float amount) throws NegativeAmountException {
		if (amount < 0)
			throw new NegativeAmountException("Deposite amount must be positive");
		balance += amount;
		System.out.println("Amount deposited! Balance : " + balance);
		System.out.println("New Balance: " + balance);
	}

	public void withdraw(float amt) throws NegativeAmountException, InsufficientFundsException {
		if (amt < 0) {
			throw new NegativeAmountException("Cannot withdraw a negative amount");
		}

		float minBalance = 0;

		if (accType.equalsIgnoreCase("Savings")) {
			minBalance = 1000;
			if (balance - amt < minBalance) {
				throw new InsufficientFundsException("Not enough balance to withdraw yiu entered money");
			}
		} else if (accType.equalsIgnoreCase("Current")) {
			minBalance = 5000;
			if (balance - amt < minBalance) {
				throw new InsufficientFundsException("Not enough balance to withdraw yiu entered money");
			}
		} else {
			System.out.println("Unknown account type - Withdrawal not allowed");
		}
		balance -= amt;
		System.out.println("Withdrawn Rs. " + amt + " successfully");
		System.out.println("Remaining balance : " + balance);
	}

	public float getBalance() throws LowBalanceException {
		float minBalance = 0;

		if (accType.equalsIgnoreCase("Savings")) {
			minBalance = 1000;
			if (balance < minBalance) {
				throw new LowBalanceException("Current balance is low ");
			}
		} else if (accType.equalsIgnoreCase("Current")) {
			minBalance = 5000;
			if (balance < minBalance) {
				throw new LowBalanceException("Current balance is low ");
			}
		} else {
			System.out.println("Unknown account type");
		}
		return balance;
	}
}
