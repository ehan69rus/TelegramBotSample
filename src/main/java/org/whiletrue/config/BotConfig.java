package org.whiletrue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.whiletrue.MainBot;
import org.whiletrue.service.PropertiesService;

@Configuration
public class BotConfig {
    @Bean
    public MainBot createMainBot() {
        String token = PropertiesService.getProperty("token")
                .orElseThrow(() -> new RuntimeException("Не задан token"));
        return new MainBot(token);
    }
}
