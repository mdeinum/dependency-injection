package biz.deinum.moneytransfer.simple;

import biz.deinum.moneytransfer.AbstractMoneyTransferService;
import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.MapBasedAccountRepository;
import biz.deinum.moneytransfer.repository.MapBasedTransactionRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;

/**
 * {@code MoneyTransferService} implementation which instantiates the needed beans itself.
 *
 * @author Marten Deinum
 */
class SimpleMoneyTransferService extends AbstractMoneyTransferService {

	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	public SimpleMoneyTransferService() {
		super();
		this.accountRepository = new MapBasedAccountRepository() {{initialize();}};
		this.transactionRepository = new MapBasedTransactionRepository();
	}

	@Override
	protected AccountRepository getAccountRepository() {
		return this.accountRepository;
	}

	@Override
	protected TransactionRepository getTransactionRepository() {
		return this.transactionRepository;
	}

}
