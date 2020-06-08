package biz.deinum.moneytransfer.constructor;

import biz.deinum.moneytransfer.AbstractMoneyTransferService;
import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;

/**
 * @author Marten Deinum
 */
class MoneyTransferService extends AbstractMoneyTransferService {

	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;

	public MoneyTransferService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		super();
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
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
