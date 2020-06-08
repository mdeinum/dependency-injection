package biz.deinum.moneytransfer.repository;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import biz.deinum.moneytransfer.domain.Account;

/**
 * @author Marten Deinum
 */
public class MapBasedAccountRepository implements AccountRepository {

	private final Logger logger = LoggerFactory.getLogger(MapBasedAccountRepository.class);

	private final ConcurrentMap<String, Account> storage = new ConcurrentHashMap<>();

	public MapBasedAccountRepository() {
		super();
	}

	public void initialize() {
		var acct1 = new Account("123456");
		acct1.setOwner("M. Deinum");
		acct1.debit(new BigDecimal("1000"));

		var acct2 = new Account("654321");
		acct2.setOwner("R. Johnson");
		acct2.debit(new BigDecimal("10000"));

		store(acct1);
		store(acct2);

	}

	@Override
	public Account find(String number) {
		var account = this.storage.get(number);
		if (account == null) {
			throw new IllegalArgumentException("Non-Existing account " + number + ".");
		}
		return account;
	}

	public void store(Account account) {
		if (!this.storage.containsValue(account)) {
			this.logger.info("Stored account {}.", account);
			this.storage.put(account.getNumber(), account);
		} else {
			this.logger.info("Already existing account {}.", account.getNumber());
		}
	}

}
