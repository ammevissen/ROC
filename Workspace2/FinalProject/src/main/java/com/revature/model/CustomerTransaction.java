package com.revature.model;

public class CustomerTransaction {

	private int accountID;
	private double amount;
	private String trasancitonType;
	private int trasanciontPartner;
	
	
	public CustomerTransaction(){
		super();
	}


	public CustomerTransaction(int accountID, double amount, String trasancitonType, int trasanciontPartner) {
		super();
		this.accountID = accountID;
		this.amount = amount;
		this.trasancitonType = trasancitonType;
		this.trasanciontPartner = trasanciontPartner;
	}


	public int getAccountID() {
		return accountID;
	}


	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getTrasancitonType() {
		return trasancitonType;
	}


	public void setTrasancitonType(String trasancitonType) {
		this.trasancitonType = trasancitonType;
	}


	public int getTrasanciontPartner() {
		return trasanciontPartner;
	}


	public void setTrasanciontPartner(int trasanciontPartner) {
		this.trasanciontPartner = trasanciontPartner;
	}


	@Override
	public String toString() {
		return "CustomerTransaction [accountID=" + accountID + ", amount=" + amount + ", trasancitonType="
				+ trasancitonType + ", trasanciontPartner=" + trasanciontPartner + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + trasanciontPartner;
		result = prime * result + ((trasancitonType == null) ? 0 : trasancitonType.hashCode());
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
		CustomerTransaction other = (CustomerTransaction) obj;
		if (accountID != other.accountID)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (trasanciontPartner != other.trasanciontPartner)
			return false;
		if (trasancitonType == null) {
			if (other.trasancitonType != null)
				return false;
		} else if (!trasancitonType.equals(other.trasancitonType))
			return false;
		return true;
	}
	
	
	
}
