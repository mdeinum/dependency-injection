package biz.deinum.moneytransfer.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author Marten Deinum
 */
public class TransferMoney {

	private static final Logger logger = LoggerFactory.getLogger(TransferMoney.class);

	public static void main(String[] args) {
		var service = new SimpleMoneyTransferService();

		var transaction = service.transfer("123456", "654321", new BigDecimal("250.00"));

		logger.info("Money Transfered: {}", transaction);

	}

}
