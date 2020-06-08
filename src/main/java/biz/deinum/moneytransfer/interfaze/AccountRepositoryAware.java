package biz.deinum.moneytransfer.interfaze;

import biz.deinum.moneytransfer.repository.AccountRepository;

public interface AccountRepositoryAware {

    void setAccountRepository(AccountRepository repo);
}
