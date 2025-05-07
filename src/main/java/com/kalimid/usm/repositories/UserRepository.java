package com.kalimid.usm.repositories;

import com.kalimid.usm.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
    
}
