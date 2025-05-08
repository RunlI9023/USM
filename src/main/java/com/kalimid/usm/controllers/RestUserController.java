package com.kalimid.usm.controllers;

import com.kalimid.usm.entities.User;
import com.kalimid.usm.entities.UserSubscriptions;
import com.kalimid.usm.repositories.UserRepository;
import com.kalimid.usm.repositories.UserSubRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
    
    @GetMapping("/users")
    Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/users/{id}")
    Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }
    
    @PostMapping("/users")
    User saveUser(@RequestBody User user) {
        logger.info("Создан новый пользователь");
        return userRepository.save(user);
        
    }
    
    @PutMapping("/users/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        logger.info("Обновление пользователя");
        return (userRepository.existsById(id))
        ? new ResponseEntity<>(userRepository.save(user), HttpStatus.OK)
        : new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
}
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        logger.info("Удален пользователь {}", userRepository.findById(id).get().getName());
        userRepository.deleteById(id);
    }
    
    @GetMapping("/users/{id}/subscriptions")
    Iterable<UserSubscriptions> getUserSubscriptionsById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get().getSubscriptions();
    }
    
    @PostMapping("/users/{id}/subscriptions")
    UserSubscriptions saveUserSub(@PathVariable Long id, @RequestBody UserSubscriptions userSub) {
        Optional<User> user = userRepository.findById(id);
        user.get().getSubscriptions().add(userSub);
        logger.info("Добавлена новая подписка пользователю {}", user.get().getName());
        return userSubRepository.save(userSub);
    }
    
    @DeleteMapping("/users/{id}/subscriptions/{sub_id}")
    public void deleteUserSub(@PathVariable Long id, @PathVariable Long sub_id) {
        logger.info("Подписка для пользователя {} удалена", userRepository.findById(id).get().getName());
        userSubRepository.deleteById(sub_id);
    }
    
    @GetMapping("/subscriptions/top")
    Iterable<UserSubscriptions> getTopSubscriptions() {
        return userSubRepository.findAll();
    }
}
