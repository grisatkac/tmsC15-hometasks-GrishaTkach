package by.tms.tkach.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
    private static final Logger logger = LogManager.getLogger();

    public static void printInfoLog(String message) {
        logger.info(message);
    }
}
