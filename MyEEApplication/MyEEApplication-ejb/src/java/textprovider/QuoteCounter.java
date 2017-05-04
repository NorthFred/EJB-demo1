/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textprovider;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author frede
 * 
 * Singleton that counts the quotes generated.
 */

@Startup
@Singleton
@LocalBean
public class QuoteCounter {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int counter;
    
    public void increaseCounter() {
        
        counter++;
        
    }
    
    public int getCounterValue() {
        
        return counter;
        
    }
    
    // @PostConstruct and @PreDestroy methods

    @PostConstruct
    public void startProgram() {
        
        System.out.println("*** INFO: ");
        System.out.println("*** The program has been started at: ");
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String time = df.format(dateobj);
        
        System.out.println("*** " + time);
        System.out.println("**************************************");
                        
    }

    @PreDestroy
    public void endProgram() {

        System.out.println("*** INFO: ");
        System.out.println("*** The program has been ended at: ");

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String time = df.format(dateobj);

        System.out.println("*** " + time);
        System.out.println("**************************************");

    }
    
    
}
