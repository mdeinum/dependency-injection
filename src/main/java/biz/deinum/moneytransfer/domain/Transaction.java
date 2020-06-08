package biz.deinum.moneytransfer.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Base class for transaction subclasses.
 *
 * @author Marten Deinum
 */
public abstract class Transaction {

	private final Account source;
	private final BigDecimal amount;
	private final Date date = new Date();

	protected Transaction(final Account source, final BigDecimal amount) {
		super();
		this.source = source;
		this.amount = amount;
	}

	public Account getSource() {
		return this.source;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public Date getDate() {
		return this.date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(source, amount, date);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		var that = (Transaction) o;
		return source.equals(that.source) && amount.equals(that.amount) && date.equals(that.date);
	}

	@Override
	public String toString() {
		return String.format("Transaction (source=%s, amount=%s, date=%s)", this.source, this.amount, this.date);
	}

}
