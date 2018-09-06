package com.egg.utils;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.util.ResourceUtils;
import sun.reflect.Reflection;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

public class Log4j {

    private static Logger logger = null;

    private static String className = Reflection.getCallerClass(2).getName();

    private static Logger getLogger() {

        String configPath = null;
        try {
            configPath = ResourceUtils.getFile("classpath:log4j.properties").getPath();
        } catch (FileNotFoundException why) {
            return null;
        }

        if (logger == null) {
            PropertyConfigurator.configure(configPath);
            logger = Logger.getLogger(Reflection.getCallerClass(2).getName());
        }
        return logger;
    }

    public static void info(String msg) {
        logger = getLogger();
        if (logger != null) {
            getLogger().info(className + msg + '\n');
        }
    }

    public static void warn(String msg) {
        logger = getLogger();
        if (logger != null) {
            getLogger().warn(className + msg + '\n');
        }
    }

    public static void error(String msg) {
        logger = getLogger();
        if (logger != null) {
            getLogger().error(className + msg + '\n');
        }
    }

    public static void debug(String msg) {
        logger = getLogger();
        if (logger != null) {
            getLogger().debug(className + msg + '\n');
        }
    }
}
