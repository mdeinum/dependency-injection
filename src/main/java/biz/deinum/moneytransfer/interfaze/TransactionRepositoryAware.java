package biz.deinum.moneytransfer.interfaze;

import biz.deinum.moneytransfer.repository.TransactionRepository;

public interface TransactionRepositoryAware {

    void setTransactionRepository(TransactionRepository repo);
}
