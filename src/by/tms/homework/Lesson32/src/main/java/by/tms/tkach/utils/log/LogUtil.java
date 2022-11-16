package by.tms.tkach.utils.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    private static final Logger logger = LogManager.getLogger();

    public static void printInfo(String message) {
        logger.info(message);

    }
}
