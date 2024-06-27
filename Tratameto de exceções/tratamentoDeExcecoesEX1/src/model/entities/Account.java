package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	private Integer number;
	private String holder;
	private Double balance, withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) throws DomainExceptions{
		if(amount <= 0) {
			throw new DomainExceptions("Deposit error: Value reported less than or equal to 0");
		}
		balance += amount;
		System.out.println("New balance: "+ getBalance());
	}
	
	public void withdraw(Double amount) throws DomainExceptions {
		if(amount > getWithdrawLimit()) {
			throw new DomainExceptions("Withdraw error: the amount exceeds withdraw limit");
		}
		if(amount > getBalance()) {
			throw new DomainExceptions("Withdraw error: the amount exceeds balance limit");
		}
		balance -= amount;
		System.out.println("New balance: "+ getBalance());
	}
	
}
