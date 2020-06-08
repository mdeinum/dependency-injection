package biz.deinum.moneytransfer.repository;

import biz.deinum.moneytransfer.domain.Account;

/**
 * @author Marten Deinum
 */
public interface AccountRepository {

	Account find(String number);

}
