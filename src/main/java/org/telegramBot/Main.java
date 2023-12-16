package org.telegramBot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class Main {
    private static final String CONFIG_FILE = "src\\main\\resources\\config.properties";
    public static void main(String[] args) {
        String botToken = ConfigReader.getBotToken();
        if (botToken != null){
            TelegramBot telegramBot = new TelegramBot(botToken);

            telegramBot.setUpdatesListener(updates -> {
                for (Update update : updates){
                    if (update.message() != null && update.message().from() != null){
                        SendMessage sendMessage = new SendMessage(update.message().from().id(), "Hello");
                        telegramBot.execute(sendMessage);
                    }
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            });
        } else {
            System.out.println("Bot token is not specified in the config.properties file.");
        }
    }
}