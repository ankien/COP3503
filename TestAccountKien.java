import java.util.*;

/*  Andrew Kien
 *  This program simulates an ATM.
 *  It asks the user for their ID. If the ID is valid;
 *  they can check the balance, withdraw money, deposit money, or exit their account.
 */ 

public class TestAccountKien {
	public static void main(String[] args) {
		
		// Stage 1: Initialization of user account ids.
		int[] accountIds = {9801, 2345, 3025, 1024, 4096, 6021, 8192, 5768, 7113, 1497};
		
		// Stage 2: Initialization of the array of accounts.
		Account[] accounts = new Account[10];
		
		// Stage 3: Populates each account with their id and a random balance value.
		for(int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(accountIds[i], Math.random());
		}
		
		Scanner input = new Scanner(System.in);
		while(true) {
			
			System.out.println("******************Welcome! Welcome!*****************\n"
							 + "****************************************************\n");
			
			// Stage 4: Performs a linear search to check if user's input is a valid account.
			System.out.print("Please enter a correct id: ");
			int idValue;
			boolean correctIdValue = false;
			int userAccountIndex = 0;
			do {
				idValue = input.nextInt();
				for(int i = 0; i < accountIds.length; i++) {
					if(idValue == accountIds[i]) {
						userAccountIndex = i;
						correctIdValue   = true;
					}
				}
			} while(correctIdValue == false);
				
			// Stage 5: Prompts the user for input with menu options.
			int j = 1;
			while(j == 1) {
				int option;
					
				System.out.println("******************** Main Menu *********************\n"
								 + "****************************************************\n"
								 + "                 1: check balance\n"
								 + "                 2: withdraw\n"
								 + "                 3: deposit\n"
								 + "                 4: exit");
				System.out.print("Enter a choice: ");
				option = input.nextInt();
				System.out.println("****************************************************");
				
				switch (option) {
					case  1:
						System.out.print("The balance is    ");
						System.out.printf("%.2f\n", accounts[userAccountIndex].getBalance());
						break;
					case  2:
						System.out.print("Enter an amount to withdraw: ");
						double withdrawal = input.nextDouble();
						if (withdrawal > accounts[userAccountIndex].getBalance()) {
							System.out.println("The amount is too large!  ignored!");
						}
						else {
							accounts[userAccountIndex].withdraw(withdrawal);
							System.out.printf("Take your cash. Your current balance is  %.2f\n", accounts[userAccountIndex].getBalance());
						}
						break;
					case  3:
						System.out.print("Enter an amount to deposit: ");
						double deposited = input.nextDouble();
						if (deposited < 0.0) {
							System.out.println("The amount is negative, ignored");
						}
						else {
							accounts[userAccountIndex].deposit(deposited);
							System.out.printf("$ %.2f  deposited. Your current balance is  %.2f\n", deposited, accounts[userAccountIndex].getBalance());
						}
						break;
					case  4:
						System.out.println("*******Thank you! Have a nice day! Good bye!********\n"
										 + "****************************************************\n");
						j--;
						break;
					default:
						System.out.println("Invalid option, please re-enter.");
				}
			}
			j++;
		}
	}
}

class Account {
	
	private int id;
	private double balance;
	
	public Account() {
		id = 0;
		balance = 0.0;
	}
	
	public Account(int id, double balance) {
		setId(id);
		setBalance(balance);
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	/*  Sets the balance of an account to a random value between 0-5000
	 *  It is invoked in TestAccount with another random()
	 */
	public void setBalance(double balance) {
		this.balance = Math.random() * 5000;
	}
	
	/*  Withdraws a user-defined amount from the balance
	 *  Only set to run if the withdrawal amount is lower than or equal to balance
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	/*  Deposits a user-defined amount to their account balance
	 *  Only set to run if the deposited amount is positive
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}
}
