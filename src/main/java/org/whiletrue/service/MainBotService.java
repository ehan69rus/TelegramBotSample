package org.whiletrue.service;

import org.whiletrue.MainBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class MainBotService {
    static private final Logger log = LoggerFactory.getLogger(MainBotService.class);

    static public void start() {
        try {
            BotSession botSession = new DefaultBotSession();
            TelegramBotsApi botsApi = new TelegramBotsApi(botSession.getClass());

            String token = PropertiesService.getProperty("token")
                    .orElseThrow(() -> new RuntimeException("Не задан token"));

            botsApi.registerBot(new MainBot(token));
            log.info("Bot successful started");
        } catch (Exception exception) {
            log.error("MainBotService::start {}", exception.getMessage());
        }
    }
}
