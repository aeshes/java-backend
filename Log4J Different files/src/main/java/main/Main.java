package main;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);
    private static final Logger infoLogger = Logger.getLogger("info");
    private static final Logger errorLogger = Logger.getLogger("error");


    public static void main(String[] args) {
        infoLogger.info("info");
        errorLogger.error("error");
    }
}
