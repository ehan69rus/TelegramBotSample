package org.whiletrue.service;

import java.io.FileInputStream;
import java.util.Optional;
import java.util.Properties;

public class PropertiesService {
    static final String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "app.properties";

    static public Optional<String> getProperty(String propertyName) {
        Properties properties = new Properties();
        String property = null;

        try (FileInputStream inputStream = new FileInputStream(rootPath)) {
            properties.load(inputStream);
            property = properties.getProperty(propertyName);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return Optional.ofNullable(property);
    }
}
