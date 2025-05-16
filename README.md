# User Subscriptions Microservice (USM)
Микросервис на Spring Boot 3, предоставляющий REST API для управления пользователями и их подписками на сервисы.
## **Описание эндпоинтов:**
### **1. Создание пользователя**

**Endpoint:**
POST /users

**Описание:**
Создаем нового пользователя, путем ввода имени.

**Request Body:**
name (String): Отправляем имя пользователя

**Пример запроса:**
{"name": "Ильнур"}

**Ответ:**
200 OK.

### **2. Получение информации о пользователе**
Endpoint:
GET /users/{id}

Параметры запроса:

id (int): Идентификатор пользователя

Ответ:
{
  "id": 2,
  "name": "Ilnur",
  "subscriptions": []
}

3. Обновление информации о пользователе
Endpoint:
PUT /users/{id}

Описание:
Обновляем информацию о пользователе

Параметры запроса:

id (Long): Идентификатор пользователя;
name (String): Имя пользователя;

Пример запроса:

{
  "id": "2",
  "name":"Emir"
}

Ответ:
HTTP/1.1 200 OK;
{
  "id": 2,
  "name": "Emir",
  "subscriptions": []
}

4. Удаление пользователя
Endpoint:
DELETE /users/{id}

Описание:
Удаляем пользователя по его ID

Параметры запроса:

id (Long): Идентификатор пользователя

Пример запроса:

{
  "id": "2",
  "name":"Emir"
}

Ответ:
HTTP/1.1 200 OK.

5. Добавление подписки пользователю
Endpoint:
POST /users/{id}/subscriptions

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
