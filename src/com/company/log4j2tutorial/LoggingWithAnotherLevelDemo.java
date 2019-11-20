package com.company.log4j2tutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
In order to test that logs in different files print the logs with different levels we added the Logger tags
in the xml and pass the name to the getLoggger() method
 */
public class LoggingWithAnotherLevelDemo {
    private static final Logger log = LogManager.getLogger("log4j2withanotherleveldemo");

    public static void main(String[] args) {
        log.trace("Trace Message Logged");
        log.debug("Debug Message Logged");
        log.info("Info Message Logged");
        log.error("Error Message Logged");
        log.fatal("Fatal Message Logged");
    }
}
