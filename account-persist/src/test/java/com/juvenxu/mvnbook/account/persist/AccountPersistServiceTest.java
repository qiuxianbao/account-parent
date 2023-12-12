package com.juvenxu.mvnbook.account.persist;

import com.juvenxu.mvnbook.account.persist.service.AccountPersistService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * @author qiuxianbao
 * @since ace_1.2.1_xinchuang_20231030
 */
public class AccountPersistServiceTest {
    private AccountPersistService service;

    @Before
    public void setUp() throws Exception{
        File persistDataFile = new File("target/test-classes/persist-data.xml");
        if (persistDataFile.exists()) {
            persistDataFile.delete();
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("account-persist.xml");
        service = (AccountPersistService)context.getBean("accountPersistService");
    }

    @Test
    public void testReadAccount() {
        Account account = service.readAccount("juven");
//        Assert.assertNotNull(account);
//        Assert.assertEquals("juven", account.getId());
    }
}
