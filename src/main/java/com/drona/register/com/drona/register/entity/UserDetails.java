package com.drona.register.com.drona.register.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class UserDetails {
    private String firstName;
    private String lastName;
    private char gender;
    @Id
    @Indexed
    private String email;
    private int age;
    private String ph;
    private String password;
    @Indexed(unique = true)
    private String userName;

}
