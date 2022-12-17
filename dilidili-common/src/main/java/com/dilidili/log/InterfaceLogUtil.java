package com.dilidili.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterfaceLogUtil {

    private static Logger logger = LogManager.getLogger("interface");

    private static String success = "success";

    private static String fail = "fail";

    public static void cliSuccess(String msg) {
        logger.info("res: {}, msg: {}", success, msg);
    }

    public static void cliFail(String msg) {
        logger.error("res: {}, msg: {}", fail, msg);
    }
}
