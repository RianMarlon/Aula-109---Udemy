package modelo.aplicacao10;

import java.util.Locale;
import java.util.Scanner;

import modelo.entidades10.Account;
import modelo.entidades10.SaqueException;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter account data");
		try {
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			sc.nextLine();
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account (number, holder,balance, withdrawLimit);
			
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			
			account.withdraw(amount);

		}catch (RuntimeException e) {
			System.out.print("Unexpected error!");
			
		}catch (SaqueException e) {
			System.out.print("Withdraw error: "+ e.getMessage());
		}
		
		sc.close();
	

	}

}
