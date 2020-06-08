package biz.deinum.moneytransfer.setter;

import biz.deinum.moneytransfer.AbstractMoneyTransferService;
import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;

/**
 * This implementation of the {@code MoneyTransferService} uses 2 setters {@code setAccountRepository} and
 * {@code setTransactionRepository} to get the dependencies injected.
 *
 * @author Marten Deinum
 *
 * @see TransferMoney
 */
class MoneyTransferService extends AbstractMoneyTransferService {

	private AccountRepository accountRepository;
	private TransactionRepository transactionRepository;

	@Override
	protected AccountRepository getAccountRepository() {
		return this.accountRepository;
	}

	@Override
	protected TransactionRepository getTransactionRepository() {
		return this.transactionRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

}
