package com.cedaniel200.eribank.screenplay.models;

import com.cedaniel200.eribank.screenplay.models.builder.UserBuilder;

public class User {

    private final String username;
    private final String password;

    public User(UserBuilder builder) {
        this.username = builder.getUsername();
        this.password = builder.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
