package org.whiletrue.service;

import org.whiletrue.config.DatabaseConfig;
import org.whiletrue.config.PgConfig;

import java.sql.Connection;
import java.util.Objects;

public class DatabaseConnectionService {
    private static final DatabaseConfig databaseConfig = new PgConfig();

    private static Connection connection;

    public static Connection connection() {
        if (Objects.isNull(connection)) {
            connection = databaseConfig.createConnection();
        }

        return connection;
    }
}
