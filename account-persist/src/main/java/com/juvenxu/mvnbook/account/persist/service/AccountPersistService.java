package com.juvenxu.mvnbook.account.persist.service;

import com.juvenxu.mvnbook.account.persist.Account;
import com.juvenxu.mvnbook.account.persist.AccountPersistException;

/**
 *
 * @author qiuxianbao
 * @since 2023/11/11
 */
public interface AccountPersistService {
    Account createAccount(Account account) throws AccountPersistException;
    Account readAccount(String id) throws AccountPersistException;
    Account updateAccount(Account account) throws AccountPersistException;
    void deleteAccount(String id) throws AccountPersistException;
}
