package biz.deinum.moneytransfer;

import java.math.BigDecimal;

import biz.deinum.moneytransfer.domain.MoneyTransferTransaction;
import biz.deinum.moneytransfer.domain.Transaction;
import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;

/**
 * Base class for {@link MoneyTransferService} implementations. This class implements the business logic to transfer
 * money. Subclasses must implement the techniques to retrieve the repositories.
 *
 * @author Marten Deinum
 */
public abstract class AbstractMoneyTransferService implements MoneyTransferService {

	@Override
	public Transaction transfer(String source, String target, BigDecimal amount) {
		var src = getAccountRepository().find(source);
		var dst = getAccountRepository().find(target);

		src.credit(amount);
		dst.debit(amount);

		var transaction = new MoneyTransferTransaction(src, dst, amount);
		return getTransactionRepository().store(transaction);
	}

	protected abstract AccountRepository getAccountRepository();

	protected abstract TransactionRepository getTransactionRepository();

}
