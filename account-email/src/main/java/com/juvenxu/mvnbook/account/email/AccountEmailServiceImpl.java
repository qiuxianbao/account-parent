package com.juvenxu.mvnbook.account.email;

import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author qiuxianbao
 * @date 2023/11/11
 * @since ace_1.2.1_xinchuang_20231030
 */
public class AccountEmailServiceImpl implements AccountEmailService {

    private JavaMailSender javaMailSender;
    private String systemEmail;


    @Override
    public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException {
        // TODO-QIU: 2023年11月11日, 0011
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        javaMailSender.send();
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
