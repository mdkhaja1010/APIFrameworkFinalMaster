package DriverManagers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerManager {

    private static boolean root=false;
    public static Logger getLogger(Class cls){
        if(root){
            return Logger.getLogger(cls);
        }
        PropertyConfigurator.configure("log4j.properties");
         root =true;
         return Logger.getLogger(cls);
    }
    public static void main(String[] args){
        Logger log=LoggerManager.getLogger(LoggerManager.class);
        log.info("Log main class");
    }
}
