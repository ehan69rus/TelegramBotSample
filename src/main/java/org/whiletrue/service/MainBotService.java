package org.whiletrue.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.whiletrue.MainBot;

@Service
@AllArgsConstructor
public class MainBotService {
    static private final Logger log = LoggerFactory.getLogger(MainBotService.class);

    private final MainBot mainBot;

    public void start() {
        try {
            BotSession botSession = new DefaultBotSession();
            TelegramBotsApi botsApi = new TelegramBotsApi(botSession.getClass());

            botsApi.registerBot(mainBot);
            log.info("Bot successful started");
        } catch (Exception exception) {
            log.error("MainBotService::start {}", exception.getMessage());
        }
    }
}
