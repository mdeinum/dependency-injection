package biz.deinum.moneytransfer.interfaze;

import biz.deinum.moneytransfer.repository.MapBasedAccountRepository;
import biz.deinum.moneytransfer.repository.MapBasedTransactionRepository;

import biz.deinum.moneytransfer.repository.TransactionRepository;
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

		Injections.inject(service, accountRepository, transactionRepository);

		var transaction = service.transfer("123456", "654321", new BigDecimal("250.00"));

		logger.info("Money Transfered: {}", transaction);

	}

}
