package com.juvenxu.mvnbook.account.email;

/**
 * 异常
 * @author qiuxianbao
 * @date 2023/11/11
 */
public class AccountEmailException extends RuntimeException {

    public AccountEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
