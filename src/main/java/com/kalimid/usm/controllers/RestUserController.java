package com.kalimid.usm.controllers;

import com.kalimid.usm.entities.User;
import com.kalimid.usm.entities.UserSubscriptions;
import com.kalimid.usm.repositories.UserRepository;
import com.kalimid.usm.repositories.UserSubRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserController {
    
    private final UserRepository userRepository;
    private final UserSubRepository userSubRepository;
    Logger logger = LoggerFactory.getLogger(RestUserController.class);
    
    public RestUserController(UserRepository userRepository, UserSubRepository userSubRepository) {
        this.userRepository = userRepository;
        this.userSubRepository = userSubRepository;
    }
    
    @Tag(name = "GET", description = "GET-методы")
    @Operation(summary = "Получаем всех пользователей", description = "возвращает всех пользователей в БД")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Список пользователей получен")})
    @GetMapping("/users")
    Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    
    @Tag(name = "GET", description = "GET-методы")
    @Operation(summary = "Получаем пользователя по его ID", 
            description = "Принимает ID пользователя в запросе, выполняет поиск в БД и возвращает найденного пользователя")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Пользователь найден"),
        @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    @GetMapping("/users/{id}")
    Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }
    
    @Tag(name = "POST", description = "POST-методы")
    @Operation(summary = "Сохраняем нового пользователя", description = "Приниемаем имя пользователя и сохраняем его в БД")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Новый пользователь успешно создан")})
    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        userRepository.save(user);
        logger.info("Создан новый пользователь {}", user.getName());
    }
    
    @Tag(name = "PUT", description = "PUT-методы")
    @Operation(summary = "Обновляем существующего пользователя", 
            description = "Принимает новые данные и обновляет существующего пользователя")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Пользователь успешно обновлен"),
        @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    @PutMapping("/users/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) { 
        User updateUser = userRepository.findById(id).orElseThrow();
        logger.info("Обновление пользователя {} на {}", updateUser.getName(),user.getName());
        updateUser.setId(user.getId());
        updateUser.setName(user.getName());
        userRepository.save(updateUser);
        
        return ResponseEntity.ok(updateUser);
    }
    
    @Tag(name = "DELETE", description = "DELETE-методы")
    @Operation(summary = "Удаляем существующего пользователя",
            description = "Принимает ID пользователя в запросе, выполняет поиск в БД и удаляет соответствующего пользователя")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Пользователь успешно удален"),
        @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        logger.info("Удален пользователь {}", userRepository.findById(id).get().getName());
        userRepository.deleteById(id);
    }
    
    @Tag(name = "GET", description = "GET-методы")
    @Operation(summary = "Получаем список всех подписок пользователя",
            description = "Принимает ID пользователя в запросе, выполняет поиск в БД и возвращает список подписок соответствующего пользователя")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Подписка для пользователя найдена"),
        @ApiResponse(responseCode = "404", description = "Подписка для пользователя не найдена")})
    @GetMapping("/users/{id}/subscriptions")
    Iterable<UserSubscriptions> getUserSubscriptionsById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get().getSubscriptions();
    }
    
    @Tag(name = "POST", description = "POST-методы")
    @Operation(summary = "Добавляет подписку пользователю",
            description = "Принимает ID пользователя в запросе, выполняет поиск в БД и добавляет подписку соответствующему пользователю")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Подписка для пользователя успешно создана"),
        @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    @PostMapping("/users/{id}/subscriptions")
    public void saveUserSub(@PathVariable Long id, @RequestBody UserSubscriptions userSub) {
        User user = userRepository.findById(id).orElseThrow();
        user.getSubscriptions().add(userSub);
        userRepository.save(user);
        logger.info("Добавлена новая подписка {} пользователю {}", userSub.getName(), user.getName());
    }
    
    @Tag(name = "DELETE", description = "DELETE-методы")
    @Operation(summary = "Удаляет подписку пользователю",
            description = "Принимает ID пользователя и ID подписки в запросе, выполняет поиск в БД и удаляет соотвествующую подписку соответствующему пользователю")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Подписка для пользователя успешно удалена"),
        @ApiResponse(responseCode = "404", description = "Пользователь не найден")})
    @DeleteMapping("/users/{id}/subscriptions/{sub_id}")
    public void deleteUserSub(@PathVariable Long id, @PathVariable Long sub_id) {
        logger.info("Подписка на {} для пользователя {} удалена", userSubRepository.findById(sub_id).get().getName(),userRepository.findById(id).get().getName());
        userSubRepository.deleteById(sub_id);
    }
    
    @Tag(name = "GET", description = "GET-методы")
    @Operation(summary = "Получает топ-3 подписок по всем пользователям", description = "Возвращает топ-3 подписок всех пользователей из БД")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "ТОП-3 подписок получены"),
        @ApiResponse(responseCode = "404", description = "Подписки не найдены")})
    @GetMapping("/subscriptions/top")
    Iterable<UserSubscriptions> getTopSubscriptions() {
        
        return userSubRepository.findAll();
    }
}
