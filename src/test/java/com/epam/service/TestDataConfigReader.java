package com.epam.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TestDataConfigReader {
    private static final Logger logger = LogManager.getRootLogger();

    public static String getEnvironmentData(String keyValue) {
        try (InputStream stream = new FileInputStream(System.getProperty("environment"))) {
            Properties properties = new Properties();
            properties.load(stream);
            return properties.getProperty(keyValue);
        } catch (IOException e) {
            logger.warn("Retrieving data from property file is corrupted");
        }
        return null;
    }
}
