package org.whiletrue.config;

import java.sql.Connection;

public interface DatabaseConfig {
    Connection createConnection();
}
