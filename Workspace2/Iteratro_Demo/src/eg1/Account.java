package eg1;

public class Account{// implements Comparable<Account>{

	private long accountId;
	private String customerName;
	private double currentBalance;
	private float ratings;
	private boolean active;
	
	public Account() {
		super();
	}

	
	
	public Account(long accountId, String customerName, double currentBalance, float ratings, boolean active) {
		super();
		this.accountId = accountId;
		this.customerName = customerName;
		this.currentBalance = currentBalance;
		this.ratings = ratings;
		this.active = active;
	}



	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerName=" + customerName + ", currentBalance="
				+ currentBalance + ", ratings=" + ratings + ", active=" + active + "]";
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + (active ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(currentBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + Float.floatToIntBits(ratings);
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
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (active != other.active)
			return false;
		if (Double.doubleToLongBits(currentBalance) != Double.doubleToLongBits(other.currentBalance))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (Float.floatToIntBits(ratings) != Float.floatToIntBits(other.ratings))
			return false;
		return true;
	}
	
//	@Override
//	public int compareTo(Account o) {
//		Long l1=this.accountId;
//		Long l2=o.accountId;
//		return l1.compareTo(l2);
//	}
	
}

