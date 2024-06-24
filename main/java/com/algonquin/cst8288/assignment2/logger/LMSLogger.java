package com.algonquin.cst8288.assignment2.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LMSLogger class handles logging with different log levels.
 * Utilizes the singleton design pattern.
 */
public final class LMSLogger {
    private static LMSLogger instance;
    private static PrintWriter writer;
    private static final String LOG_FILE = "application.log";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private LMSLogger() {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            log(LogLevel.ERROR, "Failed to initialize logger: " + e.getMessage());
        }
    }

    /**
     * @return the single instance of LMSLogger
     */
    public static synchronized LMSLogger getInstance() {
        if (instance == null) {
            instance = new LMSLogger();
        }
        return instance;
    }

    /**
     * Logs a message with a specified log level.
     * 
     * @param level the log level
     * @param message the log message
     */
    public void log(LogLevel level, String message) {
        LocalDateTime now = LocalDateTime.now();
        writer.printf("%s [%s] %s%n", dtf.format(now), level.name(), message);
        writer.flush();
    }

    /**
     * Logs an exception with a specified log level.
     * 
     * @param level the log level
     * @param message the log message
     * @param throwable the exception to log
     */
    public void log(LogLevel level, String message, Throwable throwable) {
        LocalDateTime now = LocalDateTime.now();
        writer.printf("%s [%s] %s - %s%n", dtf.format(now), level.name(), message, throwable.toString());
        for (StackTraceElement element : throwable.getStackTrace()) {
            writer.printf("\tat %s%n", element.toString());
        }
        writer.flush();
    }

    /**
     * Closes the logger.
     */
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
