package biz.deinum.moneytransfer.field;

import biz.deinum.moneytransfer.repository.MapBasedAccountRepository;
import biz.deinum.moneytransfer.repository.MapBasedTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Map;

import static biz.deinum.moneytransfer.field.ReflectionUtil.setFieldsByName;
import static biz.deinum.moneytransfer.field.ReflectionUtil.setFieldsByType;

/**
 * @author Marten Deinum
 */
public class TransferMoney {

    private static final Logger logger = LoggerFactory.getLogger(TransferMoney.class);

    public static void main(String[] args) {
        var accountRepository = new MapBasedAccountRepository();
        accountRepository.initialize();

        var transactionRepository = new MapBasedTransactionRepository();
        var service = new MoneyTransferService();

        var context = Map.of(
                "accountRepository", accountRepository,
                "transactionRepository", transactionRepository);
        setFieldsByName(service, context);
//        setFieldsByType(service, context);

        var transaction = service.transfer("123456", "654321", new BigDecimal("250.00"));

        logger.info("Money Transfered: {}", transaction);

    }
}
