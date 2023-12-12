package com.juvenxu.mvnbook.account.email;

/**
 * @author qiuxianbao
 * @date 2023/11/11
 * @since ace_1.2.1_xinchuang_20231030
 */
public interface AccountEmailService {
    void sendEmail(String to, String subject, String htmlText) throws AccountEmailException;
}
