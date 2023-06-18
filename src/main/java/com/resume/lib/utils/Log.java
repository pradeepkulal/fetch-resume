package com.resume.lib.utils;

import org.apache.log4j.Logger;

public class Log {

    private static final Logger logger = Logger.getLogger(Log.class.getName());


    public static void info(Object message){
        logger.info(message);
    }

    public static void warn(Object message){
        logger.info(message);
    }

    public static void error(Object message){
        logger.info(message);
    }

    public static void fatal(Object message){
        logger.info(message);
    }

    public static void debug(Object message){
        logger.info(message);
    }
}
