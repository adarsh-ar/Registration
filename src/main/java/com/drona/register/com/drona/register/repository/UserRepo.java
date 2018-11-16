package com.drona.register.com.drona.register.repository;

import com.drona.register.com.drona.register.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<UserDetails,String> {
    //User findByFirstName(String fname);
}
