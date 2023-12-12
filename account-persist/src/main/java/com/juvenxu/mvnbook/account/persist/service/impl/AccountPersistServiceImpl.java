package com.juvenxu.mvnbook.account.persist.service.impl;

import com.juvenxu.mvnbook.account.persist.Account;
import com.juvenxu.mvnbook.account.persist.AccountPersistException;
import com.juvenxu.mvnbook.account.persist.service.AccountPersistService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author qiuxianbao
 * @since ace_1.2.1_xinchuang_20231030
 */
public class AccountPersistServiceImpl implements AccountPersistService {
    private static final String ELEMENT_ROOT = "account-persist";
    private static final String ELEMENT_ACCOUNTS = "accounts";
    private static final String ELEMENT_ACCOUNT_ID = "id";
    private static final String ELEMENT_ACCOUNT_NAME = "name";
    private static final String ELEMENT_ACCOUNT_PASSWORD = "password";
    private static final String ELEMENT_ACCOUNT_ACTIVATED = "activated";

    private String file;
    private SAXReader reader = new SAXReader();

    @Override
    public Account createAccount(Account account) throws AccountPersistException {
        return null;
    }

    @Override
    public Account readAccount(String id) throws AccountPersistException {
        Document doc = readDocument();
        Element accountsEle = doc.getRootElement().element(ELEMENT_ACCOUNTS);
        for (Element accountEle : (List<Element>) accountsEle.elements()) {
            if (accountEle.elementText(ELEMENT_ACCOUNT_ID).equals(id)) {
                return buildAccount(accountEle);
            }
        }

        return null;
    }

    @Override
    public Account updateAccount(Account account) throws AccountPersistException {
        return null;
    }

    @Override
    public void deleteAccount(String id) throws AccountPersistException {

    }

    private Account buildAccount(Element accountEle) {
        Account account = new Account();
        account.setId(accountEle.elementText(ELEMENT_ACCOUNT_ID));
        account.setName(accountEle.elementText(ELEMENT_ACCOUNT_NAME));
        account.setPassword(accountEle.elementText(ELEMENT_ACCOUNT_PASSWORD));
        account.setActivated("true".equals(accountEle.elementText(ELEMENT_ACCOUNT_ACTIVATED)));
        return account;
    }

    private Document readDocument() throws AccountPersistException {
        File dataFile = new File(file);
        if (!dataFile.exists()) {
            dataFile.getParentFile().mkdirs();
            Document doc = DocumentFactory.getInstance().createDocument();
            Element rootEle = doc.addElement(ELEMENT_ROOT);
            rootEle.addElement(ELEMENT_ACCOUNTS);
            writeDocument(doc);
        }

        try {
            return reader.read(new File(file));
        } catch (DocumentException e) {
            throw new AccountPersistException("Unable to read persist data xml", e);
        }
    }

    private void writeDocument(Document doc) {
        Writer out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            XMLWriter writer = new XMLWriter(out, OutputFormat.createPrettyPrint());
            writer.write(doc);
        } catch (IOException e) {
            throw new AccountPersistException("Unable to write persist data xml", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                throw new AccountPersistException("Unable to persist data xml writer", e);
            }
        }
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
