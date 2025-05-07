package com.kalimid.usm.repositories;

import com.kalimid.usm.entities.UserSubscriptions;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserSubRepository extends CrudRepository<UserSubscriptions, Long> {
    Iterable<UserSubscriptions> findAllById(Long ID);
    //UserSubscriptions saveByUserId(Long userID, UserSubscriptions userSub);
}
