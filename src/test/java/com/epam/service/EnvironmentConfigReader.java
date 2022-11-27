package com.epam.service;

import java.util.ResourceBundle;

public class EnvironmentConfigReader {
    private static final ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getEnvironmentData(String keyValue) {
        return bundle.getString(keyValue);
    }
}
