# User Subscriptions Managing Microservice  
Микросервис на Spring Boot 3, предоставляющий REST API для управления пользователями и их подписками на сервисы.

Эндпоинты:

POST /users - создать пользователя
GET /users/{id} - получить информацию о пользователе
PUT /users/{id} - обновить пользователя
DELETE /users/{id} - удалить пользователя
POST /users/{id}/subscriptions - добавить подписку
GET /users/{id}/subscriptions - получить подписки пользователя
DELETE /users/{id}/subscriptions/{sub_id} - удалить подписку
GET /subscriptions/top - получить ТОП-3 популярных подписок

## В проекте использованы:  
Java 17;

Apache Maven;

Spring Boot;

Spring Web;

База данных PostgreSQL;

Docker;

Docker Compose;

Логирование с использованием SLF4J;

Полный список используемых зависимостей и версий компонентов можно найти в pom.xml
