package com.revature.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerTransaction {

	private int accountID;
	private double amount;
	private String trasancitonType;
	private int trasanciontPartner;
	private LocalTime timeCreated;
	private LocalDate dateCreated;
	
	public CustomerTransaction(){
		super();
	}


	public CustomerTransaction(int accountID, double amount, String trasancitonType, int trasanciontPartner, LocalTime timeCreated, LocalDate dateCreated) {
		super();
		this.accountID = accountID;
		this.amount = amount;
		this.trasancitonType = trasancitonType;
		this.trasanciontPartner = trasanciontPartner;
		this.timeCreated=timeCreated;
		this.dateCreated=dateCreated;
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


	public LocalTime getTimeCreated() {
		return timeCreated;
	}


	public void setTimeCreated(LocalTime timeCreated) {
		this.timeCreated = timeCreated;
	}


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Override
	public String toString() {
		return "CustomerTransaction [accountID=" + accountID + ", amount=" + amount + ", trasancitonType="
				+ trasancitonType + ", trasanciontPartner=" + trasanciontPartner + ", timeCreated=" + timeCreated
				+ ", dateCreated=" + dateCreated + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((timeCreated == null) ? 0 : timeCreated.hashCode());
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
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (timeCreated == null) {
			if (other.timeCreated != null)
				return false;
		} else if (!timeCreated.equals(other.timeCreated))
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
