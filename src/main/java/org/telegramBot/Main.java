package org.telegramBot;

public class Main {
    private static final String CONFIG_FILE = "src\\main\\resources\\config.properties";
    public static void main(String[] args) {
        String botToken = ConfigReader.getBotToken();
    }
}