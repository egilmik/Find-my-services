/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egil.findmyservice;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author Egil
 */
public class GmailReader {

    public void connect(String mail, String password) throws MessagingException {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imap");
        props.setProperty("mail.imap.port", "993");

        Session session = Session.getDefaultInstance(props);
        
        Store store = session.getStore("imap");
        store.connect("imap.googlemail.com",mail, password);
        int messageCount = store.getFolder("\"[Gmail]/Spam\"").getMessageCount();
        System.out.println("Message count" + messageCount);

        System.out.println("Port: " + session.getProperty("mail.smtp.port"));
    }
}
