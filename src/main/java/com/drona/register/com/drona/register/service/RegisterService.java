package com.drona.register.com.drona.register.service;

import com.drona.register.com.drona.register.entity.UserDetails;
import com.drona.register.com.drona.register.pojo.Response;
import com.drona.register.com.drona.register.pojo.User;
import com.drona.register.com.drona.register.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class RegisterService {
    @Autowired
    UserRepo userRepo;
    public Response addUser(User user){
        Response response=new Response();
        if(!validateUser(user)) {
            UserDetails userEntity = new UserDetails();
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setAge(user.getAge());
            userEntity.setEmail(user.getEmail());
            userEntity.setGender(user.getGender());
            userEntity.setPh(user.getPh());
            userEntity.setPassword(hashPassword(user.getPassword()));
            userRepo.save(userEntity);
            if(validateUser(user)) {
                response.setResponseCode(200);
                response.setResponseMessage("Success");
            } else {
                response.setResponseCode(500);
                response.setResponseMessage("Failed while inserting");
            }
        } else {
            response.setResponseCode(300);
            response.setResponseMessage("Duplicate Entry");
        }

        return response;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean validateUser(User user) {
        if(userRepo.findById(user.getEmail())!=null)
            return true;
         else
          return false;
    }
}
