package example.testing.utils;

public class Money_Tmp {
	private final int amount;
	private final String currency;

	public Money_Tmp(int amount, String currency) {
		if(amount < 0) {
			throw new IllegalArgumentException("illegal negative amount :[" + amount +"]");
		}
		if(currency == null || currency.isEmpty()) {
			throw new IllegalArgumentException(
					"illegal currency: [" + currency + "] it can not be null or empty");
		}
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public boolean equals(Object o) {
		if (o instanceof Money_Tmp) {
			Money_Tmp money = (Money_Tmp) o;
			return money.getCurrency().equals(getCurrency()) && getAmount() == money.getAmount();
		}
		return false;
	}
}
