package com.letzAutomate.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jConfig {
    private static final Logger logger = LogManager.getLogger(Log4jConfig.class);

    public static void configure() {
        System.setProperty("log4j.configurationFile", System.getProperty("user.dir") + "\\src\\main\\resources\\Log4j.xml");
        logger.info("Log4j configured successfully");
    }
}