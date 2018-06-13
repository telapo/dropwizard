/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlandfiles;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author davide
 */
public class MyLogger {
    
    private static MyLogger instance = null;
    /*
     * Logger used to log messages; it is equivalent to Logger.getLogger()
     */
    private Logger logger;


    public static MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
            prepareLogger(instance);
        }
        return instance;
    }


    private static void prepareLogger(MyLogger i) {
        try {
            FileHandler fh = new FileHandler("/home/davide/java_log_%u.log", 500000, 1, true);
            fh.setFormatter(new SimpleFormatter());
            i.logger = Logger.getLogger("Java Logging");
            i.logger.addHandler(fh);
            i.logger.setUseParentHandlers(false);
            /*
            LEVELS:
            1. SEVERE
            2. WARNING
            3. INFO
            4. CONFIG
            5. FINE
            6. FINER
            7. FINEST
            ALL
             */
            i.logger.setLevel(Level.ALL);
        } catch (IOException ex) {
            Logger.getLogger(MyLogger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MyLogger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public Logger getLogger() {
        return logger;
    }


}
