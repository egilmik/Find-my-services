package com.egil.findmyservice;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length == 2){
            String mail = args[0];
            String password = args[1];
            GmailReader reader = new GmailReader();
            try {
                reader.connect(mail, password);
            } catch (MessagingException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return;
        }
    }
}
