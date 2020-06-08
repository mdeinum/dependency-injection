package biz.deinum.moneytransfer.setter;

import biz.deinum.moneytransfer.repository.MapBasedAccountRepository;
import biz.deinum.moneytransfer.repository.MapBasedTransactionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Marten Deinum
 */
public class TransferMoney {

	private static final Logger logger = LoggerFactory.getLogger(TransferMoney.class);

	public static void main(String[] args) {
		var transactionRepository = new MapBasedTransactionRepository();

		var accountRepository = new MapBasedAccountRepository();
		accountRepository.initialize();

		var service = new MoneyTransferService();
		service.setAccountRepository(accountRepository);
		service.setTransactionRepository(transactionRepository);

		var transaction = service.transfer("123456", "654321", new BigDecimal("250.00"));


		logger.info("Money Transfered: {}", transaction);

	}

}
