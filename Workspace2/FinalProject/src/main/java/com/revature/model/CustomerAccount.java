package com.revature.model;

public class CustomerAccount {

	private int accountNumber;
	private String firstName;
	private String lastName;
	private int checkingID;
	private int savingsID;
	private double checkingBalance;
	private double savingBalance;

	public CustomerAccount(){
		super();
	}
	
	public CustomerAccount(int accountNumber, String firstName, String lastName, int checkingID, int savingsID,
			double checkingBalance, double savingBalance) {
		super();
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.checkingID = checkingID;
		this.savingsID = savingsID;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCheckingID() {
		return checkingID;
	}

	public void setCheckingID(int checkingID) {
		this.checkingID = checkingID;
	}

	public int getSavingsID() {
		return savingsID;
	}

	public void setSavingsID(int savingsID) {
		this.savingsID = savingsID;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}

	@Override
	public String toString() {
		return "CustomerAccount [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", checkingID=" + checkingID + ", savingsID=" + savingsID + ", checkingBalance=" + checkingBalance
				+ ", savingBalance=" + savingBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		long temp;
		temp = Double.doubleToLongBits(checkingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + checkingID;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		temp = Double.doubleToLongBits(savingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + savingsID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerAccount other = (CustomerAccount) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(checkingBalance) != Double.doubleToLongBits(other.checkingBalance))
			return false;
		if (checkingID != other.checkingID)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(savingBalance) != Double.doubleToLongBits(other.savingBalance))
			return false;
		if (savingsID != other.savingsID)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
