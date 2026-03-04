package com.orangehrmlive.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {

  private static final Logger LOGGER = LogManager.getLogger(LogUtils.class);
  public static void info(String message){LOGGER.info(message);}
    public static void info(Object message){LOGGER.info(message);}
    public static void info(String message, Throwable throwable) {
        LOGGER.info(message);
    }
    public static void warn(String message) {
        LOGGER.warn(message);
    }

    public static void warn(Object message) {
        LOGGER.warn(message);
    }

    //Error Level Logs
    public static void error(String message) {
        LOGGER.error(message);
    }

    public static void error(String message, Throwable throwable) {
        LOGGER.error(message);
    }

    public static void error(Object message) {
        LOGGER.error(message);
    }

    public static void error(Object message, Throwable throwable) {
        LOGGER.error(message);
    }


}
