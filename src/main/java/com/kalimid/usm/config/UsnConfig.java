package com.kalimid.usm.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsnConfig {
    
    @Bean
    public OpenAPI usmApi() {
        return new OpenAPI()
                .servers(List.of(new Server()
                        .url("http://localhost:8080")))
                .info(new Info()
                        .title("Микросервис Users Subscriptions Manager (USM)")
                        .description("Данный микросервис на Spring Boot 3 " +
                                    "предоставляет REST API для управления пользователями и их подписками на сервисы. "
                                + "Подписки представляют собой подписки на цифровые сервисы, такие как " +
                                "YouTube Premium, VK Музыка, Яндекс.Плюс, Netflix и другие стриминговые платформы."
                                + "\nAPI поддерживает следующие функции: \n" +
                                "- Создание пользователя\n" +
                                "- Получение информации о пользователе\n" +
                                "- Обновление данных пользователя\n" +
                                "- Удаление пользователя\n" +
                                "- Добавление подписки пользователю\n" +
                                "- Получение списка подписок пользователя\n" +
                                "- Удаление подписки")                       
                        .contact(new Contact()
                                .url("https://sites.google.com/view/kalimullinid/home")
                                .name("Ильнур Калимуллин")
                                .email("kalimid793@gmail.com"))
                        .summary("Микросервис USM, управляющий подписками пользователей")
                        .version("1.0"));
    }
}
