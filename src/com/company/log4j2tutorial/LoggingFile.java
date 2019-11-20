package com.company.log4j2tutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
In order to log into a file we needed to change the appender in the log4j2.xml
We add a Properties tag in which we create a file to save the logs, we add a RollingFile tag in which we define how
the file is saved and we changed the AppenderRef to "File" instead of "Console".
 */
public class LoggingFile {
    private static final Logger log = LogManager.getLogger("loggingfile");

    public static void main(String[] args) {
        log.trace("Trace Message Logged");
        log.debug("Debug Message Logged");
        log.info("Info Message Logged");
        log.error("Error Message Logged");
        log.fatal("Fatal Message Logged");
    }
}
