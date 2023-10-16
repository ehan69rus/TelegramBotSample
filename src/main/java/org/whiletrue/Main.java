package org.whiletrue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.whiletrue.config.SpringConfig;
import org.whiletrue.service.MainBotService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        MainBotService botService = applicationContext.getBean(MainBotService.class);
        botService.start();
    }
}