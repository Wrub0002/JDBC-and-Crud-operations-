package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;

/**
 * DBConnection class implements the Singleton Design Pattern to manage database connection.
 */
public class DBConnection {

    private static DBConnection instance = null;
    private Connection connection = null;
    private static final LMSLogger logger = LMSLogger.getInstance();

    /**
     * Private constructor to prevent instantiation.
     * Loads database properties and establishes a connection.
     */
    private DBConnection() {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src/main/resources/database.properties"))) {
            props.load(in);

            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");

            this.connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException e) {
            logger.log(LogLevel.ERROR, "Failed to create DBConnection: " + e.getMessage(), e);
        }
    }

    /**
     * Ensures only one instance of DBConnection exists.
     *
     * @return the single instance of DBConnection
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    /**
     * @return the database connection
     */
    public Connection getConnection() {
        return connection;
    }
}
