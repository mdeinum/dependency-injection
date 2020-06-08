package biz.deinum.moneytransfer.field;

import biz.deinum.moneytransfer.AbstractMoneyTransferService;
import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;

/**
 * {@code MoneyTransferService} implementation which needs fields to be set after
 * construction of the object.
 *
 * @author Marten Deinum
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

}
