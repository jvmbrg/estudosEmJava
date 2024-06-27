package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Account number: ");
			Integer number = sc.nextInt();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.println();
			System.out.print("Enter amount for deposit: ");
			amount = sc.nextDouble();
			account.deposit(amount);
			
		}
		catch(RuntimeException e) {
			System.out.println("Error unexpected");
		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		} 
		
		 
		sc.close();
	}

}
