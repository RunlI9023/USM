package com.kalimid.usm.repositories;

import com.kalimid.usm.entities.User;
import com.kalimid.usm.entities.UserSubscriptions;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserSubRepository extends CrudRepository<UserSubscriptions, Long> {
    //List<UserSubscriptions> findTop3ByName();
}
