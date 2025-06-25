package com.mutlukodcu.kkka.kafkaconsumer.util;

public class LoggingUtils {

    public static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void logError(String message) {
        System.err.println("[ERROR] " + message);
    }
}
