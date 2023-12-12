package com.juvenxu.mvnbook.account.persist;

/**
 * 异常
 * @author qiuxianbao
 * @since 2023/11/11
 */
public class AccountPersistException extends RuntimeException {

    public AccountPersistException(String message, Throwable cause) {
        super(message, cause);
    }
}
