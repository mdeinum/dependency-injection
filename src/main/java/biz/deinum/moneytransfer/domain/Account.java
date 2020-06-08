package biz.deinum.moneytransfer.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Marten Deinum
 */
public class Account {

	private final String number;
	private String owner;
	private BigDecimal balance = BigDecimal.ZERO;

	public Account(final String number) {
		super();
		this.number = number;
	}

	public void debit(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	public void credit(BigDecimal amount) {
		if (this.balance.compareTo(amount) < 0) {
			throw new IllegalArgumentException("Insufficient Funds!");
		}
		this.balance = this.balance.subtract(amount);
	}

	public String getNumber() {
		return this.number;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		var account = (Account) o;
		return Objects.equals(this.number, account.number);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.number);
	}

	@Override
	public String toString() {
		return String.format("Account (number=%s, owner=%s, balance=%s)", this.number, this.owner, this.balance);
	}
}
