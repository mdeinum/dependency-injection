package biz.deinum.moneytransfer.interfaze;

import biz.deinum.moneytransfer.repository.AccountRepository;
import biz.deinum.moneytransfer.repository.TransactionRepository;

/**
 * Helper class to determine which beans to inject into the bean.
 *
 * @author Marten Deinum
 */
public abstract class Injections {

    private Injections() {}

    public static void inject(Object bean, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        if (bean instanceof AccountRepositoryAware) {
            ((AccountRepositoryAware) bean).setAccountRepository(accountRepository);
        }

        if (bean instanceof TransactionRepositoryAware) {
            ((TransactionRepositoryAware) bean).setTransactionRepository(transactionRepository);
        }
    }
}
