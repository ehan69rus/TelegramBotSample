package org.whiletrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.whiletrue.command.StartCommand;
import org.whiletrue.service.PropertiesService;

public class MainBot extends TelegramLongPollingCommandBot {
    final Logger log = LoggerFactory.getLogger(MainBot.class);

    private final String botName = PropertiesService.getProperty("bot_user_name").orElseThrow();

    public MainBot(String token) {
        super(token);

        registerCommands();
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        log.info("processNonCommandUpdate::message = {}, chatId = {}", update.getMessage().getText(), update.getMessage().getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Ошибка обработки команды");

        try {
            execute(sendMessage);
        } catch (TelegramApiException exception) {
            log.info(exception.getMessage());
        }
    }

    private void registerCommands() {
        register(new StartCommand());
    }
}
