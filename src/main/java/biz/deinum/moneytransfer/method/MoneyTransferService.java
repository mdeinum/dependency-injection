package biz.deinum.moneytransfer.method;

import biz.deinum.moneytransfer.AbstractMoneyTransferService;
import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;

/**
 * This implementation of the {@code MoneyTransferService} uses a method {@code initialize} to get the needed dependencies.
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

	public void initialize(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository=accountRepository;
		this.transactionRepository=transactionRepository;
	}

}
