package org.whiletrue.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public abstract class BaseCommand extends BotCommand {
    final Logger log = LoggerFactory.getLogger(BaseCommand.class);

    public BaseCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        log.info("execute::userId = {}, chatId = {}", user.getId(), chat.getId());
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] arguments) {
        log.info(message.getText());
        super.processMessage(absSender, message, arguments);
    }

    public void sendMessage(AbsSender absSender, SendMessage message, User user) {
        try {
            absSender.execute(message);
            log.info(String.valueOf(user.getId()));
        } catch (Exception exception) {
            log.warn(exception.getMessage());
        }
    }
}
