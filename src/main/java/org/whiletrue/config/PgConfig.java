package org.whiletrue.config;

import org.whiletrue.service.PropertiesService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PgConfig implements DatabaseConfig {
    public Connection createConnection() {
        try {
            String url = PropertiesService.getProperty("db_url").orElseThrow();
            Properties props = new Properties();
            props.setProperty("user", PropertiesService.getProperty("db_user").orElseThrow());

            return DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
